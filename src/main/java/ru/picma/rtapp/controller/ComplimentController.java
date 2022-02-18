package ru.picma.rtapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.picma.rtapp.service.ComplimentService;

import java.util.List;

@RestController
@RequestMapping
public class ComplimentController {

    private ComplimentService complimentService;

    public ComplimentController(ComplimentService complimentService) {
        this.complimentService = complimentService;
    }

    @GetMapping("compliment")
    public ResponseEntity<List<String>> getAll() {
        return new ResponseEntity<List<String>>(complimentService.getAll(), HttpStatus.OK);
    }

}
