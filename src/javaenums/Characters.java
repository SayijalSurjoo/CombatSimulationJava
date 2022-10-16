
package javaenums;

public enum Characters {
    SOLDIER(200,60,60,25), 
    FIGHTER(200,70,60,40),
    WIZARD(200,30,50,45),
    ASSASSIN(200,65,30,70),
    THIEF(200,40,40,45);
    //Keep your set values final 
    final int healthPts; 
    final int attackPts;
    final int defensePts;
    final int dexterity;
    Characters (int hp, int atk, int def, int dex){
      this.healthPts = hp;
      this.attackPts = atk;
      this.defensePts = def;
      this.dexterity = dex;
    }
}
