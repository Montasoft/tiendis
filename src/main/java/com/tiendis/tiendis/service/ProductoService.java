package com.tiendis.tiendis.service;

import com.tiendis.tiendis.commons.GenericServiceApi;
import com.tiendis.tiendis.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductoService extends GenericServiceApi<Producto, Integer> {

    Page<Producto> getAll(Pageable pageable);

}
