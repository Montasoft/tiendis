package com.tiendis.tiendis.service.Implement;

import com.tiendis.tiendis.DAO.ProveedorDAO;
import com.tiendis.tiendis.commons.GenericServiceImpl;
import com.tiendis.tiendis.entity.Proveedor;
import com.tiendis.tiendis.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImpl extends GenericServiceImpl<Proveedor, Integer> implements ProveedorService {

    @Autowired
    private ProveedorDAO proveedorDAO;

    @Override
    public CrudRepository<Proveedor, Integer> getDao() {
        return proveedorDAO;
    }
}
