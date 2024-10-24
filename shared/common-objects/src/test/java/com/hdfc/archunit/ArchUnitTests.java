package com.hdfc.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.hdfc", importOptions = {ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class})
public class ArchUnitTests {

    @ArchTest
    public void only_jackson_and_commons_lang_is_allowed(JavaClasses javaClasses) {
        classes()
                .that()
                .resideInAPackage("com.hdfc..")
                .should()
                .onlyDependOnClassesThat()
                .resideInAnyPackage("java..",
                        "javax.servlet.http..",
                        "org.apache.commons.lang3",
                        "com.fasterxml.jackson.annotation..",
                        "com.hdfc..",
                        "lombok..",
                        "feign",
                        "org..")
                .check(javaClasses);

    }

}
