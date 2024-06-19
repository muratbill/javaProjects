package com.newrdmb.ders11.odev8;

public class TeamLead {
    private String name;

    public TeamLead(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Alan bos olamaz");
        }
        this.name = name;
    }

    public void changeTeamLead(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Bu alan bos olamaz.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

