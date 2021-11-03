package com.tiendis.tiendis.Repository;

import com.tiendis.tiendis.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository  extends JpaRepository <Categoria, Long> {


}
