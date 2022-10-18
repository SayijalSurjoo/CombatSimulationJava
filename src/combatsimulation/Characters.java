package combatsimulation;

import java.util.Random;

public enum Characters {
    HOBBIT(100,40,30,25,10,8),
    ELVE(200,85,60,52,60,4),
    DWARF(220,80,75,10,25,3),
    WARRIOR(250,100,70,25,50,5), 
    FIGHTER(200,50,50,30,22,3),
    WIZARD(180,48,55,41,20,7),
    KNIGHT(230,70,60,30,25,4),
    ASSASSIN(180,75,40,45,20,6),
    HEALER(130,30,50,45,20,2);
    
    //Keep your set values final 
    final int healthPts; 
    final int attackPts;
    final int defensePts;
    final int dexterity;
    final int critChance;
    final int critMultiplier;
    
    //Setup for getting random enum entry
    private static final Random PRNG = new Random();
    private static final Characters[] equipment = values();
    
    public static Characters randomCharacters(){
        return equipment[PRNG.nextInt(equipment.length)];
    }
    
     @Override
        public String toString() {
              String str1 = (healthPts+" HP Atk "+attackPts+" Def "+defensePts+" Dex "+dexterity+" Crit Chance "+critChance+"%");
              return str1;
        }

    Characters (int hp, int atk, int def, int dex, int cc, int cm){
      this.healthPts = hp;
      this.attackPts = atk;
      this.defensePts = def;
      this.dexterity = dex;
      this.critChance = cc;
      this.critMultiplier = cm;
    }
}
