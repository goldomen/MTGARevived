package com.example.summertrudvang.repository;

import com.example.summertrudvang.domain.RuleBook;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RuleBookRepository extends CrudRepository<RuleBook, String> {
    Optional<RuleBook> findByName(String name);
}
