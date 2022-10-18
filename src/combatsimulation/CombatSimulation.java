package combatsimulation;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CombatSimulation {
    
static int enemyHp, enemyAtk, enemyDef, enemyDex, enemyCrit;
static int level;
private static final double ENEMYCRITMULTIPLER = 1.5;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Select the level you want from (1-3), higher level means stronger enemies and more equipment");
        String data0 = input.nextLine();
        try {
        level = Integer.parseInt(data0);
        } catch (NumberFormatException n){
            System.out.println("This is not a number");
            System.exit(0);
        }
        generateEnemy();
        System.out.println("Level set to : "+level);
        System.out.println("Encountered new enemy! Fight this enemy? (1 = yes, 0 = no)");
        String data1 = input.nextLine();
        int userInput = 3;
        try {
        userInput = Integer.parseInt(data1);
        } catch (NumberFormatException n){
            System.out.println("This is not a number");
        }
    switch (userInput) {
        case 1:
            getCharacter();
            input.close();
            break;
        case 0:
            System.out.println("Little Bitch");
            input.close();
            System.exit(0);            
        default:
            System.out.println("Please only use 1 and 0");
            input.close();
            System.exit(0);
           
    }
    
        
    }

public static void assignEquipment(int hp, int atk, int def, int dex, int cc, double cm, String name){
         System.out.println("Your character "+name+" : "+hp+" HP Atk "+atk+" Def "+def+" Dex "+dex+" Crit Chance "+cc+"%");
    for (int i = 1; i <= level; i++){     
         Equipment equip = Equipment.randomEquipment();
         String equipName = equip.equipName;
         int buff = equip.buffValue;
         String keyType = equip.type;
         System.out.println("Equipment you found "+equipName+" :"+buff);
         
        switch (keyType) {
            case "atk":
                atk = atk + buff;
                break;
            case "def":
                def = def + buff;
                break;
            case "dex":
                dex = dex + buff;
                if (dex > 100){
                 dex = 100;
                }
                break;
            default:
                break;
        }
         try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(CombatSimulation.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    System.out.println("Your character "+name+" : "+hp+" HP Atk "+atk+" Def "+def+" Dex "+dex+" Crit Chance "+cc+"%");
    combat(hp, atk, def, dex, cc, cm);
  }
    
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
    return random.nextInt(max - min) + min;
    }
 
    public static void getCharacter(){
        Characters unit = Characters.randomCharacters();

        int health = unit.healthPts;
        int attack = unit.attackPts;
        int defense = unit.defensePts;
        int dexterity = unit.dexterity;
        int critPercent = unit.critChance;
        double critMultipler = unit.critMultipler;
        String unitName = unit.name();

        assignEquipment(health, attack, defense, dexterity, critPercent, critMultipler, unitName);
    }
    
    public static void generateEnemy(){
       switch(level){
           case 1:
                enemyHp = getRandomNumber(150,200);
                enemyAtk = getRandomNumber(20,80);
                enemyDef = getRandomNumber(20,80);
                enemyDex = getRandomNumber(10,30);
                enemyCrit = getRandomNumber(1,10);
           break;
           case 2:
                enemyHp = getRandomNumber(200,250);
                enemyAtk = getRandomNumber(20,80);
                enemyDef = getRandomNumber(20,80);
                enemyDex = getRandomNumber(10,30);
                enemyCrit = getRandomNumber(1,10);
           break;
           case 3:
                enemyHp = getRandomNumber(250,300);
                enemyAtk = getRandomNumber(20,80);
                enemyDef = getRandomNumber(20,80);
                enemyDex = getRandomNumber(10,30);
                enemyCrit = getRandomNumber(1,10);
                break;
           default:
               System.out.println("Select level from 1 to 3!");
               System.exit(0);          
       }
        System.out.println("Enemy : "+enemyHp+" HP Atk "+enemyAtk+" Def "+enemyDef+" Dex "+enemyDex+" Crit "+enemyCrit+"%");
    }
    
    public static void combat(int hp, int atk, int def, int dex, int cc, double cm){
        int critValue = 0;
        int damage;
        if (enemyAtk < def && atk < enemyDef){
            System.out.println("Fight DNF");
        }else{
        while (hp > 0 && enemyHp > 0){   

            //Enemy gets attacked------------------------------------------------------
            int dexIndex = getRandomNumber(1,100); 
            if (dexIndex <= enemyDex){ //Checks if enemy dodged the attack
                System.out.println("Enemy dodged the attack");
            }else {
                //Crit chance and calculation 
                int critIndex = getRandomNumber(1,100);
                if (critIndex <= cc){
                    critValue = (int) cm;
                    critValue = (atk/2) * critValue;
                    
                    System.out.println("You Crit for "+critValue);
                    
                 }
                damage = atk - enemyDef;
                damage = damage + critValue;
                if (damage < 0){
                damage = 0;
                }
                enemyHp = enemyHp - damage;
                System.out.println("Enemy HP remaining "+enemyHp);
            }
            
            if (enemyHp <= 0){
            System.out.println("Enemy Died");
            break;
            }

            //Player gets attacked-----------------------------------------------------------
            dexIndex = getRandomNumber(1,100); 
            if (dexIndex <= dex){ //Checks if player dodged the attack
                System.out.println("You have dodged the attack");
            }else {
                    //Crit chance and calculation 
                    int critIndex = getRandomNumber(1,100);
                if (critIndex <= enemyCrit){
                    critValue = (enemyAtk/2) * (int )ENEMYCRITMULTIPLER;
                    
                    System.out.println("Enemy Crit for "+critValue);
                    
                 }
                damage = enemyAtk - def;
                damage = damage + critValue;
                if (damage < 0){
                    damage = 0;
                }
                hp = hp - damage;
                System.out.println("HP remaining "+hp);
            }
            
            if (hp <= 0){
                System.out.println("You Died");
                break;
            }
           //A round of fists take 1 sec                
           try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(CombatSimulation.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            damage = 0;  
            critValue = 0;
        }
        }
    }
}
