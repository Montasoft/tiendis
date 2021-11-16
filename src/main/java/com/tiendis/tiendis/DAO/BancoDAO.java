package com.tiendis.tiendis.DAO;

import com.tiendis.tiendis.entity.Banco;
import org.springframework.data.repository.CrudRepository;

public interface BancoDAO extends CrudRepository<Banco, Integer> {
}
