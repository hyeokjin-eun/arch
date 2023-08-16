package com.example.arch.arch.board.ddd;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Repository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.example.arch.ddd")
public class RepositoryDDDArchTest {

    @ArchTest
    ArchRule Repository_이름이_붙은_Repository_는_repository_패키지에_있어야_한다 = classes()
            .that().haveSimpleNameEndingWith("Repository")
            .should().resideInAPackage("..repository..");

    @ArchTest
    ArchRule Repository_에서는_Repository_어노테이션이_있어야_한다 = classes()
            .that().haveSimpleNameEndingWith("Repository")
            .should().beAnnotatedWith(Repository.class);

    @ArchTest
    ArchRule Repository_어노테이션이_붙은_Repository_는_repository_패키지에_있어야_한다 = classes()
            .that().areAnnotatedWith(Repository.class)
            .should().resideInAPackage("..repository");
}
