package com.griddynamics.yavoronovskyi.contacts.processors;

import com.griddynamics.yavoronovskyi.contacts.model.Person;

import java.io.IOException;

public interface IActionProcessor {
    void doAction() throws IOException;

    String getSupportedActionTitle();
}
