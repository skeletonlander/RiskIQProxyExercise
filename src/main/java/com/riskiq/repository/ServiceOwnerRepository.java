package com.riskiq.repository;

import com.riskiq.domain.User;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CRUD operations implementation specifically for {@link com.riskiq.domain.ServiceOwner}
 *
 */
@Component
public class ServiceOwnerRepository extends CrudRepository<User, URL> {

    public ServiceOwnerRepository(URL path) {
        super(path);
    }

    @Override
    public long size() throws IOException {
        System.out.println("ServiceOwnerRepository size: ");
        try {
            BufferedReader br = new BufferedReader(new FileReader(Paths.get(getPath().toURI()).toFile()));

            int totalServiceOwners = 0;
            String st;
            while ((st = br.readLine()) != null) {
                Pattern pattern = Pattern.compile("[^\\s]+\\s*,\\s*[^\\s]+");
                Matcher matcher = pattern.matcher(st);
                while (matcher.find()) {
                    totalServiceOwners++;
                }
            }
            return totalServiceOwners;
        }
        catch (URISyntaxException ex) {
            System.out.println(ex);
            return 0;
        }
    }
}