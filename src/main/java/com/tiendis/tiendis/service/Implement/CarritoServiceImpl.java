package com.tiendis.tiendis.service.Implement;

import com.tiendis.tiendis.DAO.CarritoDao;
import com.tiendis.tiendis.DAO.ClienteDAO;
import com.tiendis.tiendis.commons.GenericServiceImpl;
import com.tiendis.tiendis.entity.Carrito;
import com.tiendis.tiendis.entity.Cliente;
import com.tiendis.tiendis.service.CarritoService;
import com.tiendis.tiendis.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CarritoServiceImpl extends GenericServiceImpl<Carrito, Long> implements CarritoService {

    @Autowired
    private CarritoDao carritoDao;

    @Override
    public CrudRepository<Carrito, Long> getDao() {
        return carritoDao;
    }
}
