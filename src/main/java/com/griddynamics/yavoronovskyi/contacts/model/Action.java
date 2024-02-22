package com.griddynamics.yavoronovskyi.contacts.model;

public enum Action {
    ADD("add"),
    REMOVE("remove"),
    EDIT("edit"),
    COUNT("count"),
    LIST("list"),
    EXIT("exit");

    private String title;

    Action(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static Action fromTitle(String title) {
        for (Action value : values()) {
            if (value.getTitle().equals(title)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Action with " + title + " not found");
    }
}
