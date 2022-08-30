package com.griddynamics.yavoronovskyi.contacts;

import com.griddynamics.yavoronovskyi.contacts.processors.IPersonActionProcessor;
import com.griddynamics.yavoronovskyi.contacts.processors.IPersonEditProcessorFactory;
import com.griddynamics.yavoronovskyi.contacts.processors.IProcessorFactory;
import com.griddynamics.yavoronovskyi.contacts.processors.impl.*;
import com.griddynamics.yavoronovskyi.contacts.service.IPersonService;
import com.griddynamics.yavoronovskyi.contacts.service.PersonServiceImpl;
import com.griddynamics.yavoronovskyi.contacts.processors.IActionProcessor;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        try {
            IPersonService personService = new PersonServiceImpl();

            IPersonActionProcessor actionProcessorEditPersonName = new EditPersonNameActionProcessor(personService);
            IPersonActionProcessor actionProcessorEditPersonSurname = new EditPersonSurnameActionProcessor(personService);
            IPersonActionProcessor actionProcessorEditPersonPhoneNumber = new EditPersonPhoneNumberActionProcessor(personService);

            IPersonEditProcessorFactory processorFactoryEditPerson = new ProcessorFactoryEditPerson(
                    List.of(actionProcessorEditPersonName, actionProcessorEditPersonSurname,
                            actionProcessorEditPersonPhoneNumber));

            IActionProcessor actionProcessorAdd = new AddNewPersonActionProcessor(personService);
            IActionProcessor actionProcessorCount = new CountPersonActionProcessor(personService);
            IActionProcessor actionProcessorList = new ListPersonActionProcessor(personService);
            IActionProcessor actionProcessorEdit = new EditPersonActionProcessor(personService, processorFactoryEditPerson);
            IActionProcessor actionProcessorRemove = new RemovePersonActionProcessor(personService);
            IActionProcessor actionProcessorExit = new ExitApp(personService);

            IProcessorFactory processorFactory = new ProcessorFactory(List.of(actionProcessorAdd, actionProcessorCount,
                    actionProcessorList, actionProcessorEdit, actionProcessorRemove, actionProcessorExit));

            PhoneBook phoneBook = new PhoneBook(processorFactory);
            phoneBook.runPhoneBook();
        } catch (InputMismatchException exception) {
            System.out.println(exception.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
