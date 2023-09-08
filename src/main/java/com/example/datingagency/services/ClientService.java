package com.example.datingagency.services;

import com.example.datingagency.data.Client;
import com.example.datingagency.data.ClientInfo;
import com.example.datingagency.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getClients(){return clientRepository.findAll();}

//    public List<ClientInfo> findByIdNotNull(int id) {
//        return clientRepository.findByIdNotNull(id);
//    }

    public void addClient(String name, String surname, String about_yourself, String partner_requirements, String sex) {
        clientRepository.save(new Client(name, surname, about_yourself,partner_requirements,sex));
    }

    public Optional<Client> findById(int id) {
        return clientRepository.findById(id);
    }

    public void deleteClient(int id) {
        clientRepository.deleteById(id);
    }

    public List<Client> getClientsWith(String s){return clientRepository.findAllByAboutYourselfContains(s);}

    public void updateClient(int id, String name, String surname, String about_yourself, String partner_requirements, String sex) {
        Optional<Client> client = clientRepository.findById(id);
        client.ifPresent(a -> {
            a.setName(name);
            a.setSurname(surname);
            a.setAboutYourself(about_yourself);
            a.setPartnerRequirements(partner_requirements);
            a.setSex(sex);
            clientRepository.save(a);
        });
    }
}
