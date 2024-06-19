package com.newrdmb.ders11.odev8;
import java.time.LocalDate;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Department finance = new FinanceDepartment();
        Department hr = new HRDepartment();
        Department engineering = new EngineeringDepartment();



        // Add personnel to Finance Department
        Personel john = new Man("John", "Doe", LocalDate.of(1980, 1, 15));
        Personel jane = new Woman("Jane", "Doe", LocalDate.of(1985, 5, 30));
        Personel ahmet = new Man("Ahmet", "Can", LocalDate.of(1975,4,12));
        finance.getPersonelList().addPersonel(john);
        finance.getPersonelList().addPersonel(jane);
        finance.getPersonelList().addPersonel(ahmet);
        finance.changeTeamLead("ahmet");

        Personel alice = new Woman("Alice", "Smith", LocalDate.of(1990, 3, 20));
        finance.getPersonelList().changePersonel(0, alice);

        // Add todo tasks to Finance Department
        finance.addTodoTask("Complete project report");
        finance.addTodoTask("Attend team meeting");

        // Validate a todo task in Finance Department
        finance.validateTodoTask(0);

        // Adding HR personels
        Personel bob = new Man("Bob", "Doe", LocalDate.of(1970,12,12));
        hr.getPersonelList().addPersonel(bob);
        hr.addTodoTask("Prepare new hire");

        Personel hande = new Woman("Hande", "Yener", LocalDate.of(1970,12,2));
        hr.getPersonelList().addPersonel(hande);
        hr.addTodoTask("Prepare Interviews");
        hr.changeTeamLead("Hande Yener");
        hr.validateTodoTask(0);

        Personel lale = new Woman("Lale", "Sen", LocalDate.of(1990,12,2));
        hr.getPersonelList().addPersonel(lale);
        Personel martin = new Man("Martin", "Dan", LocalDate.of(1991,8,2));

        hr.getPersonelList().changePersonel(0, martin);

        // Engineering Team

        Personel ayca = new Woman("Ayca", "Zan", LocalDate.of(1969,4,9));
        engineering.getPersonelList().addPersonel(ayca);
        engineering.addTodoTask("New pipeline");

        Personel samet = new Man("Samet", "Aybaba", LocalDate.of(1999,9,23));
        engineering.getPersonelList().addPersonel(samet);
        engineering.addTodoTask("New WEB software develepment");
        engineering.addTodoTask("New release for dev deployment");
        engineering.validateTodoTask(2);
        // Calculate remaining days for retirement
        int johnRemainingDays = finance.getPersonelList().calculateRemainingYearsForRetirement(john);
        int janeRemainingDays = finance.getPersonelList().calculateRemainingYearsForRetirement(jane);
        int ahmetRemainingDays = finance.getPersonelList().calculateRemainingYearsForRetirement(ahmet);
        int sametRemainingDays = finance.getPersonelList().calculateRemainingYearsForRetirement(samet);

        System.out.println("John's remaining days for retirement: " + johnRemainingDays + " years.");
        System.out.println("Jane's remaining days for retirement: " + janeRemainingDays + " years." );
        System.out.println("Ahmet's remaining days for retirement: " + ahmetRemainingDays + " years.");
        System.out.println("Samet's remaining days for retirement: " + sametRemainingDays + " years.");




        printDepartmentDetails(finance);
        printDepartmentDetails(hr);
        printDepartmentDetails(engineering);
    }
    public static void printDepartmentDetails(Department department) {
        System.out.println("\n" + department.getName() + " Department:");

        // Print team lead
        System.out.println("Team Lead: " + department.getTeamLead().getName());

        // Print personnel list
        System.out.println("Personnel List:");
        for (Personel personel : department.getPersonelList().getPersonelList()) {
            System.out.println(personel);
        }

        // Print todo tasks and their status
        System.out.println("To-Do List:");
        List<Todo> todos = department.getTodos();
        for (int i = 0; i < todos.size(); i++) {
            System.out.println("Index " + i + ": " + todos.get(i));
        }
    }
}