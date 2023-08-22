package com.example.summertrudvang.repository;

import com.example.summertrudvang.domain.Rule;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface RuleRepository extends CrudRepository<Rule, String> {
    List<Rule> findByRuleBook(String code, Pageable pageable);
    Rule findByRuleName(String ruleName);
}
