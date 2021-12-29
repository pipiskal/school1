package com.kalimeris.spyros.school.repositories;

import com.kalimeris.spyros.school.entities.Author;
import org.springframework.data.repository.CrudRepository;



public interface AuthorRepository extends CrudRepository<Author, Long> {
}
