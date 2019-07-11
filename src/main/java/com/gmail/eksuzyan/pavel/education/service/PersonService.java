package com.gmail.eksuzyan.pavel.education.service;

import com.gmail.eksuzyan.pavel.education.dao.PersonDao;
import com.gmail.eksuzyan.pavel.education.dto.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Pavel Eksuzian.
 * Created: 11.07.2019.
 */
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonDao personDao;

    public Person createPerson(Person person) {
        return personDao.save(person);
    }

    public Page<Person> paginatePersons(Pageable pageable) {
        return personDao.findAll(pageable);
    }

}
