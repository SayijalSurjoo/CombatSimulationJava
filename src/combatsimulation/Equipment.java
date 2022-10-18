package combatsimulation;

import java.util.Random;

public enum Equipment {
    FEATHER("Feather Shot",12,"dex"),
    BOOTS("Quick Boots",5,"dex"),
    LINK("Magic Cape",22,"dex"),
    POTION2("Purple Potion",15,"dex"),
    LCLOAK("Legendary Cloak",30,"dex"),
    CRASH("Aku Aku Mask",20,"dex"),
    BAYONETTA("Yellow Moon Lollipop",18,"dex"),
    TIME("Dagger of Time",8,"dex"),
    
    SWORD("Sword",20,"atk"),
    SPEAR("Spear",25,"atk"),
    AXE("Double Sided Axe",40,"atk"),
    BOWARROW("Long Bow",35,"atk"),
    BOMB("Fire Bombs",50,"atk"),
    MARIO("Mega Mushroom",80,"atk"),
    PACMAN("Power Pellet",60,"atk"),
    POTION0("Red Potion",22,"atk"),
    
    SHIELD("Shield",25,"def"),
    ARMOUR("Light Armour",20,"def"),
    ARMOUR1("Heavy Armour",30,"def"),
    CONTRA("Barrier",50,"def"),
    LARMOUR("Legendary Gold Saints Armour",70,"def"),
    POTION1("Blue Potion",22,"def"),
    FZERO("Captain Falcon’s Helmet",40,"def"),
    BORDERLAND("Psycho Mask",35,"def"),
    
    DK("Banana Juice",100,"hp"),
    KIRBY("Invincible Candy",150,"hp"),
    HERB("Green Herbs",50,"hp"),
    TMNT("The Ultimate Source",200,"hp"),
    FOODS("Chicken Leg",30,"hp");

    final String equipName; 
    final int buffValue;
    final String type;
    
    //Setup for getting random enum entry
    private static final Random PRNG = new Random();
    private static final Equipment[] equipment = values();
    
    public static Equipment randomEquipment(){
        return equipment[PRNG.nextInt(equipment.length)];
    }
    
    @Override
        public String toString() {
              String str1 = (equipName+" +"+buffValue+" to "+type);
              return str1;
        }
    
    Equipment (String name, int value, String type){
      this.equipName = name;
      this.buffValue = value;
      this.type = type;
    }
}