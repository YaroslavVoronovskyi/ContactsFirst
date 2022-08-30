package com.griddynamics.yavoronovskyi.contacts.processors.impl;

import com.griddynamics.yavoronovskyi.contacts.Constants;
import com.griddynamics.yavoronovskyi.contacts.model.Person;
import com.griddynamics.yavoronovskyi.contacts.processors.IActionProcessor;
import com.griddynamics.yavoronovskyi.contacts.service.IPersonService;

import java.io.IOException;
import java.util.List;

public class ListPersonActionProcessor implements IActionProcessor {

    private final IPersonService personService;

    public ListPersonActionProcessor(IPersonService personService) {
        this.personService = personService;
    }

    @Override
    public void doAction() throws IOException {
        List<Person> personsList = personService.getAll();
        int index = 0;
        for (Person person : personsList) {
            index++;
            System.out.println(index + Constants.DELIMETER + person);
        }
    }

    @Override
    public String getSupportedActionTitle() {
        return "list";
    }
}
