package com.riskiq.restservice;

public class RepositoryTotalSize {
    private long totalSize;

    public RepositoryTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }
}
