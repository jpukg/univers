package com.kimseak.utils;

/**
 * Created by kimseak on 5/27/17.
 */
public enum  Gender {

    MALE("male"), FEMALE("female");

    private final String string;

    private Gender(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

}
