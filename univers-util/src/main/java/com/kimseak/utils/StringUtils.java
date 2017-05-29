package com.kimseak.utils;

/**
 * Created by kimseak on 5/26/17.
 */
public enum StringUtils {

    MENU_STUDENT("STUDENTS"),
    MENU_UNIVERSITY("UNIVERSITY"),
    MENU_ADD_STUDENT("Add Student"),
    MENU_REMOVE_STUDENT("Remove Student"),
    MENU_OPERATIONS("Operations"),

    MENU_ADD_UNIVERSITY("ADD UNIVERSITY"),
    MENU_SHOW_UNIVERSITY("SHOW ALL UNIVERSITIES"),
    MENU_CHART_UNIVERSITY("STATISTICS"),
    ;


    private String string;

    private StringUtils(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
