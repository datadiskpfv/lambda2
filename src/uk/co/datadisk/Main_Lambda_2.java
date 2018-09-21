package uk.co.datadisk;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main_Lambda_2 {

    // Functional Lambda's

    public static void main(String[] args) {

        Employee paul = new Employee("Paul Valle", 50);
        Employee lorraine = new Employee("Lorraine Valle", 46);
        Employee dominic = new Employee("Dominic Valle", 21);
        Employee jessica = new Employee("Jessica Valle", 18);

        Employee will = new Employee("Will Hay", 86);
        Employee moore = new Employee("Moore Marriott", 84);
        Employee graham = new Employee("Graham Moffat", 78);

        List<Employee> employees = new ArrayList<>();
        employees.add(paul);
        employees.add(lorraine);
        employees.add(dominic);
        employees.add(jessica);
        employees.add(will);
        employees.add(moore);
        employees.add(graham);



//        employees.forEach( employee -> {
//            System.out.println(employee.getName() + " " + employee.getAge());
//        });

        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);

        Predicate<Employee> predicateLessThanAndEqual30 = employee -> employee.getAge() <= 30;
        printEmployeesByAge(employees, "Employees 30 and under", predicateLessThanAndEqual30);

        // Function are good for call backs
        Function<Employee, String> getLastName = (employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        String lastName = getLastName.apply(employees.get(2));
        System.out.println("Function get lastName " + lastName);
    }

    private static void printEmployeesByAge(List<Employee> employees,
                                            String ageText,
                                            Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("===================");
        for (Employee employee : employees){
            if(ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        }

    }
}
