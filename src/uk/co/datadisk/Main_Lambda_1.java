package uk.co.datadisk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_Lambda_1 {

    public static void main(String[] args) {
        // Single Statement
        // First part is the method parameters that you are going to pass
        // Second part is the ->
        // Third Part is the method
        new Thread(() -> System.out.println("Printing from the Runnable")).start();

        // Multiple statement line
        new Thread(() -> {
            System.out.println("This is Line 1 from the Runnable");
            System.out.println("This is Line 2 from the Runnable");
            System.out.println("This is Line 3 from the Runnable");
        }).start();

        Employee paul = new Employee("Paul", 50);
        Employee lorraine = new Employee("Lorraine", 46);
        Employee dominic = new Employee("Dominic", 21);
        Employee jessica = new Employee("Jessica", 18);

        List<Employee> employees = new ArrayList<>();
        employees.add(paul);
        employees.add(lorraine);
        employees.add(dominic);
        employees.add(jessica);

        // Use a Lambda to sort a Collection
        Collections.sort(employees, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));

        for(Employee emp : employees){
            System.out.println(emp.getName());
        }

        // String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        },
//        employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);

        UpperConcat uc = (s1, s2) -> s1.toUpperCase() +  s2.toUpperCase();
        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {

        // The uc is the Lambda expression
        // the upperAndConcat is from the interface
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    String upperAndConcat(String s1, String s2);
}
