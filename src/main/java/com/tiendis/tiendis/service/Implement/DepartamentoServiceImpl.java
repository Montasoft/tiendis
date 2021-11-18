package com.tiendis.tiendis.service.Implement;

import com.tiendis.tiendis.DAO.DepartamentoDAO;
import com.tiendis.tiendis.commons.GenericServiceImpl;
import com.tiendis.tiendis.entity.Departamento;
import com.tiendis.tiendis.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoServiceImpl extends GenericServiceImpl<Departamento, String> implements DepartamentoService {

    @Autowired
    private DepartamentoDAO departamentoDAO;

    @Override
    public CrudRepository<Departamento, String> getDao() {
        return departamentoDAO;
    }
}
