package com.tiendis.tiendis.service.Implement;

import com.tiendis.tiendis.DAO.CategoriaDAO;
import com.tiendis.tiendis.commons.GenericServiceImpl;
import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl extends GenericServiceImpl<Categoria, Integer> implements CategoriaService {

    @Autowired
    private CategoriaDAO categoriaDAO;

    @Override
    public CrudRepository<Categoria, Integer> getDao() {
        return categoriaDAO;
    }
}
