package com.tiendis.tiendis.service.Implement;

import com.tiendis.tiendis.DAO.TipoComercioDAO;
import com.tiendis.tiendis.commons.GenericServiceImpl;
import com.tiendis.tiendis.entity.TipoComercio;
import com.tiendis.tiendis.service.TipoComercioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoComercioServiceImpl extends GenericServiceImpl<TipoComercio, Long> implements TipoComercioService {

    @Autowired
    private TipoComercioDAO tipoComercioDAO;

    @Override
    public CrudRepository<TipoComercio, Long> getDao() {
        return tipoComercioDAO;
    }
}
