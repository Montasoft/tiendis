package com.tiendis.tiendis.service.Implement;

import com.tiendis.tiendis.DAO.TipoClienteDAO;
import com.tiendis.tiendis.commons.GenericServiceImpl;

import com.tiendis.tiendis.entity.TipoCliente;
import com.tiendis.tiendis.service.TipoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoClienteServiceImpl extends GenericServiceImpl<TipoCliente, Integer> implements TipoClienteService {

    @Autowired
    private TipoClienteDAO tipoClienteDAO;

    @Override
    public CrudRepository<TipoCliente, Integer> getDao() {
        return tipoClienteDAO;
    }
}
