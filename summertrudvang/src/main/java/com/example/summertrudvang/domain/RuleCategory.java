package com.example.summertrudvang.domain;

public enum RuleCategory {
    Combat("Combat"), Civics("Civics"), NPC("NPC");
    private String category;
    private RuleCategory(String category){
        this.category = category;
    }
    public static RuleCategory findByCategory(String byCategory){
        for(RuleCategory rc: RuleCategory.values()){
            if(rc.category.equalsIgnoreCase(byCategory)){
                return rc;
            }
        }
        return null;
    }
}
