package com.tiendis.tiendis.DAO;

import com.tiendis.tiendis.entity.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClienteDAO extends PagingAndSortingRepository<Cliente, Integer> {
}
