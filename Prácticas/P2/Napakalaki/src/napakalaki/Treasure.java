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
public class Treasure {
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
    
    
    
    
    
}
