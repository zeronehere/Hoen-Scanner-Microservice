package com.skyscanner;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

public class Search {
    @JsonProperty
    @NotNull
    private String city;

    public Search() {}

    public Search(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}