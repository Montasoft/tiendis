package com.tiendis.tiendis.service;

import com.tiendis.tiendis.DAO.CategoriaDAO;
import com.tiendis.tiendis.commons.GenericServiceImpl;
import com.tiendis.tiendis.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl extends GenericServiceImpl<Categoria, Long> implements CategoriaService {

    @Autowired
    private CategoriaDAO categoriaDAO;

    @Override
    public CrudRepository<Categoria, Long> getDao() {
        return categoriaDAO;
    }
}
