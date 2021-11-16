package com.tiendis.tiendis.service.Implement;

import com.tiendis.tiendis.DAO.EstadoCarritoDAO;
import com.tiendis.tiendis.DAO.FormaPagoDAO;
import com.tiendis.tiendis.commons.GenericServiceImpl;
import com.tiendis.tiendis.entity.EstadoCarrito;
import com.tiendis.tiendis.entity.FormaPago;
import com.tiendis.tiendis.service.EstadoCarritoService;
import com.tiendis.tiendis.service.FormaPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class FormaPagoServiceImpl extends GenericServiceImpl<FormaPago, Integer> implements FormaPagoService {

    @Autowired
    private FormaPagoDAO formaPagoDAO;

    @Override
    public CrudRepository<FormaPago, Integer> getDao() {
        return formaPagoDAO;
    }
}
