package com.griddynamics.yavoronovskyi.contacts.processors.impl;

import com.griddynamics.yavoronovskyi.contacts.ConsoleReader;
import com.griddynamics.yavoronovskyi.contacts.Constants;
import com.griddynamics.yavoronovskyi.contacts.model.Person;
import com.griddynamics.yavoronovskyi.contacts.processors.IActionProcessor;
import com.griddynamics.yavoronovskyi.contacts.service.IPersonService;

import java.io.IOException;
import java.util.List;

public class RemovePersonActionProcessor implements IActionProcessor {

    private final IPersonService personService;

    public RemovePersonActionProcessor(IPersonService personService) {
        this.personService = personService;
    }

    @Override
    public void doAction() throws IOException {
        List<Person> personsList = personService.getAll();
        if (personsList.size() == 0) {
            System.out.println("No records to remove!");
            return;
        }
        int index = 0;
        for (Person person : personsList) {
            index++;
            System.out.println(index + Constants.DELIMETER + person);
        }
        System.out.println("Select a record: ");
        int recordNumber = ConsoleReader.getRecordNumber();
        personsList.remove(recordNumber - 1);
        System.out.println("The record removed!");
    }

    @Override
    public String getSupportedActionTitle() {
        return "remove";
    }
}
