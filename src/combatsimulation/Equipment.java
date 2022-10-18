
package combatsimulation;

import java.util.Random;

public enum Equipment {
    FEATHER("Feather Shot",20,"dex"),
    BOOTS("Quick Boots",10,"dex"),
    CAPE("Cape of Blitz",25,"dex"),
    POTION0("Purple Potion",20,"dex"),
    LCLOAK("Legendary Cloak",50,"dex"),
    
    SWORD("Sword",20,"atk"),
    SPEAR("Spear",30,"atk"),
    AXE("Double Sided Axe",40,"atk"),
    BOMB("Bomb",40,"atk"),
    POTION2("Red Potion",30,"atk"),
    
    SHIELD("Shield",20,"def"),
    ARMOUR("Light Armour",30,"def"),
    ARMOUR1("Heavy Armour",50,"def"),
    POTION1("Blue Potion",40,"def");

    final String equipName; 
    final int buffValue;
    final String type;
    
    //Setup for getting random enum entry
    private static final Random PRNG = new Random();
    private static final Equipment[] equipment = values();
    
    public static Equipment randomEquipment(){

        return equipment[PRNG.nextInt(equipment.length)];
    }
    
    Equipment (String name, int value, String type){
      this.equipName = name;
      this.buffValue = value;
      this.type = type;
    }
}
