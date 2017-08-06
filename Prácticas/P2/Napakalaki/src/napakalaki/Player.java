/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Mario
 */
public class Player {
    
    private boolean dead = true ;
    private String name ;
    private int level ;    
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    BadConsequence pendingBadConsequence;

    public Player( String name ) 
    {
        this.name = name ;
    }

    // Devuelve la vida al jugador, modificando el atributo correspondiente.
    private void bringToLife()
    {
        dead = false ;
    }
    
    // Nivel de combate del jugador, que viene dado por su nivel más los bonus que le proporcionan los tesoros que tenga equipados.
    private int getCombatLevel()
    {
        int combatLevel = level ;
        boolean collar = false ;

        for ( int j = 0 ; j < visibleTreasures.size() ; j++ ) 
        {
            if ( visibleTreasures.get(j).getType() == TreasureKind.NECKLACE ) 
            {
                collar = true;
            }
        }

        if ( collar == true ) 
        {
            for ( int i = 0 ; i < visibleTreasures.size() ; i++ ) 
            {
                combatLevel += visibleTreasures.get(i).getMaxBonus() ;
            }
        } else 
        {
            for ( int j = 0 ; j < visibleTreasures.size() ; j++ ) 
            {
                combatLevel += visibleTreasures.get(j).getMinBonus() ;
            }
        }
        return combatLevel;
    }
    
    // Incrementa el nivel del jugador en i niveles, teniendo en cuenta las reglas del juego.
    private void incrementLevels ( int l )
    {
        level += l ;
    }
    
    // Decrementa el nivel del jugador en i niveles, teniendo en cuenta las reglas de juego.
    private void decrementLevels ( int l )
    {
        level -= l ;
    }
    
    // Asigna el mal rollo al jugador, dándole valor a su atributo pendingBadConsequence.
    private void setPendingBadConsequence( BadConsequence b )
    {
        pendingBadConsequence = b ;
    }
    
    // Cambia el estado de jugador a muerto si no tiene ni tesoros visibles ni ocultos, modificando el correspondiente atributo.
    private void dieIfNoTreasures()
    {
        if( visibleTreasures.isEmpty() && hiddenTreasures.isEmpty() )
            dead = true ;
    }
    
    private void discadNecklaceIfVisible()
    {
        
    }
    
    private void die()
    {
        
    }
    
    private int computeGoldCoinsValue( ArrayList<Treasure> t )
    {
        return 0 ;
    }
    
    // Devuelve true si con los niveles que compra no gana la partida y false en caso contrario.
    private boolean canIBuyLevels( int l )
    {
        int gana = l + level ;
        if( gana >= 10 )
            return false ;
        else
            return true ;
    }
    
    private void applyPrize( Monster currentMonster )
    {
        
    }
    
    private void applyBadConsequence( BadConsequence bad )
    {
        
    }
    
    private boolean canMakeTreasureVisible( Treasure t)
    {
        return false ;
    }
    
    // Devuelve el número de tesoros visibles que tiene del tipo tKind.
    private int howManyVisibleTreasures( TreasureKind tKind )
    {
        int cont = 0 ;
        for( int i = 0 ; i < visibleTreasures.size() ; i++ )
        {
            if( visibleTreasures.get(i).getType() == tKind )
                cont++ ;
        }
        return cont ;            
    }
    
    //Devuelve true si el jugador está muerto, false en caso contrario.
    private boolean isDead()
    {
        return dead ;
    }

    public ArrayList<Treasure> getHiddenTreasures() 
    {
        return hiddenTreasures;
    }

    public ArrayList<Treasure> getVisibleTreasures() 
    {
        return visibleTreasures;
    }
    
    public CombatResult combat( Monster m )
    {
        return null ;
    }
    
    public void makeTreasureVisible( Treasure t )
    {
        
    }
    
    public void discardVisibleTreasure( Treasure t)
    {
        
    }
    
    public void discardHiddenTreasure( Treasure t)
    {
        
    }
    
    public boolean buyLevels( ArrayList<Treasure> visible, ArrayList<Treasure> hidden )
    {
        return false ;
    }
    
    // Devuelve true cuando el jugador no tiene ningún mal rollo que cumplir  y no tiene más de 4 tesoros ocultos y false en caso contrario.
    public boolean validState()
    {
        if( pendingBadConsequence.isEmpty() == true && hiddenTreasures.size() <= 4 )
            return true ;
        else 
            return false ;
    }
    
    public void initTreasures()
    {
        
    }
    
    // Devuelve true cuando el jugador tiene algún tesoro visible y false en caso contrario.
    public boolean hasVisibleTreasures()
    {
        if( visibleTreasures.isEmpty() )
            return false ;
        else
            return true ;
    }
    
    public int getLevels()
    {
        return level ;
    }
}
