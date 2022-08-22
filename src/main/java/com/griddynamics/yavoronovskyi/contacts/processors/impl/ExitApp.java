package com.griddynamics.yavoronovskyi.contacts.processors.impl;

import com.griddynamics.yavoronovskyi.contacts.processors.IActionProcessor;
import com.griddynamics.yavoronovskyi.contacts.service.IPersonService;

import java.io.IOException;

public class ExitApp implements IActionProcessor {

    private final IPersonService personService;

    public ExitApp(IPersonService personService) {
        this.personService = personService;
    }

    @Override
    public void doAction() throws IOException {
        System.out.println(0);
    }

    @Override
    public String getSupportedActionTitle() {
        return "exit";
    }
}
