package javaenums;

public class JavaEnums {

    public static void main(String[] args) {
        //loops through the array and prints out values, .values stores all value in an enum to an array
        for (PowerLevel level : PowerLevel.values()){
            System.out.println(level);
        }
    }
    
}
