package com.example.arch.arch.board.mvc;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.example.arch.mvc")
public class ServiceMvcArchTest {

    @ArchTest
    ArchRule Service_이름을_가진_클래스는_service_패키지에_있어야_한다 = classes()
            .that().haveSimpleNameContaining("Service")
            .should().resideInAPackage("..service..");

    @ArchTest
    ArchRule ServiceImpl_이름을_가진_클래스는_service_하위_impl_패키지에_있어야_한다 = classes()
            .that().haveSimpleNameEndingWith("ServiceImpl")
            .should().resideInAPackage("..service.impl..");

    @ArchTest
    ArchRule ServiceImpl_에서는_Service_어노테이션이_있어야_한다 = classes()
            .that().haveSimpleNameEndingWith("ServiceImpl")
            .should().beAnnotatedWith(Service.class);

    @ArchTest
    ArchRule Service_어노테이션이_붙은_ServiceImpl_은_service_하위_impl_패키지에_있어야_한다 = classes()
            .that().areAnnotatedWith(Service.class)
            .should().resideInAPackage("..service.impl..");
}
