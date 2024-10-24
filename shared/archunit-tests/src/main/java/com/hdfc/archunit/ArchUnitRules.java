package com.hdfc.archunit;

import com.tngtech.archunit.core.domain.*;
import com.tngtech.archunit.lang.*;
import com.tngtech.archunit.library.GeneralCodingRules;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

public abstract class ArchUnitRules {

    public static ArchRule onlyPostMappingAllowed() {
        return methods()
                .that()
                .arePublic()
                .and()
                .areDeclaredInClassesThat()
                .areAnnotatedWith("org.springframework.web.bind.annotation.RestController")
                .should()
                .beAnnotatedWith("org.springframework.web.bind.annotation.PostMapping")
                .because("We only have to use @PostMapping");
    }

    public static ArchRule utilsClassesShouldNotBeInjected() {
        Set<String> utilClassSuffixSet = createUtilClassSet();
        ClassesTransformer<JavaClass> utilClasses =
                new AbstractClassesTransformer<JavaClass>("utility class") {
                    @Override
                    public Iterable<JavaClass> doTransform(JavaClasses classes) {
                        Set<JavaClass> result = new HashSet<>();
                        for (JavaClass javaClass : classes) {
                            boolean utilClass = utilClassSuffixSet.stream().anyMatch(javaClass.getSimpleName()::endsWith);
                            if (utilClass) {
                                result.add(javaClass);
                            }
                        }
                        return result;
                    }
                };

        ArchCondition<JavaClass> beInjected = new ArchCondition<JavaClass>("be injected") {
            @Override
            public void check(JavaClass javaClass, ConditionEvents events) {
                Set<JavaAccess<?>> accessesToSelf = javaClass.getAccessesToSelf();
                com.tngtech.archunit.base.Optional<JavaAnnotation<JavaClass>> hasComponentAnnotation = javaClass.tryGetAnnotationOfType("org.springframework.stereotype.Component");
                com.tngtech.archunit.base.Optional<JavaAnnotation<JavaClass>> hasInjectAnnotation = javaClass.tryGetAnnotationOfType("javax.inject.Inject");
                String message = String.format("%s is annotated with @Component/@Inject annotation", javaClass.getFullName());
                events.add(new SimpleConditionEvent(javaClass, hasComponentAnnotation.isPresent() || hasInjectAnnotation.isPresent(), message));
            }
        };
        return no(utilClasses)
                .should(beInjected);

    }

    public static ArchRule utilClassesMethodsShouldBeStatic() {
        Set<String> utilClassSuffixSet = createUtilClassSet();
        ClassesTransformer<JavaMethod> utilClassesMethods =
                new AbstractClassesTransformer<JavaMethod>("utility class methods") {
                    @Override
                    public Iterable<JavaMethod> doTransform(JavaClasses classes) {
                        Set<JavaMethod> result = new HashSet<>();
                        for (JavaClass javaClass : classes) {
                            boolean utilClass = utilClassSuffixSet.stream().anyMatch(javaClass.getSimpleName()::endsWith);
                            if (utilClass) {
                                result.addAll(javaClass.getMethods());
                            }
                        }
                        return result;
                    }
                };

        ArchCondition<JavaMethod> beStatic = new ArchCondition<JavaMethod>("be static") {
            @Override
            public void check(JavaMethod javaMethod, ConditionEvents events) {
                boolean staticAccess = javaMethod.getModifiers().contains(JavaModifier.STATIC);
                String message = String.format("%s is not static", javaMethod.getFullName());
                events.add(new SimpleConditionEvent(javaMethod, staticAccess, message));
            }
        };
        return all(utilClassesMethods)
                .should(beStatic);
    }

    public static ArchRule layersShouldBeFreeOfCycles() {
        return slices()
                .matching("com.hdfc.(*)..")
                .should().beFreeOfCycles();
    }

    public static ArchRule noPublicField() {
        return fields().that().areNotStatic().or().areNotFinal().should().notBePublic()
                .because("you should respect encapsulation");
    }

    public static ArchRule noExceptionPrintStacktrace() {
        return GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;
    }

    public static ArchRule allPublicMethodsInControllersReturnApiResponseWrapper() {
        return methods()
                .that()
                .areDeclaredInClassesThat()
                .resideInAPackage("..controller..")
                .and().arePublic()
                .should()
                .haveRawReturnType("org.springframework.http.ResponseEntity")
                .orShould(new ArchCondition<JavaMethod>("return CompletableFuture<ApiResponse>") {
                    @Override
                    public void check(JavaMethod item, ConditionEvents events) {
                        Type genericReturnType = item.reflect().getGenericReturnType();
                        if (genericReturnType instanceof ParameterizedType gre) {
                            Type[] actualTypeArguments = gre.getActualTypeArguments();
                            for (Type actualTypeArgument : actualTypeArguments) {
                                if (!actualTypeArgument.getTypeName().equals("com.hdfc.rest.commons.ApiResponse<?>")) {
                                    events.add(new SimpleConditionEvent(item, false, "return CompletableFuture<ApiResponse>"));
                                }
                            }
                        } else {
                            events.add(new SimpleConditionEvent(item, false, "return CompletableFuture<ApiResponse>"));
                        }
                    }
                })
                .because("we want to return API responses in a standard format");
    }

    private static Set<String> createUtilClassSet(String... utilClassSuffixes) {
        Set<String> utilClassSuffixSet = new HashSet<>();
        if (utilClassSuffixes == null || utilClassSuffixes.length == 0) {
            utilClassSuffixSet.add("Util");
            utilClassSuffixSet.add("Utils");
        } else {
            utilClassSuffixSet.addAll(Arrays.asList(utilClassSuffixes));
        }
        return utilClassSuffixSet;
    }

}