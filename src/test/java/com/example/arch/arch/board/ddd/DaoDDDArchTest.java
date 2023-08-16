package com.example.arch.arch.board.ddd;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Component;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.example.arch.ddd")
public class DaoDDDArchTest {

    @ArchTest
    ArchRule Dao_이름을_가진_클래스는_dao_패키지에_있어야한다 = classes()
            .that().haveSimpleNameContaining("Dao")
            .should().resideInAPackage("..dao..");

    @ArchTest
    ArchRule DaoImpl_이름을_가진_클래스는_dao_하위_impl_패키지에_있어야_한다 = classes()
            .that().haveSimpleNameEndingWith("DaoImpl")
            .should().resideInAPackage("..dao.impl..");

    @ArchTest
    ArchRule DaoImpl_에서는_Component_어노테이션이_있어야_한다 = classes()
            .that().haveSimpleNameEndingWith("DaoImpl")
            .should().beAnnotatedWith(Component.class);
}
