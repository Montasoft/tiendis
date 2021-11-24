package com.tiendis.tiendis.service;

import com.tiendis.tiendis.commons.GenericServiceApi;
import com.tiendis.tiendis.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService extends GenericServiceApi<Cliente, Integer> {

    Page<Cliente> getAll(Pageable pageable);
}
