package com.kalimeris.spyros.school.repositories;

import com.kalimeris.spyros.school.entities.Book;
import org.springframework.data.repository.CrudRepository;



public interface BookRepository extends CrudRepository<Book, Long> {
}
