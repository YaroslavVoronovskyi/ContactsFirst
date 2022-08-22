package com.griddynamics.yavoronovskyi.contacts.processors.impl;

import com.griddynamics.yavoronovskyi.contacts.ConsoleReader;
import com.griddynamics.yavoronovskyi.contacts.Constants;
import com.griddynamics.yavoronovskyi.contacts.model.Person;
import com.griddynamics.yavoronovskyi.contacts.processors.IActionProcessor;
import com.griddynamics.yavoronovskyi.contacts.service.IPersonService;
import com.griddynamics.yavoronovskyi.contacts.service.Validator;

import java.io.IOException;

public class AddNewPersonActionProcessor implements IActionProcessor {

    private final IPersonService personService;

    public AddNewPersonActionProcessor(IPersonService personService) {
        this.personService = personService;
    }

    @Override
    public void doAction() throws IOException {
        boolean isPhoneNumberValid = false;
        System.out.println("Enter the name of the person:");
        String name = ConsoleReader.getPersonData();
        System.out.println("Enter the surname of the person:");
        String surname = ConsoleReader.getPersonData();
        System.out.println("Enter the phone number:");

        while (!isPhoneNumberValid) {
            String number = ConsoleReader.getPersonData();
            isPhoneNumberValid = Validator.validatePhoneNumber(number);
            if (!isPhoneNumberValid) {
                System.out.println(Constants.WRONG_NUMBER_FORMAT);
                continue;
            }
            Person person = new Person(name, surname, number);
            personService.save(person);
            System.out.println("The record added.");
        }
    }

    @Override
    public String getSupportedActionTitle() {
        return "add";
    }
}
