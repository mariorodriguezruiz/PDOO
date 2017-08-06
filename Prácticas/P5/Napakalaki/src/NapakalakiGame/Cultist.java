/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author Mario Rodríguez
 */
public class Cultist implements Card {
    
    private String name ;
    private int gainedLevels ;
    
    public Cultist( String n, int gL)
    {
        this.name = n ;
        this.gainedLevels = gL ;
    }
    
    @Override
    public int getBasicValue()
    {
        return this.gainedLevels ;
    }
    
    @Override
    public int getSpecialValue()
    {
        return this.getBasicValue() * CultistPlayer.getTotalCultistPlayers() ;
    }
    
    public String getName()
    {
        return this.name ;
    }
}
