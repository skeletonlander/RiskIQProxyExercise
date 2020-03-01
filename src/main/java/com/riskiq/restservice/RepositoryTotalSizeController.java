package com.riskiq.restservice;

import com.riskiq.repository.BaseRepository;
import com.riskiq.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * RepositoryTotalSizeController is used to provide a REST interface to retrieve
 * the size of all repositories in the application which is refreshed every 5 minutes
 */
@RestController
public class RepositoryTotalSizeController {
    static final int fiveMinutes = 1000 * 60 * 5;
    static long latestSize;

    /**
     * getTotalSize is a helper function to iterate through the unique set of
     * CrudRepositories that have registers in this application
     * @return long Size of all repositories registered in this application
     */
    private static long getTotalSize() {
        long totalSize = 0;
        for(BaseRepository baseRepository : BaseRepository.getRepositories()) {
            try {
                totalSize += baseRepository.size();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return totalSize;
    }

    /**
     * init is a private function run after all other Spring objects have been initialize to
     * make sure that the initial value of latestSize is set
     */
    @PostConstruct
    private void init() {
        latestSize = getTotalSize();
    }

    /**
     * repositoryTotalSize maps the URL /repositoryTotalSize to the Bean RepositoryTotalSize
     * which returns the total size of all unique CrudRepositories in this application
     * @return RepositoryTotalSize
     */
    @GetMapping("/repositoryTotalSize")
    public RepositoryTotalSize repositoryTotalSize() {
        return new RepositoryTotalSize(latestSize);
    }

    /**
     * getSize updates the static latestSize value every five minutes
     */
    @Scheduled(fixedDelay = fiveMinutes)
    private void getSize() {
        latestSize = getTotalSize();
    }
}

