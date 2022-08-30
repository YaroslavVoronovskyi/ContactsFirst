package com.griddynamics.yavoronovskyi.contacts.service;

import com.griddynamics.yavoronovskyi.contacts.model.Person;

import java.util.List;

public interface IPersonService {
    Person get(Person person);
    List<Person> getAll();
    void save(Person person);
    void update(Person person);
    void delete(Person person);
    int getRecordsCount();
}
