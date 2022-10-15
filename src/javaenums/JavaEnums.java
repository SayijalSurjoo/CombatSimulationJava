package javaenums;

public class JavaEnums {

    public static void main(String[] args) {
        //loops through the array and prints out values, .values stores all value in an enum to an array
        for (PowerLevel level : PowerLevel.values()){
            System.out.println(level);
        }
        
        int power = PowerLevel.SOLDIER.powerLevel;
        double speed = PowerLevel.SOLDIER.speed;
        PowerLevel unit = PowerLevel.SOLDIER;
        System.out.println("The "+unit+" has Attack : "+power+" and Speed : "+speed);
    }
    
}
