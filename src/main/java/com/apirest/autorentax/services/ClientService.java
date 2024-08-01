package com.apirest.autorentax.services;

import com.apirest.autorentax.models.dao.IClientDao;
import com.apirest.autorentax.models.entity.Client;
import com.apirest.autorentax.services.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientService implements IClientService {

    @Autowired
    private IClientDao clientDao;

    @Override
    public Client createClient(Client client) {
        return clientDao.save(client);
    }
}
