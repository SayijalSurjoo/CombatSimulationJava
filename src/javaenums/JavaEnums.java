package javaenums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaEnums {
    
static int enemyHp, enemyAtk, enemyDef, enemyDex;

    public static void main(String[] args) {
        generateEnemy();
        getCharacter();
    }
    
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
    return random.nextInt(max - min) + min;
    }
    
    public static void getCharacter(){
        Characters character [] = Characters.values();
        List<Characters> intList = Arrays.asList(character);
	Collections.shuffle(intList);
	intList.toArray(character);
        String yourCharater = character[0].toString();     

        switch(yourCharater) {
            case "SOLDIER":
                combat(Characters.SOLDIER.healthPts, Characters.SOLDIER.attackPts, 
                        Characters.SOLDIER.defensePts, Characters.SOLDIER.dexterity, Characters.SOLDIER.toString());
                break;
            case "FIGHTER":
                combat(Characters.FIGHTER.healthPts, Characters.FIGHTER.attackPts, 
                        Characters.FIGHTER.defensePts, Characters.FIGHTER.dexterity, Characters.FIGHTER.toString());
                break;
            case "WIZARD":
                combat(Characters.WIZARD.healthPts, Characters.WIZARD.attackPts, 
                        Characters.WIZARD.defensePts, Characters.WIZARD.dexterity, Characters.WIZARD.toString());
                break;
            case "ASSASSIN":
                combat(Characters.ASSASSIN.healthPts, Characters.ASSASSIN.attackPts, 
                        Characters.ASSASSIN.defensePts, Characters.ASSASSIN.dexterity, Characters.ASSASSIN.toString());
                break;
            case "THIEF":
                combat(Characters.THIEF.healthPts, Characters.THIEF.attackPts, 
                        Characters.THIEF.defensePts, Characters.THIEF.dexterity, Characters.THIEF.toString());
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
    
    public static void combat(int hp, int atk, int def, int dex, String name){
        System.out.println("Your character "+name+" : "+hp+" HP Atk "+atk+" Def "+def+" Dex "+dex);
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
