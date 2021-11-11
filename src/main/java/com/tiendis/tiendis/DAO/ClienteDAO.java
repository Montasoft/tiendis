package com.tiendis.tiendis.DAO;

import com.tiendis.tiendis.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends CrudRepository<Cliente, Long> {
}
