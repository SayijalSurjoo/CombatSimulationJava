
package javaenums;

public enum Characters {
    SOLDIER(200,60,60,25,20,2), 
    FIGHTER(200,70,60,40,20,2),
    WIZARD(200,30,50,45,20,2),
    ASSASSIN(200,65,30,70,20,2),
    THIEF(200,40,40,45,20,2);
    //Keep your set values final 
    final int healthPts; 
    final int attackPts;
    final int defensePts;
    final int dexterity;
    final int critChance;
    final double critMultipler;
    Characters (int hp, int atk, int def, int dex, int cc, double cm){
      this.healthPts = hp;
      this.attackPts = atk;
      this.defensePts = def;
      this.dexterity = dex;
      this.critChance = cc;
      this.critMultipler = cm;
    }
}
