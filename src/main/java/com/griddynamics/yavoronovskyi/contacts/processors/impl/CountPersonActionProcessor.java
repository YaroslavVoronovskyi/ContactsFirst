package com.griddynamics.yavoronovskyi.contacts.processors.impl;

import com.griddynamics.yavoronovskyi.contacts.processors.IActionProcessor;
import com.griddynamics.yavoronovskyi.contacts.service.IPersonService;

import java.io.IOException;

public class CountPersonActionProcessor implements IActionProcessor {

    private final IPersonService personService;

    public CountPersonActionProcessor(IPersonService personService) {
        this.personService = personService;
    }

    @Override
    public void doAction() throws IOException {
        System.out.println("The Phone Book has " + personService.getRecordsCount() + " records.");
    }

    @Override
    public String getSupportedActionTitle() {
        return "count";
    }
}
