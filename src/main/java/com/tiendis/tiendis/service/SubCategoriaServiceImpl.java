package com.tiendis.tiendis.service;

import com.tiendis.tiendis.DAO.SubCategoriaDAO;
import com.tiendis.tiendis.commons.GenericServiceImpl;
import com.tiendis.tiendis.entity.SubCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoriaServiceImpl extends GenericServiceImpl<SubCategoria, Long> implements SubCategoriaService {

    @Autowired
    private SubCategoriaDAO subCategoriaDAO;


    @Override
    public CrudRepository<SubCategoria, Long> getDao() {
        return null;
    }
}
