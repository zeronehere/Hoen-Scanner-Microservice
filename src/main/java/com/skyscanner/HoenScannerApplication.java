package com.skyscanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HoenScannerApplication extends Application<HoenScannerConfiguration> {
    public static void main(String[] args) throws Exception {
        new HoenScannerApplication().run(args);
    }

    @Override
    public String getName() {
        return "hoen-scanner";
    }

    @Override
    public void initialize(Bootstrap<HoenScannerConfiguration> bootstrap) {}

    @Override
    public void run(HoenScannerConfiguration config, Environment env) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        
        List<SearchResult> carResults = Arrays.asList(
            mapper.readValue(
                getClass().getClassLoader().getResource("rental_cars.json"),
                SearchResult[].class
            ));
        
        List<SearchResult> hotelResults = Arrays.asList(
            mapper.readValue(
                getClass().getClassLoader().getResource("hotels.json"),
                SearchResult[].class
            ));

        List<SearchResult> searchResults = new ArrayList<>();
        searchResults.addAll(carResults);
        searchResults.addAll(hotelResults);

        env.jersey().register(new SearchResource(searchResults));
    }
} 
