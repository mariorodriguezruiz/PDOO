/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author Mario
 */
public class Player {
    
    private boolean dead = true ;
    private String name ;
    private int level ;    
    private ArrayList<Treasure> visibleTreasures = new ArrayList() ;
    private ArrayList<Treasure> hiddenTreasures = new ArrayList() ;
    private BadConsequence pendingBadConsequence ;

    public Player( String name ) 
    {
        this.name = name ;
    }

    // Devuelve la vida al jugador, modificando el atributo correspondiente.
    private void bringToLife()
    {
        this.dead = false ;
    }
    
    // Nivel de combate del jugador, que viene dado por su nivel más los bonus que le proporcionan los tesoros que tenga equipados.
    public int getCombatLevel()
    {
        int combatLevel = this.level ;
        boolean collar = false ;

        for ( int j = 0 ; j < this.visibleTreasures.size() ; j++ ) 
        {
            if ( this.visibleTreasures.get(j).getType() == TreasureKind.NECKLACE ) 
            {
                collar = true ;                
            }
        }

        if ( collar == true ) 
        {
            for ( int i = 0 ; i < this.visibleTreasures.size() ; i++ ) 
            {
                combatLevel += this.visibleTreasures.get(i).getMaxBonus() ;
            }
        } else 
        {
            for ( int j = 0 ; j < this.visibleTreasures.size() ; j++ ) 
            {
                combatLevel += this.visibleTreasures.get(j).getMinBonus() ;
            }
        }
        return combatLevel;
    }
    
    // Incrementa el nivel del jugador en i niveles, teniendo en cuenta las reglas del juego.
    private void incrementLevels ( int l )
    {
        this.level += l ;
    }
    
    // Decrementa el nivel del jugador en i niveles, teniendo en cuenta las reglas de juego.
    private void decrementLevels ( int l )
    {
        this.level -= l ;
    }
    
    // Asigna el mal rollo al jugador, dándole valor a su atributo pendingBadConsequence.
    private void setPendingBadConsequence( BadConsequence b )
    {
        this.pendingBadConsequence = b ;
    }
    
    // Cambia el estado de jugador a muerto si no tiene ni tesoros visibles ni ocultos, modificando el correspondiente atributo.
    private void dieIfNoTreasures()
    {
        if( this.visibleTreasures.isEmpty() && this.hiddenTreasures.isEmpty() )
            this.dead = true ;
    }
    
    // Si el jugador tiene equipado el tesoro tipo NECKLACE, se lo pasa al CardDealer y lo
    // elimina de sus tesoros visibles.
    private void discardNecklaceIfVisible()
    {
        CardDealer dealer = CardDealer.getInstance() ;
        
        for( Treasure tesoro: this.visibleTreasures )
        {
            if(tesoro.getType() == TreasureKind.NECKLACE)
            {                
                dealer.giveTreasureBack( tesoro ) ;
                this.visibleTreasures.remove( tesoro ) ;
            }
        }       
    }
    
/*  Cuando el jugador muere en un combate, esta operación es la encargada de dejarlo sin
    tesoros, ponerle el nivel a 1 e indicar que está muerto, en el atributo correspondiente. */
    private void die()
    {
        this.level = 1 ;
        CardDealer dealer = CardDealer.getInstance() ;
        
        for( int i = 0 ; i < this.visibleTreasures.size() ; i++ )        
            dealer.giveTreasureBack( this.visibleTreasures.get(i) ) ;
                
        this.visibleTreasures.clear() ;
        
        for( int i = 0 ; i < this.hiddenTreasures.size() ; i++ )        
            dealer.giveTreasureBack( this.hiddenTreasures.get(i) ) ;
                
        this.hiddenTreasures.clear() ;        
        this.dieIfNoTreasures() ;
    }
    
    // Calcula y devuelve los niveles que puede comprar el jugador con la lista t de tesoros.
    private float computeGoldCoinsValue( ArrayList<Treasure> t )
    {
        int dinero = 0;        
        for ( int i = 0 ; i < t.size() ; i++ )
        {
            dinero += t.get(i).getGoldCoins() ;            
        }
        return (dinero/1000) ;
    }
    
    // Devuelve true si con los niveles que compra no gana la partida y false en caso contrario.
    private boolean canIBuyLevels( int l )
    {
        int gana = l + this.level ;
        if( gana >= 10 )
            return false ;
        else
            return true ;
    }
    
/*  Cuando el jugador gana el combate, esta operación es la encargada de aplicar el buen
    rollo al jugador, sumando los niveles correspondiente y robando los tesoros indicados en el
    buen rollo del monstruo.    */
    private void applyPrize( Monster currentMonster )
    {
        CardDealer dealer ;
        int nLevels = currentMonster.getLevelsGained() ;
        this.incrementLevels( nLevels ) ;
        int nTreasures = currentMonster.getTreasuresGained() ;
        
        if( nTreasures > 0)
        {
            dealer = CardDealer.getInstance() ;
        
            for ( int i = 1 ; i <= nTreasures ; i++ )
            {
                Treasure treasure = dealer.nextTreasure() ;
                this.hiddenTreasures.add(treasure);
            }
        }
    }
    
/*  Cuando el jugador ha perdido el combate, no ha podido huir y no muere, hay que almacenar el mal rollo 
    que le impone el monstruo con el que combatió. Para ello, decrementa sus niveles según indica el mal rollo 
    y guarda una copia de un objeto badConsequence ajustada a los tesoros que puede perder según indique el mal rollo del
    monstruo y de los tesoros que disponga el jugador, la operación encargada de hacer esto es adjustToFitTreasureList 
    de la clase badConsequence, este es el mal rollo pendiente (pendingbadConsequence) que el jugador almacenará y que deberá cumplir
    descartándose de esos tesoros antes de que pueda pasar al siguiente turno.      */
    private void applyBadConsequence( BadConsequence bad )
    {
        int nLevels = bad.getLevels();
       this.decrementLevels(nLevels);
       BadConsequence pendingbad = bad.adjustToFitTreasureLists(this.visibleTreasures, this.hiddenTreasures);
       this.setPendingBadConsequence(pendingbad);
    }
    
    // Comprueba si el tesoro (t) se puede pasar de oculto a visible, según las reglas del juego.
    /* Cada jugador podría equiparse en el mejor de los casos con una armadura, 
       un tesoro de dos manos, un casco, un calzado y un collar; o con
       una armadura, dos tesoros de una mano, un casco, un calzado y un collar. */
    private boolean canMakeTreasureVisible( Treasure t)
    {
        boolean puedeVisible = true;
        int contiene = 0;

        for ( int i = 0; i < this.visibleTreasures.size(); i++) 
        {
            if ( this.visibleTreasures.get(i).getType() == TreasureKind.ONEHAND ) 
            {
                contiene += 1 ;
            }

            if ( this.visibleTreasures.get(i).getType() == TreasureKind.BOTHHAND ) 
            {
                puedeVisible = false ;
            }

            if ( this.visibleTreasures.get(i).getType() == t.getType() ) 
            {
                puedeVisible = false ;
            }
        }

        if ( contiene > 1 ) 
        {
            puedeVisible = false ;
        }

        return puedeVisible ;
    }
    
    // Devuelve el número de tesoros visibles que tiene del tipo tKind.
    private int howManyVisibleTreasures( TreasureKind tKind )
    {
        int cont = 0 ;
        for( int i = 0 ; i < this.visibleTreasures.size() ; i++ )
        {
            if( this.visibleTreasures.get(i).getType() == tKind )
                cont++ ;
        }
        return cont ;            
    }
    
    //Devuelve true si el jugador está muerto, false en caso contrario.
    public boolean isDead()
    {
        return this.dead ;
    }

    public ArrayList<Treasure> getHiddenTreasures() 
    {
        return this.hiddenTreasures;
    }

    public ArrayList<Treasure> getVisibleTreasures() 
    {
        return this.visibleTreasures;
    }
    
    public CombatResult combat( Monster m )
    {        
        int myLevel = this.getCombatLevel() ;
        int monsterLevel = m.getCombatLevel() ;
        CombatResult combatResult ;
       
        if ( myLevel > monsterLevel )
        {
            this.applyPrize( m ) ;
            if(this.level >= 10)
                combatResult = CombatResult.WinAndWinGame ;
            else
                combatResult = CombatResult.Win ;            
        }
        else
        {
            Dice dice = Dice.getInstance() ;
            int escape = dice.nextNumber() ;           
            
            if(escape<5)
            {
                boolean amIDead = m.kills();
                
                if( amIDead )
                {
                    this.die() ;
                    combatResult = CombatResult.LoseAndDie ;
                }
                else
                {
                     BadConsequence bad = m.getBadConsequence() ;
                     combatResult = CombatResult.Lose ;
                     this.applyBadConsequence(bad) ;
                }
            }
            else
                combatResult = CombatResult.LoseAndEscape;           
        }
        this.discardNecklaceIfVisible();
        return combatResult; 
    }
    
    public void makeTreasureVisible( Treasure t )
    {
        boolean canl = this.canMakeTreasureVisible(t);
        if (canl)
        {
          this.visibleTreasures.add(t);           
          this.hiddenTreasures.remove(t);  
        }
    }
    
    public void discardVisibleTreasure( Treasure t )
    {
        this.visibleTreasures.remove(t);
        if ( ( pendingBadConsequence != null ) && ( !pendingBadConsequence.isEmpty() ) )
           this.pendingBadConsequence.substractVisibleTreasure(t) ;
       
        this.dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure( Treasure t )
    {
        this.hiddenTreasures.remove( t );
        if ( ( pendingBadConsequence != null ) && ( !pendingBadConsequence.isEmpty() ) )
           this.pendingBadConsequence.substractHiddenTreasure( t ) ;
       
        this.dieIfNoTreasures();
    }
    
    public boolean buyLevels( ArrayList<Treasure> visible, ArrayList<Treasure> hidden )
    {        
        float levelsMayBought = this.computeGoldCoinsValue( visible ) ;
        levelsMayBought += this.computeGoldCoinsValue( hidden ) ;
        int levels = (int) (levelsMayBought / 1000) ;
        boolean canI = this.canIBuyLevels( levels ) ;
        
        if( canI )
            this.incrementLevels( levels );
        
        this.visibleTreasures.removeAll( visible ) ;
        this.hiddenTreasures.removeAll( hidden ) ;        
        CardDealer dealer = CardDealer.getInstance() ;        
        
        for (Treasure treasure : visible)
            dealer.giveTreasureBack(treasure);
        
        for (Treasure treasure : hidden)
            dealer.giveTreasureBack(treasure);
               
        return canI ;       
    }
    
    // Devuelve true cuando el jugador no tiene ningún mal rollo que cumplir  y no tiene más de 4 tesoros ocultos y false en caso contrario.
    public boolean validState()
    {
        boolean valid;
        if( this.pendingBadConsequence == null ){
            if(this.hiddenTreasures.size() <= 4)
                valid = true;
            else
                valid = false;
        }
        else {
            if (this.pendingBadConsequence.isEmpty() && this.hiddenTreasures.size() <= 4)
                valid = true;
            else
                valid = false;           
       }
       return valid;
    }
    
/*
    Cuando un jugador está en su primer turno o se ha quedado sin tesoros ocultos o visibles,
    hay que proporcionarle nuevos tesoros para que pueda seguir jugando. El número de
    tesoros que se les proporciona viene dado por el valor que saque al tirar el dado:
        Si (dado == 1) roba un tesoro.
        Si (1 < dado< 6) roba dos tesoros.
        Si (dado == 6) roba tres tesoros.                      */
    public void initTreasures()
    {
        CardDealer dealer = CardDealer.getInstance() ;
        Dice dice = Dice.getInstance() ;
        this.bringToLife() ;
        Treasure treasure = dealer.nextTreasure() ;
        this.hiddenTreasures.add( treasure ) ;
        int number = dice.nextNumber() ;
       
        if ( number > 1 )
        {
           Treasure t = dealer.nextTreasure() ;
           this.hiddenTreasures.add( t ) ;
        }
        if ( number == 6 )
        {
           Treasure t = dealer.nextTreasure() ;
           this.hiddenTreasures.add(t) ;
        }
    }
    
    // Devuelve true cuando el jugador tiene algún tesoro visible y false en caso contrario.
    public boolean hasVisibleTreasures()
    {
        if( this.visibleTreasures.isEmpty() )
            return false ;
        else
            return true ;
    }
    
    public int getLevels()
    {
        return this.level ;
    }
    public String getName()
    {
        return this.name ;
    }
    
    @Override
    public String toString(){
        return this.name 
                + " \n\tCombatLevel = " + Integer.toString( this.getCombatLevel() ) 
                + " \n\tLevel: " + Integer.toString( this.level ) 
                + " \n\tVisibleTreasures: " + Integer.toString( this.visibleTreasures.size() )
                + " \n\tHiddenTreasures: " + Integer.toString( this.hiddenTreasures.size() ) ;
    }
}
