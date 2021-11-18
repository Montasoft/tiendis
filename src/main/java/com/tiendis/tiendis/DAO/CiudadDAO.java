package com.tiendis.tiendis.DAO;

import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.entity.Ciudad;
import org.springframework.data.repository.CrudRepository;

public interface CiudadDAO extends CrudRepository<Ciudad, String> {
}
