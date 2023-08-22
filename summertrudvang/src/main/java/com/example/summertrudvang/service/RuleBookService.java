package com.example.summertrudvang.service;

import com.example.summertrudvang.domain.RuleBook;
import com.example.summertrudvang.repository.RuleBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleBookService {
    private RuleBookRepository ruleBookRepository;

    @Autowired
    public RuleBookService(RuleBookRepository ruleBookRepository){
        this.ruleBookRepository = ruleBookRepository;
    }

    /**
     * Create a Rule Book
     * @param code code of the Rule Book
     * @param name name of the Rule Book
     * @return new or existing Rule Book
     */

    public RuleBook createRuleBook(String code, String name){
        return ruleBookRepository.findByName(code).orElse(ruleBookRepository.save(new RuleBook(code, name)));
    }

    /**
     * Lookup all Rule Books
     * @return
     */
    public Iterable<RuleBook> lookup(){
        return ruleBookRepository.findAll();
    }

    /**
     * Count the number of Rule Books in the database
     * @return
     */
    public long total(){
        return ruleBookRepository.count();
    }

    public RuleBook findByBookName(String bookName){
        return ruleBookRepository.findById(bookName).orElseThrow(() ->
                new RuntimeException("Rule Book does not exist" + bookName));
    }

}
