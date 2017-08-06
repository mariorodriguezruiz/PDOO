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
public class Napakalaki {
    
    private ArrayList<Monster> currentMonster = new ArrayList();
    private ArrayList<CardDealer> dealer = new ArrayList();
    private ArrayList<Player> players = new ArrayList();
    private ArrayList<Player> currentPlayer = new ArrayList();

    //El constructor privado asegura que no se puede instanciar desde otras clases.
    private Napakalaki() {
    }
    
    public static Napakalaki getInstance() {
        return NapakalakiHolder.INSTANCE;
    }
    
    //Se dice que una clase es un singleton cuando solo puede tener una instancia.
    private static class NapakalakiHolder {
        private static final Napakalaki INSTANCE = new Napakalaki();
    }
    
    private void initPlayers (ArrayList<String> names)
    {
        
    }
    
    private Player nextPlayer()
    {
        return null ;
    }
    
    private boolean nextTurnAllowed()
    {
        return false;
    }
    
    
    
    public CombatResult developCombat()
    {
        return null;
    }
    
    public void discardVisibleTreasures( ArrayList<Treasure> treasures )
    {
        
    }
    
    public void discardHiddenTreasures( ArrayList<Treasure> treasures )
    {
        
    }
    
    public void makeTreasuresVisible( ArrayList<Treasure> treasures )
    {
        
    }
    
    public boolean buyLevels( ArrayList<Treasure> visible, ArrayList<Treasure> hidden )
    {
        return false;
    }
    
    public void initGame( ArrayList<String> players )
    {
        
    }
    
    public ArrayList<Player> getCurrentPlayer()
    {
        return currentPlayer ;
    }
    
    public ArrayList<Monster> getCurrentMonster()
    {
        return currentMonster ;
    }
    
    public boolean nextTurn()
    {
        return false ;
    }
    
    public boolean endOfGame( CombatResult result )
    {
        return false ;
    }
}
