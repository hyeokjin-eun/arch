package com.example.arch.arch.board.mvc;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.example.arch.mvc")
public class ControllerMvcArchTest {

    @ArchTest
    ArchRule Controller_이름을_가진_클래스는_controller_패키지에_있어야_한다 = classes()
            .that().haveSimpleNameEndingWith("Controller")
            .should().resideInAPackage("..controller..");

    @ArchTest
    ArchRule Controller_에서는_RestController_어노테이션이_있어야_한다 = classes()
            .that().haveSimpleNameEndingWith("Controller")
            .should().beAnnotatedWith(RestController.class);

    @ArchTest
    ArchRule RestController_어노테이션은_Controller_이름을_가져야_한다 = classes()
            .that().areAnnotatedWith(RestController.class)
            .should().haveSimpleNameEndingWith("Controller");

    @ArchTest
    ArchRule RestController_어노테이션이_붙은_Controller_는_controller_패키지에_있어야_한다 = classes()
            .that().areAnnotatedWith(RestController.class)
            .should().resideInAPackage("..controller..");
}
