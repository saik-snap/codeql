package com.mybank.registration.archunit;

import com.mybank.archunit.AbstractArchUnitTests;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;

@AnalyzeClasses(packages = "com",
        importOptions = {ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class})
public class ArchUnitTests extends AbstractArchUnitTests {

}
