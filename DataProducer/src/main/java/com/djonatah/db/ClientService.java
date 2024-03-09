package com.djonatah.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public void createRandomClient(){
        var uuid = UUID.randomUUID().toString();
        var username = "Test user";
        var email= "test@email.com";
        Client client = new Client(uuid, username, email);
        clientRepository.save(client);
    }

}
