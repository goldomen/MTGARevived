package com.example.summertrudvang.domain;

import javax.persistence.*;
import java.util.Objects;

/*
    This have about 5 fields which needs to be filled, would be good to use a builder pattern in this case.
 */
@Entity
public class Rule {


    @Id
    private String ruleName;

    @Column(length= 2000 )
    private String description;

    @ManyToOne
    private RuleBook ruleBook;

    @Column
    @Enumerated
    private RuleCategory ruleCategory;

    @Column
    @Enumerated
    private Game game;

    public Rule(String ruleName, String description, RuleBook ruleBook ,RuleCategory ruleCategory, Game game){
        this.ruleName = ruleName;
        this.description = description;
        this.ruleBook = ruleBook;
        this.ruleCategory = ruleCategory;
        this.game = game;
    }

    protected Rule(){

    }


    public void setRuleName(String ruleName){
        this.ruleName = ruleName;
    }

    public String getRuleName(){
        return ruleName;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setRuleBook(RuleBook ruleBook) {
        this.ruleBook = ruleBook;
    }

    public RuleBook getRuleBook() {
        return ruleBook;
    }

    public void setRuleCategory(RuleCategory ruleCategory){
        this.ruleCategory = ruleCategory;
    }

    public RuleCategory getRuleCategory(){
        return ruleCategory;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    @Override
    public String toString(){
        return "Rule {" +
                "ruleName=" + ruleName +'\'' +
                "description=" + description +'\'' +
                "rulebook=" + ruleBook +'\'' +
                "ruleCategory=" + ruleCategory +'\'' +
                "game=" + game + "}";
    }

    @Override
    public boolean equals(Object o){
        if (this == o) { return true; }
        if (this == null || getClass() != o.getClass()){ return false; }
        Rule rule = (Rule) o;
        return Objects.equals(ruleName, rule.ruleName) &&
                Objects.equals(description, rule.description) &&
                Objects.equals(ruleCategory, rule.ruleCategory) &&
                Objects.equals(ruleBook, rule.ruleBook) &&
                Objects.equals(game, rule.game);
    }

    @Override
    public int hashCode(){
        return Objects.hash(ruleName, description, ruleBook, ruleCategory, game);
    }
}
