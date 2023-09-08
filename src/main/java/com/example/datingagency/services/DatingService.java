package com.example.datingagency.services;


import com.example.datingagency.data.DatingTable;
import com.example.datingagency.repositories.ClientRepository;
import com.example.datingagency.repositories.DatingTableRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class DatingService {
    private final DatingTableRepository datingTableRepository;
    private final ClientRepository clientRepository;

    public List<DatingTable> getDates(){return datingTableRepository.findAll();}

    public List<DatingTable> getInfo(int id){
        return datingTableRepository.findById(id);
    }

    public void addDate(int firstPersonId, int secondPersonId, LocalDateTime date) {
        datingTableRepository.save(new DatingTable(firstPersonId, clientRepository.findById(firstPersonId),
                secondPersonId, clientRepository.findById(secondPersonId), date));
    }

    public void deleteDate(int id) {
        datingTableRepository.deleteById(id);
    }
}
