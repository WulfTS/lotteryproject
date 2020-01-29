package cpt200h190.lotteryproject.humanreadableidgenerator;

import java.util.Random;

public interface HumanReadableIdGenerator {

    static String GeneratePersonValue(String firstName, String lastName) {
        Random random = new Random();
        return firstName.substring(0,1)+lastName.substring(0,1)+ Integer.toString(random.nextInt(999999));
    }

    static String GenerateDrawingValue(String name){
        Random random = new Random();
        String[] sections = name.split(" ");

        String stringVal = "";
        for (String word:sections) stringVal = stringVal + word.substring(0, 1);

        stringVal = stringVal + Integer.toString(random.nextInt(999999));

        return stringVal;
    }

    static String GenerateTicketValue(String color){
        Random random = new Random();

        String stringVal = "";
        if(color == null){
            stringVal = "GEN";
        }else {
            stringVal = color.toUpperCase();
        }
        return stringVal + Integer.toString(random.nextInt(999999));
    }

    static String GenerateTicketValue(){
        Random random = new Random();

        String stringVal = "GEN";

        return stringVal + Integer.toString(random.nextInt(999999));
    }

}
