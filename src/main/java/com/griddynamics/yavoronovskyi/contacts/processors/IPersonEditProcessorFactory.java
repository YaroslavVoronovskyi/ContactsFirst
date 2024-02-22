package com.griddynamics.yavoronovskyi.contacts.processors;

public interface IPersonEditProcessorFactory {
    IPersonActionProcessor getProcessorByTitle(String title);
}
