package com.griddynamics.yavoronovskyi.contacts.processors;

import com.griddynamics.yavoronovskyi.contacts.model.Person;

import java.io.IOException;

public interface IPersonActionProcessor {
    void doAction(Person person) throws IOException;

    String getSupportedActionTitle();
}
