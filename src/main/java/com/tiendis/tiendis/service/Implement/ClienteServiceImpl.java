package com.tiendis.tiendis.service.Implement;

import com.tiendis.tiendis.DAO.ClienteDAO;
import com.tiendis.tiendis.commons.GenericServiceImpl;
import com.tiendis.tiendis.entity.Cliente;
import com.tiendis.tiendis.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Integer> implements ClienteService {

    @Autowired
    private ClienteDAO clienteDAO;

    @Override
    public CrudRepository<Cliente, Integer> getDao() {
        return clienteDAO;
    }
}
