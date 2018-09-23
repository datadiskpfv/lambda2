package uk.co.datadisk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Main_Challenges_2 {

    public static void main(String[] args) {

        Supplier<String> iLoveJava = () -> "I Love Java";
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        System.out.println("---------------------------------------");
        List<String> topNames2015_1 = new ArrayList<>();

        topNames2015.forEach( name -> topNames2015_1.add(name.substring(0,1).toUpperCase() + name.substring(1)));
        topNames2015_1.sort((s1, s2) -> s1.compareTo(s2));                  // could use String::CompareTo
        topNames2015_1.forEach(name -> System.out.print( name + ", "));     // could use System.out::Print
        System.out.println();


        // the below is a better way to write above
        topNames2015.stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .sorted()
                .forEach( name -> System.out.print(name + ", "));


        // Number of names beginning with A
        System.out.println();
        long numberOfNamesBeginningWithA = topNames2015.stream()
                .map(name -> name.toUpperCase())
                .peek(name -> System.out.print(name + ", "))
                .filter(name -> name.startsWith("A"))
                .count();
        System.out.println("\nNumber of names beginning with A: " + numberOfNamesBeginningWithA);
     }

}
