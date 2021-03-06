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
public class Treasure implements Card{
    private String name ;
    private int goldCoins ;
    private int minBonus ;
    private int maxBonus ;
    TreasureKind type ;

    public Treasure(String n, int g, int min, int max, TreasureKind t) 
    {
        this.name = n ;
        this.goldCoins = g ;
        this.minBonus = min ;
        this.maxBonus = max ;
        this.type = t ;
    }
    
    public String getName()
    {
        return name ;
    }
    
    public int getGoldCoins()
    {
        return goldCoins ;
    }
    
    public int getMinBonus()
    {
        return minBonus;
    }

    public int getMaxBonus() {
        return maxBonus;
    }

    public TreasureKind getType() {
        return type;
    }
    
    public int getBasicValue()
    {
        return this.getMinBonus() ;
    }
    
    public int getSpecialValue()
    {
        return this.getMaxBonus() ;
    }
    
    @Override
    public String toString()
    {
        return this.name 
                + "\n\tGoldCoins = " + Integer.toString(this.goldCoins) 
                + "\n\tMinBonus = " + Integer.toString(this.minBonus) 
                + "\n\tMaxBonus = " + Integer.toString(this.maxBonus)
                + "\n\tType = " + this.getType() ;
    }    
}
