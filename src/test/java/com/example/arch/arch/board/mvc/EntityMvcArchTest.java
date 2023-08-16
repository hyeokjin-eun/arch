package com.example.arch.arch.board.mvc;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import jakarta.persistence.Entity;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.example.arch.mvc")
public class EntityMvcArchTest {

    @ArchTest
    ArchRule Entity_이름이_붙은_Entity_는_entity_패키지_안에_있어야_한다 = classes()
            .that().haveSimpleNameEndingWith("Entity")
            .should().resideInAPackage("..entity");

    @ArchTest
    ArchRule Entity_이름이_붙은_Entity_는_Entity_어노테이션을_가져야_한다 = classes()
            .that().haveSimpleNameEndingWith("Entity")
            .should().beAnnotatedWith(Entity.class);

    @ArchTest
    ArchRule Entity_어노테이션이_붙은_Entity_는_entity_패키지_안에_있어야_한다 = classes()
            .that().areAnnotatedWith(Entity.class)
            .should().resideInAPackage("..entity..");
}
