package com.riskiq.repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Base class to implement CRUD operation of data files
 *
 * @author riskiq
 * @created 1/17/18
 */
public abstract class CrudRepository <T, R> extends BaseRepository {
    private final R path;

    public CrudRepository(R path) {
        super();
        this.path = path;
    }

    public R getPath() {
        return path;
    }
}