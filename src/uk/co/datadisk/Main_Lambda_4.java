package uk.co.datadisk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main_Lambda_4 {

    public static void main(String[] args) {

        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");

//        List<String> gNumbers = new ArrayList<>();
//        someBingoNumbers.forEach(number -> {
//            if(number.toUpperCase().startsWith("G")){
//                gNumbers.add(number);
//                //System.out.println(number);
//            }
//        });
//
//        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
//        gNumbers.forEach((String s) -> System.out.println(s));

        // New way using streams
        // The source does not change
        someBingoNumbers.stream()
                .map(String::toUpperCase)               // String::toUpperCase  = method reference (contains all numbers upper cased)
                .filter(s -> s.startsWith("G"))         // only return numbers with capital G (result = G53, G49, G60, G50, G64)
                .sorted()                               // sort by natural ordering (can use your own comparator)
                .forEach(System.out::println);          // print out all the results using a consumer

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        System.out.println("-----------------------------------");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println(concatStream.
                distinct()
                .peek(System.out::println)
                .count()
        );

        Employee paul = new Employee("Paul Valle", 50);
        Employee lorraine = new Employee("Lorraine Valle", 46);
        Employee dominic = new Employee("Dominic Valle", 21);
        Employee jessica = new Employee("Jessica Valle", 18);
        Employee bob = new Employee("Bob Hope", 50);

        Department hr = new Department("Human Resources");
        hr.addEmployee(lorraine);
        hr.addEmployee(jessica);
        hr.addEmployee(dominic);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(paul);
        accounting.addEmployee(bob);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())      // return a resource stream
                .forEach(System.out::println);                                  // will use the returned resource stream

        List<String> sortedGNumbers = someBingoNumbers.stream()
                .map(String::toUpperCase)               // String::toUpperCase  = method reference (contains all numbers upper cased)
                .filter(s -> s.startsWith("G"))         // only return numbers with capital G (result = G53, G49, G60, G50, G64)
                .sorted()                               // sort by natural ordering (can use your own comparator)
                .collect(Collectors.toList());          // return a list of the results

        for(String s : sortedGNumbers){
            System.out.print(s + " ");
        }

        // Using groupBy to group results
        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        System.out.println();
        for(Map.Entry<Integer, List<Employee>> e: groupedByAge.entrySet()){
            System.out.print(e.getKey() + " - ");
            for (Employee emp : e.getValue()){
                System.out.print(emp.getName() + ", ");
            }
            System.out.println();
        }

        System.out.println("=======================================");
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)        // returns an optional
                .ifPresent(System.out::println);                                // because above returns an optional we use a ifPresent

    }
}
