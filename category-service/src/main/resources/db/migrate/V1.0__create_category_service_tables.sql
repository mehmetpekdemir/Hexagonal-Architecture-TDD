-- ================== ==================--
--            category_jpa_entity       --
-- ================== ==================--

/**
CREATE TABLE category_jpa_entity
(
    id   INTEGER  NOT NULL AUTO_INCREMENT,
    name CHAR(50) NOT NULL,
    CONSTRAINT id_category_jpa_entity PRIMARY KEY category_jpa_entity (id),
    CONSTRAINT UNIQUE KEY uk_category_jpa_entity (name)
)
*/
