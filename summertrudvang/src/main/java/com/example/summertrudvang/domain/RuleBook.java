package com.example.summertrudvang.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class RuleBook {

    @Id
    private String code;

    @Column
    private String name;

    protected RuleBook() {

    }

    public RuleBook(String code, String name){
        this.code = code;
        this.name = name;
    }

    public String getCode(){
        return code;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "RuleBook{" +
                "code=" + code +'\'' +
                "name=" + name;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) { return true; }
        if(o==null || getClass() == o.getClass()){ return false; }
        RuleBook ruleBook = (RuleBook) o;
        return Objects.equals(code, ruleBook.code) && Objects.equals(name, ruleBook.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(code, name);
    }
}
