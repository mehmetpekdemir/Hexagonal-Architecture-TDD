package com.mehmetpekdemir.categoryservice.adapter.out.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "category_entity")
public class CategoryEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parent_id", length = 50)
    private String parentId;

    @Column(name = "uuid", length = 50, nullable = false, unique = true)
    private String uuid;

    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

    @Column(name = "description", length = 50, nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 25, nullable = false)
    private Status status;

}
