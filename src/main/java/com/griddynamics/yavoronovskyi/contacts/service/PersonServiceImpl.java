package com.griddynamics.yavoronovskyi.contacts.service;

import com.griddynamics.yavoronovskyi.contacts.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements IPersonService {
    List<Person> phoneBook = new ArrayList<>();

    @Override
    public Person get(Person person) {
        return null;
    }

    @Override
    public List<Person> getAll() {
        return phoneBook;
    }

    @Override
    public void save(Person person) {
        phoneBook.add(person);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {

    }

    @Override
    public int getRecordsCount() {
        return phoneBook.size();
    }
}
