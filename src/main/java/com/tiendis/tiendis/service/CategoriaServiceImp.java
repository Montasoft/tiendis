package com.tiendis.tiendis.service;

import com.tiendis.tiendis.commons.DAO.CategoriaDAO;
import com.tiendis.tiendis.commons.GenericServiceImpl;
import com.tiendis.tiendis.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class CategoriaServiceImp extends GenericServiceImpl<Categoria, Long> implements CategoriaService {

    @Autowired
    CategoriaDAO categoriaDAO;

    @Override
    public CrudRepository<Categoria, Long> getDao() {
        return categoriaDAO;
    }
}
