package com.tiendis.tiendis.Repository;

import com.tiendis.tiendis.entity.SubCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoriaRepository extends JpaRepository <SubCategoria, Long> {
}