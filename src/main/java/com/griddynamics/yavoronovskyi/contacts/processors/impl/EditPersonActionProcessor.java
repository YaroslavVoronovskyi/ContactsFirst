package com.griddynamics.yavoronovskyi.contacts.processors.impl;

import com.griddynamics.yavoronovskyi.contacts.ConsoleReader;
import com.griddynamics.yavoronovskyi.contacts.Constants;
import com.griddynamics.yavoronovskyi.contacts.model.Person;
import com.griddynamics.yavoronovskyi.contacts.processors.IActionProcessor;
import com.griddynamics.yavoronovskyi.contacts.processors.IPersonActionProcessor;
import com.griddynamics.yavoronovskyi.contacts.processors.IPersonEditProcessorFactory;
import com.griddynamics.yavoronovskyi.contacts.service.IPersonService;

import java.io.IOException;
import java.util.List;

public class EditPersonActionProcessor implements IActionProcessor {
    private final IPersonService personService;
    private final IPersonEditProcessorFactory processorFactoryEditPerson;

    public EditPersonActionProcessor(IPersonService personService, IPersonEditProcessorFactory processorFactoryEditPerson) {
        this.personService = personService;
        this.processorFactoryEditPerson = processorFactoryEditPerson;
    }

    @Override
    public void doAction() throws IOException {
        List<Person> personsList = personService.getAll();
        if (personsList.size() == 0) {
            System.out.println("No records to edit!");
            return;
        }
        int index = 0;
        for (Person person : personsList) {
            index++;
            System.out.println(index + Constants.DELIMETER + person);
        }
        System.out.println("Select a record: ");
        int recordNumber = Integer.parseInt(ConsoleReader.getPersonData());
        Person currentPerson = personsList.get(recordNumber - 1);
        String actionTitle = ConsoleReader.getStringFromConsole("Select a field (name, surname, number): ");
        IPersonActionProcessor actionProcessorEditPersonName = processorFactoryEditPerson.getProcessorByTitle(actionTitle);
        actionProcessorEditPersonName.doAction(currentPerson);
    }

    @Override
    public String getSupportedActionTitle() {
        return "edit";
    }
}
