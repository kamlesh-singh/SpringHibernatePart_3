package org.ttn.springhibernatepart3.manyToOne.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.ttn.springhibernatepart3.manyToOne.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {

}
