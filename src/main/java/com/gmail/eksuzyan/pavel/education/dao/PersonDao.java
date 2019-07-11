package com.gmail.eksuzyan.pavel.education.dao;

import com.gmail.eksuzyan.pavel.education.dto.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Pavel Eksuzian.
 * Created: 11.07.2019.
 */
@Repository
public interface PersonDao extends PagingAndSortingRepository<Person, Long> {


}
