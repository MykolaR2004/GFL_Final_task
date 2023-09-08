package com.example.datingagency.repositories;

import com.example.datingagency.data.Client;
import com.example.datingagency.data.ClientInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    //List<ClientInfo> findByIdNotNull(int firstPersonId);

    List<Client> findAllByAboutYourselfContains(String s);
}