
package javaenums;

public enum PowerLevel {
    SOLDIER(60,5.5), 
    FIGHTER(80, 5),
    WIZARD(30, 6.2),
    ASSASSIN(70, 8),
    THIEF(45, 7.6);
    //Keep your set values final 
    final int powerLevel; 
    final double speed;
    PowerLevel (int powerLevel, double speed){
      this.powerLevel = powerLevel;
      this.speed = speed;
    }
}
