package javaenums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaEnums {
    
static int enemyHp, enemyAtk, enemyDef, enemyDex;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        generateEnemy();
        
        System.out.println("Fight this enemy");
        int data1 = input.nextInt();
        if (data1 == 1){
          
          getCharacter();
        } else if(data1 == 2){
      System.exit(0);
    }
        
    }
    
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
    return random.nextInt(max - min) + min;
    }
    
    public static String getBuffs(){
        String selectedBuff = null;
        Scanner input = new Scanner(System.in);
     String[] equipBuff = {"Sword","Spear","Bomb","Shield","Armour","Potion"};
      List<String> intList = Arrays.asList(equipBuff);
	Collections.shuffle(intList);
	intList.toArray(equipBuff);
        String buff1 = equipBuff[0];
        String buff2 = equipBuff[1];
        String buff3 = equipBuff[2];
        System.out.println("Select one buff using the corresponding number");
        System.out.println("1."+buff1+" 2."+buff2+" 3."+buff3);
        int data1 = input.nextInt();
        switch(data1){
            case 1:
                selectedBuff = buff1;
                break;
            case 2:
                selectedBuff = buff2;
                break;
            case 3:
                selectedBuff = buff3;
                break;
        }
        System.out.println("You picked buff: "+selectedBuff);
        return selectedBuff;
    }
    
    public static void computeBuffs(int hp, int atk, int def, int dex, int cc, double cm, String name){
       
        
        switch(getBuffs()){
            case "Sword":
                atk = atk + 20;
                break;
            case "Spear":
                atk = atk + 30;
                break;
            case "Bomb":
                atk = atk + 40;
                break;
            case "Shield":
                def = def + 20;
                break;
            case "Armour":
                def = def + 30;
                break;
            case "Potion":
                def = def + 40;
                break;
        }
         System.out.println("Your character "+name+" : "+hp+" HP Atk "+atk+" Def "+def+" Dex "+dex);
        combat(hp, atk, def, dex);
    }
    
    public static void getCharacter(){
        Characters character [] = Characters.values();
        List<Characters> intList = Arrays.asList(character);
	Collections.shuffle(intList);
	intList.toArray(character);
        String yourCharater = character[0].toString();     

        switch(yourCharater) {
            case "SOLDIER":
                computeBuffs(Characters.SOLDIER.healthPts, Characters.SOLDIER.attackPts, Characters.SOLDIER.defensePts, 
                        Characters.SOLDIER.dexterity, Characters.SOLDIER.critChance, Characters.SOLDIER.critMultipler,  Characters.SOLDIER.toString());
                break;
            case "FIGHTER":
                computeBuffs(Characters.FIGHTER.healthPts, Characters.FIGHTER.attackPts, Characters.FIGHTER.defensePts, 
                        Characters.FIGHTER.dexterity, Characters.FIGHTER.critChance, Characters.FIGHTER.critMultipler,Characters.FIGHTER.toString());
                break;
            case "WIZARD":
                computeBuffs(Characters.WIZARD.healthPts, Characters.WIZARD.attackPts, Characters.WIZARD.defensePts, 
                        Characters.WIZARD.dexterity, Characters.WIZARD.critChance, Characters.WIZARD.critMultipler, Characters.WIZARD.toString());
                break;
            case "ASSASSIN":
                computeBuffs(Characters.ASSASSIN.healthPts, Characters.ASSASSIN.attackPts, Characters.ASSASSIN.defensePts, 
                        Characters.ASSASSIN.dexterity, Characters.ASSASSIN.critChance, Characters.ASSASSIN.critMultipler, Characters.ASSASSIN.toString());
                break;
            case "THIEF":
                computeBuffs(Characters.THIEF.healthPts, Characters.THIEF.attackPts, Characters.THIEF.defensePts, 
                        Characters.THIEF.dexterity, Characters.THIEF.critChance, Characters.THIEF.critMultipler, Characters.THIEF.toString());
                break;
        }
    }
    
    public static void generateEnemy(){
        enemyHp = getRandomNumber(150,300);
        enemyAtk = getRandomNumber(20,80);
        enemyDef = getRandomNumber(20,80);
        enemyDex = getRandomNumber(10,30);

        System.out.println("Enemy : "+enemyHp+" HP Atk "+enemyAtk+" Def "+enemyDef+" Dex "+enemyDex);
    }
    
    public static void combat(int hp, int atk, int def, int dex){
        
        int damage;
        while (hp > 0 && enemyHp > 0){   

            //Enemy gets attacked
            int dexIndex = getRandomNumber(1,100); 
            if (dexIndex <= enemyDex){ //Checks if enemy dodged the attack
                System.out.println("Enemy dodged the attack");
            }else {
                damage = atk - enemyDef;
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
               
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(JavaEnums.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Player gets attacked
            dexIndex = getRandomNumber(1,100); 
            if (dexIndex <= dex){ //Checks if player dodged the attack
                System.out.println("You have dodged the attack");
            }else {
                damage = enemyAtk - def;
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
            damage = 0;  
        }
    }
}
