package com.tiendis.tiendis.service.Implement;

import com.tiendis.tiendis.DAO.CarritoDetalleDAO;
import com.tiendis.tiendis.commons.GenericServiceImpl;
import com.tiendis.tiendis.entity.CarritoDetalle;
import com.tiendis.tiendis.service.CarritoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CarritoDetalleServiceImpl extends GenericServiceImpl<CarritoDetalle, Integer> implements CarritoDetalleService {

    @Autowired
    private CarritoDetalleDAO carritoDetalleDAO;

    @Override
    public CrudRepository<CarritoDetalle, Integer> getDao() {
        return carritoDetalleDAO;
    }
}
