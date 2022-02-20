package ru.picma.rtapp.service;

import org.springframework.stereotype.Service;
import ru.picma.rtapp.repo.ComplimentRepo;

import java.util.Map;

/**
 * Class {@code ComplimentService} accepting {@code complimentRepo} and calling its methods to access Database.
 *
 * @author  pic
 * @see     ru.picma.rtapp.repo.ComplimentRepo
 * @since   0.0.1
 */
@Service
public class ComplimentService {

    private ComplimentRepo complimentRepo;

    /**
     * Constructs a ComplimentService.
     */
    public ComplimentService(ComplimentRepo complimentRepo) {
        this.complimentRepo = complimentRepo;
    }

    /**
     * Calls complimentRepo.getAll() and return all compliments.
     *
     * @return {@code List<String>} or null.
     */
    public Map<Integer, String> getAll() {
        return complimentRepo.getAll();
    }

    /**
     * This method takes <b>{@code String compliment}</b> and calls {@code complimentRepo.add(compliment)}.
     *
     * @return the number of changes in the database.
     * If the field was added it will return 1, if not, it will return 0.
     */
    public int add(String compliment) {
        return complimentRepo.add(compliment);
    }

    /**
     * This method takes <b>{@code int id}</b> and calls {@code complimentRepo.remove(id)}.
     *
     * @return the number of changes in the database.
     * If the field was removed it will return 1, if not, it will return 0.
     */
    public int remove(int id) {
        return complimentRepo.remove(id);
    }

}
