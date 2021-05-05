package com.mehmetpekdemir.categoryservice.adapter.out.persistence.repository;

import com.mehmetpekdemir.categoryservice.adapter.out.persistence.entity.CategoryJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Repository
public interface CategoryJpaRepository extends JpaRepository<CategoryJpaEntity, Long> {

}
