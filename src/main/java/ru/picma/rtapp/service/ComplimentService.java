package ru.picma.rtapp.service;

import org.springframework.stereotype.Service;
import ru.picma.rtapp.repo.ComplimentRepo;

import java.util.List;

@Service
public class ComplimentService {

    private ComplimentRepo complimentRepo;

    public ComplimentService(ComplimentRepo complimentRepo) {
        this.complimentRepo = complimentRepo;
    }

    public List<String> getAll() {
        return complimentRepo.getAll();
    }

}
