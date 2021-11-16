package com.tiendis.tiendis.service.Implement;

import com.tiendis.tiendis.DAO.EstadoCarritoDAO;
import com.tiendis.tiendis.commons.GenericServiceImpl;
import com.tiendis.tiendis.entity.EstadoCarrito;
import com.tiendis.tiendis.service.EstadoCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EstadoCarritoServiceImpl extends GenericServiceImpl<EstadoCarrito, Integer> implements EstadoCarritoService {

    @Autowired
    private EstadoCarritoDAO estadoCarritoDAO;

    @Override
    public CrudRepository<EstadoCarrito, Integer> getDao() {
        return estadoCarritoDAO;
    }
}
