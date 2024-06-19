package com.newrdmb.ders11.odev8;
import java.util.ArrayList;
import java.util.List;
public class Department {
    private String name;
    private TeamLead teamLead;
    private PersonelList personelList;
    private List<Todo> todos;

    public Department(String name) {
        this.name = name;
        this.teamLead = new TeamLead("TBC");
        this.personelList = new PersonelList();
        this.todos = new ArrayList<>();
    }

    public String getName(){
        return name;
    }
    public TeamLead getTeamLead() {
        return teamLead;
    }

    public void changeTeamLead(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Lutfen gerekli alanlari doldurunuz.");
        }
        this.teamLead.changeTeamLead(name);
    }

    public PersonelList getPersonelList() {
        return personelList;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void addTodoTask(String task) {
        this.todos.add(new Todo(task));
    }

    public void validateTodoTask(int index) {
        if (index >= 0 && index < todos.size()) {
            this.todos.get(index).setCompleted(true);
        }
    }
}
class FinanceDepartment extends Department {
    public FinanceDepartment() {
        super("Finance");
    }
}

class HRDepartment extends Department {
    public HRDepartment() {
        super("HR");
    }
}

class EngineeringDepartment extends Department {
    public EngineeringDepartment() {
        super("Engineering");
    }
}

