package uk.co.datadisk;

import java.util.function.Function;

public class Main_Challenges_1 {

    public static void main(String[] args) {

        System.out.println("-----------------------------------------");
        Runnable runnable1 = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };
        new Thread(runnable1).start();

        System.out.println("-----------------------------------------");
        Function<String, String> everySecondCharFunc = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1){
                    returnVal.append(source.charAt(i));
                }
            }

            return returnVal.toString();
        };

        System.out.println(everySecondCharFunc.apply("1234567890"));

        System.out.println("-----------------------------------------");
        System.out.println(displayEverySecondCharacter(everySecondCharFunc, "1234567890"));

    }

    private static String displayEverySecondCharacter(Function<String, String> func, String source){
        return func.apply(source);
    }
}
