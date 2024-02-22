package com.griddynamics.yavoronovskyi.contacts.processors.impl;

import com.griddynamics.yavoronovskyi.contacts.ConsoleReader;
import com.griddynamics.yavoronovskyi.contacts.model.Person;
import com.griddynamics.yavoronovskyi.contacts.processors.IActionProcessor;
import com.griddynamics.yavoronovskyi.contacts.processors.IPersonActionProcessor;
import com.griddynamics.yavoronovskyi.contacts.service.IPersonService;

import java.io.IOException;
import java.util.List;

public class EditPersonPhoneNumberActionProcessor implements IPersonActionProcessor {

    private final IPersonService personService;

    public EditPersonPhoneNumberActionProcessor(IPersonService personService) {
        this.personService = personService;
    }

    @Override
    public void doAction(Person person) throws IOException {
        System.out.println("Enter the number");
        String phoneNumber = ConsoleReader.getPersonData();
        person.setPhoneNumber(phoneNumber);
        personService.update(person);
        System.out.println("The record updated!");
    }

    @Override
    public String getSupportedActionTitle() {
        return "number";
    }
}
