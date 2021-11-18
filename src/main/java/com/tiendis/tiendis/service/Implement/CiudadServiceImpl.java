package com.tiendis.tiendis.service.Implement;

import com.tiendis.tiendis.DAO.CiudadDAO;
import com.tiendis.tiendis.commons.GenericServiceImpl;
import com.tiendis.tiendis.entity.Ciudad;
import com.tiendis.tiendis.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CiudadServiceImpl extends GenericServiceImpl<Ciudad, String> implements CiudadService {

    @Autowired
    private CiudadDAO ciudadDAO;

    @Override
    public CrudRepository<Ciudad, String> getDao() {
        return ciudadDAO;
    }
}
