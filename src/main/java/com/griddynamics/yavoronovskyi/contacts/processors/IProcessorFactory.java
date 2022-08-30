package com.griddynamics.yavoronovskyi.contacts.processors;

public interface IProcessorFactory {
    IActionProcessor getProcessorByTitle(String title);
}
