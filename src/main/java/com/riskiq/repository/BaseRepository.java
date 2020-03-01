package com.riskiq.repository;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseRepository {
    private static final Set<BaseRepository> repositories = new HashSet<>();

    public BaseRepository() {
        repositories.add(this);
    }

    public long size() throws IOException {
        return 0;
    }

    /**
     * getRepositories returns the unique set of all repositories created in this application
     * @return Set
     */
    public static Set<BaseRepository> getRepositories() {
        return repositories;
    }

}
