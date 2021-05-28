package com.mehmetpekdemir.categoryservice.adapter.out.persistence.repository;

import com.mehmetpekdemir.categoryservice.adapter.out.persistence.entity.CategoryJpaEntity;
import com.mehmetpekdemir.categoryservice.common.AbstractTestContainer;
import com.mehmetpekdemir.categoryservice.common.TestContainer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@TestContainer
class CategoryJpaRepositoryIT extends AbstractTestContainer {

    @Autowired
    private CategoryJpaRepository categoryJpaRepository;

    @Test
    void it_should_create_category() {
        //given
        final var categoryJpaEntity = new CategoryJpaEntity();
        categoryJpaEntity.setName("category name");
        final var persistedCategory = testEntityManager.persistAndFlush(categoryJpaEntity);

        //when
        final var foundCategory = categoryJpaRepository.findById(persistedCategory.getId()).get();

        //then
        then(foundCategory.getName()).isEqualTo("category name");
    }

}