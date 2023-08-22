package com.example.summertrudvang.service;

import com.example.summertrudvang.domain.Game;
import com.example.summertrudvang.domain.Rule;
import com.example.summertrudvang.domain.RuleBook;
import com.example.summertrudvang.domain.RuleCategory;
import com.example.summertrudvang.repository.RuleBookRepository;
import com.example.summertrudvang.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleService {

    private RuleRepository ruleRepository;
    private RuleBookRepository ruleBookRepository;

    @Autowired
    public RuleService(RuleRepository ruleRepository, RuleBookRepository ruleBookRepository){
        this.ruleRepository = ruleRepository;
        this.ruleBookRepository = ruleBookRepository;
    }


    /**
     *  Create a new Rule and persist it in the database
     * @param ruleName name of the rule
     * @param description description of the rule
     * @param ruleCategory the category of the rule
     * @param ruleBookName the name of the rule book the rule can belong to
     * @param game the game the rule belongs to
     * @return new or already existing rule
     */
    public Rule createRule(String ruleName, String description, String ruleBookName, RuleCategory ruleCategory, Game game){
        RuleBook ruleBook = ruleBookRepository.findById(ruleBookName).orElseThrow(() ->
                new RuntimeException("Rule Book does not exist" + ruleBookName));

        return ruleRepository.save(new Rule(ruleName, description, ruleBook, ruleCategory, game));
    }

    /**
     * Return a rule with rule name as key
     * @param ruleName
     */

    public Rule getRule(String ruleName){
        Rule rule = ruleRepository.findById(ruleName).orElseThrow(() ->
            new RuntimeException("Rule does not exist with the name of "+ruleName));
        return rule;
    }

    /**
     * Calculate the number of rules in the database
     * @return
     */
    public long total(){
        return ruleRepository.count();
    }
}
