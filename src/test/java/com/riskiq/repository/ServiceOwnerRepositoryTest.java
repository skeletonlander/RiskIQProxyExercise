package com.riskiq.repository;

import com.google.common.io.Resources;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test that the total service size is 4 with test data provided
 */
public class ServiceOwnerRepositoryTest {

    @Test
    public void testGetSize() throws Exception {

        ServiceOwnerRepository serviceOwnerRepository =
                new ServiceOwnerRepository(Resources.getResource("testServiceOwnerSize.txt"));
        long size = serviceOwnerRepository.size();
        assertEquals(size, 4);
    }
}