package com.tiendis.tiendis.DAO;

import com.tiendis.tiendis.entity.Ciudad;
import com.tiendis.tiendis.entity.Departamento;
import org.springframework.data.repository.CrudRepository;

public interface DepartamentoDAO extends CrudRepository<Departamento, String> {
}
