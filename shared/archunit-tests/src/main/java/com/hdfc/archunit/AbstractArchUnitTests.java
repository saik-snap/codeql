package com.hdfc.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.conditions.ArchPredicates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.tngtech.archunit.base.DescribedPredicate.not;
import static com.tngtech.archunit.core.domain.JavaClass.Predicates.belongToAnyOf;

public class AbstractArchUnitTests {

    private Logger logger = LoggerFactory.getLogger(AbstractArchUnitTests.class);

    @ArchTest
    public void only_post_mappings_are_allowed(JavaClasses javaClasses) {
        Class<?> ignoreClass = null;
        try {
            ignoreClass = Class.forName(""); // classname should define here
        } catch (ClassNotFoundException e) {
            logger.info("Ignoring ClassNotFoundException. {}", e.getMessage());
        }
        if (ignoreClass != null) {
            javaClasses =
                    javaClasses.that(ArchPredicates.are(not(belongToAnyOf(ignoreClass))));
        }
        try {
            ignoreClass = Class.forName("");  // classname should define here
        } catch (ClassNotFoundException e) {
            logger.info("Ignoring ClassNotFoundException. {}", e.getMessage());
        }
        if (ignoreClass != null) {
            javaClasses =
                    javaClasses.that(ArchPredicates.are(not(belongToAnyOf(ignoreClass))));
        }
        ArchUnitRules.onlyPostMappingAllowed().check(javaClasses);
    }

    //@ArchTest
    public void utils_classes_should_only_have_static_methods(JavaClasses javaClasses) {
        ArchUnitRules.utilClassesMethodsShouldBeStatic().check(javaClasses);
    }

    @ArchTest
    public void utils_classes_should_not_be_injected(JavaClasses javaClasses) {
        ArchUnitRules.utilsClassesShouldNotBeInjected().check(javaClasses);
    }

    @ArchTest
    public void layers_should_be_free_of_cycles(JavaClasses javaClasses) {
        ArchUnitRules.layersShouldBeFreeOfCycles().check(javaClasses);
    }

   // @ArchTest
    public void classes_should_not_have_public_fields(JavaClasses javaClasses) {
        ArchUnitRules.noPublicField().check(javaClasses);
    }

    //@ArchTest
    public void should_not_call_exception_print_stacktrace(JavaClasses javaClasses) {
        ArchUnitRules.noExceptionPrintStacktrace().check(javaClasses);
    }

    @ArchTest
    public void all_public_methods_in_the_controllers_should_return_API_response_wrappers(JavaClasses javaClasses) {
        ArchUnitRules.allPublicMethodsInControllersReturnApiResponseWrapper().check(javaClasses);
    }
}
