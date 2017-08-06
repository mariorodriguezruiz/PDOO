/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NapakalakiGame;

/**
 *
 * @author Mario
 */
public class Monster {
    private String name; //representa el nombre del monstruo.
    private int combatLevel; //representa el nivel de combate del monstruo.
    Prize price;
    BadConsequence bad;
    
    public Monster(String name, int level, BadConsequence bc, Prize price)
    {
        this.bad=bc;
        this.price=price;
        this.name=name;
        this.combatLevel=level;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getCombatLevel()
    {
        return combatLevel;
    }
    
    public BadConsequence getBadConsequence() 
    {
        return bad;
    }
    
    // Devuelve el número de niveles ganados proporcionados por su buen rollo.
    public int getLevelsGained()
    {
        return price.getLevel() ;
    }
    
    // Devuelve el número de tesoros ganados proporcionados por su buen rollo.
    public int getTreasuresGained()
    {
        return price.getTreasures() ;
    }
    
    // Devuelve true cuando el mal rollo del monstruo es muerte y false en caso contrario.
    public boolean kills()
    {
        return bad.myBadConsequencesIsDeath() ;
    }    
    
    @Override
    public String toString(){
        return "\nName = " + name 
                + " \n\tCombatLevel = " + Integer.toString(combatLevel) 
                + " \n\tPrices: "
                + price.toString() 
                + " \n\tBadConsequences: "
                + bad.toString();
    }    
}
