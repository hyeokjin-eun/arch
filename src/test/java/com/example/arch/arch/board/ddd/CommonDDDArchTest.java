package com.example.arch.arch.board.ddd;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.beans.factory.annotation.Autowired;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noFields;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.example.arch.ddd")
public class CommonDDDArchTest {

    @ArchTest
    ArchRule Mvc_Layered_Architecture_를_따른다 = layeredArchitecture()
            .layer("Controller").definedBy("..controller..")
            .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
            .layer("Service").definedBy("..service..")
            .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
            .layer("Dao").definedBy("..dao..")
            .whereLayer("Dao").mayOnlyBeAccessedByLayers("Service")
            .layer("Persistence").definedBy("..repository..")
            .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Dao");

    @ArchTest
    ArchRule 모든_field_는_Autowired_어노테이션을_사용하지_않는다 = noFields()
            .should().beAnnotatedWith(Autowired.class);
}
