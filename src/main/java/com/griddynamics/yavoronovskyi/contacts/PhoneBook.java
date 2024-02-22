package com.griddynamics.yavoronovskyi.contacts;


import com.griddynamics.yavoronovskyi.contacts.processors.IActionProcessor;
import com.griddynamics.yavoronovskyi.contacts.processors.IProcessorFactory;
import java.io.IOException;

public class PhoneBook {
    private final IProcessorFactory processorFactory;

    public PhoneBook(IProcessorFactory processorFactory) {
        this.processorFactory = processorFactory;
    }

    public String runPhoneBook() throws IOException {
        while (true) {

            String actionTitle = ConsoleReader.getStringFromConsole("Enter action (add, remove, edit, count, list, exit):");
            IActionProcessor processor = processorFactory.getProcessorByTitle(actionTitle);
            processor.doAction();

        }
    }
}
