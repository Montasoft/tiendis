package com.tiendis.tiendis.service.Implement;

import com.tiendis.tiendis.DAO.BancoDAO;
import com.tiendis.tiendis.commons.GenericServiceImpl;
import com.tiendis.tiendis.entity.Banco;
import com.tiendis.tiendis.service.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class BancoServiceImpl extends GenericServiceImpl<Banco, Long> implements BancoService {

    @Autowired
    private BancoDAO bancoDAO;

    @Override
    public CrudRepository<Banco, Long> getDao() {
        return bancoDAO;
    }
}
