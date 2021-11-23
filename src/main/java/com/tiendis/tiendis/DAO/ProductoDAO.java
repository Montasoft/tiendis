package com.tiendis.tiendis.DAO;

import com.tiendis.tiendis.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductoDAO extends PagingAndSortingRepository<Producto, Integer> {



}
