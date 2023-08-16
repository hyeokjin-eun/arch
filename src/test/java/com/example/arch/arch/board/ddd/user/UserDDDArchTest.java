package com.example.arch.arch.board.ddd.user;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.example.arch.ddd.user")
public class UserDDDArchTest {

    @ArchTest
    ArchRule user_패키지_안에_있는_class_는_User_이름으로_시작해야_한다 = classes()
            .should().haveSimpleNameStartingWith("User");

    @ArchTest
    ArchRule user_패키지는_user_패키지에서만_접근이_가능하다 = classes()
            .should().onlyBeAccessed().byAnyPackage("..user..");
}
