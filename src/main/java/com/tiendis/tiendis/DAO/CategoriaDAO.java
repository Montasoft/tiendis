package com.tiendis.tiendis.DAO;

import com.tiendis.tiendis.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaDAO extends CrudRepository<Categoria, Integer> {
}
