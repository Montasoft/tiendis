package com.tiendis.tiendis.DAO;

import com.tiendis.tiendis.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDAO extends CrudRepository<Producto, Integer> {
}
