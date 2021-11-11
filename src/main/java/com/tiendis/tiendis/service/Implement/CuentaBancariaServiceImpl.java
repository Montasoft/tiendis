package com.tiendis.tiendis.service.Implement;

import com.tiendis.tiendis.DAO.CuentaBancariaDAO;
import com.tiendis.tiendis.commons.GenericServiceImpl;
import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.entity.CuentaBancaria;
import com.tiendis.tiendis.service.CuentaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CuentaBancariaServiceImpl extends GenericServiceImpl<CuentaBancaria, Long> implements CuentaBancariaService {

    @Autowired
    private CuentaBancariaDAO cuentaBancariaDAO;

    @Override
    public CrudRepository<CuentaBancaria, Long> getDao(){
        return cuentaBancariaDAO;
    }
}
