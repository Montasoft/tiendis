package com.tiendis.tiendis.DAO;

import com.tiendis.tiendis.entity.Carrito;
import org.springframework.data.repository.CrudRepository;

public interface CarritoDao extends CrudRepository<Carrito, Long> {
}
