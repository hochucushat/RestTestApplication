package ru.picma.rtapp.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.picma.rtapp.service.ComplimentService;

import java.util.Map;

/**
 * Class {@code RestController} that accepts requests related to compliment.
 * Delegates the logic of working with compliment to {@code ComplimentService}.
 * Sends a response in Json format.
 *
 * @author  pic
 * @see     ru.picma.rtapp.service.ComplimentService
 * @since   0.0.1
 */
@RestController
@RequestMapping("compliment")
public class ComplimentController {

    private ComplimentService complimentService;

    /**
     * Constructs a ComplimentController.
     */
    public ComplimentController(ComplimentService complimentService) {
        this.complimentService = complimentService;
    }

    /**
     * This method takes HTTP GET requests and calls {@code complimentService.getAll()}.
     *
     * @return {@code ResponseEntity<List<String>>}
     */
    @GetMapping("")
    public ResponseEntity<Map<Integer, String>> getAll() {
        Map<Integer, String> map = complimentService.getAll();
        return map != null ? new ResponseEntity<>(map, HttpStatus.OK)
                            : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * This method takes HTTP POST requests and calls {@code complimentService.add(compliment)}.
     *
     * @return {@code ResponseEntity<>}
     */
    @PostMapping("/add")
    public ResponseEntity<Map<Integer, String>> add(@RequestBody String compliment) {
        int countChanges = complimentService.add(compliment);
        return countChanges == 1 ? new ResponseEntity<>(HttpStatus.OK)
                                 : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * This method takes HTTP DELETE requests and calls {@code complimentService.remove(id)}.
     *
     * @return {@code ResponseEntity<>}
     */
    @DeleteMapping("/rm")
    public ResponseEntity<Map<Integer, String>> remove(@RequestBody int id) {
        int countChanges = complimentService.remove(id);
        return countChanges == 1 ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
