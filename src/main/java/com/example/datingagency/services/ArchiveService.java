package com.example.datingagency.services;

import com.example.datingagency.data.Archive;
import com.example.datingagency.data.Client;
import com.example.datingagency.repositories.ArchiveRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArchiveService {
    private final ArchiveRepository archiveRepository;

    public List<Archive> getPairs(){
        return archiveRepository.findAll();
    }

    public void addConvergedPair(String s) {
        archiveRepository.save(new Archive(s));
    }


}
