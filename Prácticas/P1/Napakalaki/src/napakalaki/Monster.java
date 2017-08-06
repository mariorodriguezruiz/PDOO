/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package napakalaki;

/**
 *
 * @author Mario
 */
public class Monster {
    private String name; //representa el nombre del monstruo.
    private int combatLevel; //representa el nivel de combate del monstruo.
    Prize price;
    BadConsequence bc;
    
    Monster(String name, int level, BadConsequence bc, Prize price)
    {
        this.bc=bc;
        this.price=price;
        this.name=name;
        this.combatLevel=level;
    }
    
    String getName()
    {
        return name;
    }
    
    int getCombatLevel()
    {
        return combatLevel;
    }
    
    @Override
    public String toString(){
        return "\nName = " + name 
                + " \n\tCombatLevel = " + Integer.toString(combatLevel) 
                + " \n\tPrices: "
                + price.toString() 
                + " \n\tBadConsequences: "
                + bc.toString();
    }          
}
