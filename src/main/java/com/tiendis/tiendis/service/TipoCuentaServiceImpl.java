package com.tiendis.tiendis.service;

import com.tiendis.tiendis.commons.GenericServiceImpl;
import com.tiendis.tiendis.entity.TipoCuenta;
import com.tiendis.tiendis.DAO.TipoCuentaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoCuentaServiceImpl extends GenericServiceImpl<TipoCuenta, Long> implements TipoCuentaService {

    @Autowired
    private TipoCuentaDAO tipoCuentaDAO;

    @Override
    public CrudRepository<TipoCuenta, Long> getDao() {
        return tipoCuentaDAO;
    }
}
