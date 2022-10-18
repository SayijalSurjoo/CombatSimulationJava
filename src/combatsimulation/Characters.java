
package combatsimulation;

import java.util.Random;

public enum Characters {
    HOBBIT(120,50,40,25,5,1.5),
    ELVE(200,80,50,70,45,2),
    DWARF(250,70,70,10,25,2),
    WARRIOR(200,60,60,25,20,2), 
    FIGHTER(200,70,60,40,20,2),
    WIZARD(200,30,50,45,20,2),
    KNIGHT(200,50,50,30,25,2),
    ASSASSIN(200,65,30,70,20,2),
    THIEF(200,40,40,45,20,2);
    
    //Keep your set values final 
    final int healthPts; 
    final int attackPts;
    final int defensePts;
    final int dexterity;
    final int critChance;
    final double critMultipler;
    
    //Setup for getting random enum entry
    private static final Random PRNG = new Random();
    private static final Characters[] equipment = values();
    
    public static Characters randomCharacters(){

        return equipment[PRNG.nextInt(equipment.length)];
    }
    
    Characters (int hp, int atk, int def, int dex, int cc, double cm){
      this.healthPts = hp;
      this.attackPts = atk;
      this.defensePts = def;
      this.dexterity = dex;
      this.critChance = cc;
      this.critMultipler = cm;
    }
}
