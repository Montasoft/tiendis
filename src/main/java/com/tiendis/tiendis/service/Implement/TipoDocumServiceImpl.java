package com.tiendis.tiendis.service.Implement;

import com.tiendis.tiendis.DAO.TipoDocumDAO;
import com.tiendis.tiendis.commons.GenericServiceImpl;
import com.tiendis.tiendis.entity.TipoDocum;
import com.tiendis.tiendis.service.TipoDocumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoDocumServiceImpl extends GenericServiceImpl<TipoDocum, Long> implements TipoDocumService {

    @Autowired
    private TipoDocumDAO tipoDocumDAO;

    @Override
    public CrudRepository<TipoDocum, Long> getDao() {
        return tipoDocumDAO;
    }
}
