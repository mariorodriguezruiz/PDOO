/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author Mario Rodríguez
 */
public class CultistPlayer extends Player {
    
    private static int totalCultistPlayers = 0 ;
    private Cultist myCultistCard ;
    
    /*  Llamará al nuevo constructor de copia
        de Player. Asimismo, incrementará en uno la variable de clase
        totalCultistPlayers. */
    public CultistPlayer( Player p, Cultist c ) 
    {
        super(p) ;
        this.myCultistCard = c ;
        totalCultistPlayers++ ;
    }
    
    /*  Para calcular su nivel de combate sumando el getCombatLevel() de Player 
        más lo que devuelve el método getSpecialValue() de su carta de sectario (Cultist). */
    @Override
    protected int getCombatLevel()
    {
        return super.getCombatLevel() + this.myCultistCard.getSpecialValue() ;
    }
    
    @Override
    protected boolean shouldConvert()
    {
        return false ;
    }
    
    @Override
    protected int getOponentLevel( Monster m )
    {
        return m.getSpecialValue() ;
    }
    
    // Se redefine de manera que las piezas de oro dupliquen su valor a la hora de canjearlas por niveles.
    @Override
    protected float computeGoldCoinsValue( ArrayList< Treasure > t )
    {
        return super.computeGoldCoinsValue(t) * 2 ;
    }
    
    public static int getTotalCultistPlayers()
    {
        return totalCultistPlayers;
    }
    
    public Cultist getCultistCard()
    {
        return this.myCultistCard ;
    }   
}
