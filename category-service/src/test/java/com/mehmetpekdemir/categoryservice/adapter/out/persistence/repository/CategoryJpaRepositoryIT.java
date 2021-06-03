package com.mehmetpekdemir.categoryservice.adapter.out.persistence.repository;

import com.mehmetpekdemir.categoryservice.adapter.out.persistence.entity.CategoryJpaEntity;
import com.mehmetpekdemir.categoryservice.adapter.out.persistence.entity.Status;
import com.mehmetpekdemir.categoryservice.common.AbstractTestContainer;
import com.mehmetpekdemir.categoryservice.common.TestContainer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@TestContainer
class CategoryJpaRepositoryIT extends AbstractTestContainer {

    @Autowired
    private CategoryJpaRepository categoryJpaRepository;

    @Test
    void it_should_success_category_create_when_category_called_with_valid_request() {
        //given
        final String uuid = UUID.randomUUID().toString();
        final var status = Status.of("active");

        final var categoryJpaEntity = new CategoryJpaEntity();
        categoryJpaEntity.setParentId(null);
        categoryJpaEntity.setUuid(uuid);
        categoryJpaEntity.setName("category name");
        categoryJpaEntity.setDescription("category description");
        categoryJpaEntity.setStatus(status.get());

        final var persistedCategory = testEntityManager.persistAndFlush(categoryJpaEntity);

        //when
        final var foundCategory = categoryJpaRepository.findById(persistedCategory.getId()).get();

        //then
        assertThat(foundCategory.getParentId()).isNull();
        assertThat(foundCategory.getUuid()).isEqualTo(uuid);
        assertThat(foundCategory.getName()).isEqualTo("category name");
        assertThat(foundCategory.getDescription()).isEqualTo("category description");
        assertThat(foundCategory.getStatus()).isEqualTo(status.get());
        assertThat(foundCategory.getCreatedAt()).isNotNull();
        assertThat(foundCategory.getModifiedAt()).isNotNull();
    }

}