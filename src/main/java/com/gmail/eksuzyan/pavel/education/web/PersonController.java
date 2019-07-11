package com.gmail.eksuzyan.pavel.education.web;

import com.gmail.eksuzyan.pavel.education.dto.Person;
import com.gmail.eksuzyan.pavel.education.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.Date;

/**
 * @author Pavel Eksuzian.
 * Created: 11.07.2019.
 */
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @RequestMapping("/")
    public String welcome() {
        return "Greetings from Spring Boot at " + LocalTime.now() + "!";
    }

    @RequestMapping("/person/create/{userName}")
    public String create(@PathVariable("userName") String userName) {
        Person person = new Person();

        person.setFullName(userName);
        person.setDateOfBirth(new Date());

        Person savedPerson = personService.createPerson(person);

        return savedPerson.toString();
    }

    @RequestMapping("/person/paginate/{currentPage}/{pageSize}/{order}/{field}")
    public Page<Person> paginate(@PathVariable("pageSize") Integer pageSize,
                                 @PathVariable("currentPage") Integer currentPage,
                                 @PathVariable("order") String order,
                                 @PathVariable("field") String field) {
        final Sort.Direction direction = Sort.Direction.valueOf(order.toUpperCase());
        final Sort sort = new Sort(direction, field);
        final Pageable pageable = PageRequest.of(currentPage, pageSize, sort);

        return personService.paginatePersons(pageable);
    }

}
