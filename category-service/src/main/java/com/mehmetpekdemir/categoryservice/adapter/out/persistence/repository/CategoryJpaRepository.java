package com.mehmetpekdemir.categoryservice.adapter.out.persistence.repository;

import com.mehmetpekdemir.categoryservice.adapter.out.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Repository
public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {

    boolean existsByName(String name);

    List<CategoryEntity> findAllByParentIdIsNotNull();

}
