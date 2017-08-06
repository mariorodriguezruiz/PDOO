/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Mario
 */
public class Napakalaki {
    
    private Monster currentMonster ;
    CardDealer dealer = CardDealer.getInstance();
    private ArrayList<Player> players = new ArrayList();
    private Player currentPlayer ;
    private Random gen = new Random() ;

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
    
    /*Inicializa el array de jugadores que contiene Napakalaki, creando tantos jugadores como
      elementos haya en names, que es el array de String que contiene el nombre de los
      jugadores.*/
    private void initPlayers (ArrayList<String> names)
    {
        for( String p : names)        
            players.add( new Player( p ) ) ;        
    }
    
    // Decide qué jugador es el siguiente en jugar. Se pueden dar dos posibilidades 
    // para calcular el índice que ocupa dicho jugador en la lista de jugadores:
    private Player nextPlayer()
    {
        Player next_player;
       if(this.currentPlayer==null){
           Random rnd = new Random(); // Calcular el indice del jugador.
           next_player = players.get(rnd.nextInt(players.size()));
       }else{  
            int indice = this.players.indexOf(this.currentPlayer);//indexOf: devuelve la posicon dentro del Array.
            next_player = this.players.get( ((indice + 1) % this.players.size()) );            
        }
       //Establecemos el siguiente jugador
       this.currentPlayer = next_player;
       return this.currentPlayer;
    }
    
    /*Método que comprueba si el jugador activo (currentPlayer) cumple con las reglas del
      juego para poder terminar su turno. Devuelve false si el jugador activo no puede pasar de
      turno y true en caso contrario, para ello usa el método de Player: validState()*/
    private boolean nextTurnAllowed()
    {
        boolean allowed = false;     
        if(this.currentPlayer!=null){
            //validState():  Devuelve true cuando el jugador no tiene ningún mal rollo que cumplir
            // y no tiene más de 4 tesoros ocultos y false en caso contrario.
            allowed=currentPlayer.validState();
        }else{
            allowed = true;
        }
        
        return allowed;
    }
    
    
/*  Operación responsabilidad de la única instancia de Napakalaki, la cual pasa el control al
    jugador actual (currentPlayer) para que lleve a cabo el combate con el monstruo que le
    ha tocado (currentMonster). El método correspondiente de la clase Player para llevar a
    cabo dicha responsabilidad es combat(currentMonster:Monster): CombatResult */
    public CombatResult developCombat()
    {            
       CombatResult combatResult = this.currentPlayer.combat(this.currentMonster);
       this.dealer.giveMonsterBack(this.currentMonster);
       return combatResult ;       
    }
    
/*  Operación encargada de eliminar los tesoros visibles indicados de la lista de tesoros
    visibles del jugador. Al eliminar esos tesoros, si el jugador tiene un mal rollo pendiente, se
    indica a éste dicho descarte para su posible actualización.                     */
    public void discardVisibleTreasures( ArrayList<Treasure> treasures )
    {
        for ( Treasure treasure : treasures )
        {
            this.currentPlayer.discardVisibleTreasure( treasure ) ;
            this.dealer.giveTreasureBack( treasure ) ;       
        }
    }
    
    public void discardHiddenTreasures( ArrayList<Treasure> treasures )
    {
        for ( Treasure treasure : treasures )
        {
            this.currentPlayer.discardHiddenTreasure( treasure ) ;
            this.dealer.giveTreasureBack( treasure ) ;       
        }
    }    
    
    /*
    Operación en la que el jugador pasa tesoros ocultos a visibles, siempre que pueda hacerlo
    según las reglas del juego, para ello llama al método, para ello desde Player se ejecuta el
    método: canMakeTreasureVisible(treasures:Treasure ):boolean    */
    public void makeTreasuresVisible( ArrayList<Treasure> treasures )
    {
        for (Treasure t : treasures)        
            this.currentPlayer.makeTreasureVisible( t ) ;        
    }
    
/*  Esta operación permite comprar niveles antes de combatir con el monstruo actual. Para
    ello, a partir de las listas de tesoros (pueden ser tanto ocultos como visibles) se calculan
    los niveles que puede subir el jugador en función del número de piezas de oro que sumen.
    Si al jugador le está permitido comprar la cantidad de niveles resultantes (no se puede
    comprar niveles si con ello ganas el juego), entonces se produce el mencionado
    incremento. Independientemente de si se ha podido comprar niveles o no, los tesoros
    empleados para ello pasan al mazo de descartes.                                     */
    public boolean buyLevels( ArrayList<Treasure> visible, ArrayList<Treasure> hidden )
    {
        boolean canI = this.currentPlayer.buyLevels( visible, hidden ) ;
        return canI ;
    }
    
/*  Se encarga de solicitar a CardDealer la inicialización de los mazos de cartas de
    Tesoros y de Monstruos, de inicializar los jugadores proporcionándoles un nombre y de
    iniciar el juego con la llamada a nextTurn() para pasar al siguiente turno (que en este
    caso será el primero).                      */
    public void initGame( ArrayList<String> players )
    {
        this.initPlayers(players) ;
        this.dealer.initCards() ;
        this.nextTurn() ;
    }
    
    // Devuelve el jugador actual (currentPlayer).
    public Player getCurrentPlayer()
    {
        return currentPlayer ;
    }
    
    // Devuelve el monstruo en juego (currentMonster).
    public Monster getCurrentMonster()
    {
        return currentMonster ;
    }
    
    /*
    Esta operación usa el método nextTurnIsAllowed(), para verificar si el jugador activo
    (currentPlayer) cumple con las reglas del juego para poder terminar su turno.
    En caso el caso que nextTurnIsAllowed() devuelva true, se actualiza el jugador
    activo al siguiente jugador y se le solicita a CardDealer el siguiente monstruo al que se
    enfrentará ese jugador (currentMonster).
    En caso de que el nuevo jugador activo esté muerto, por el combate en su anterior turno o
    porque es el primer turno, se inicializan sus tesoros siguiendo las reglas del juego. La
    inicialización de los tesoros se encuentra recogida en el diagrama subordinado
    initTreasures.     */
    public boolean nextTurn()
    {
        boolean stateOK = this.nextTurnAllowed();
        if (stateOK)
        {
            this.currentMonster = this.dealer.nextMonster();
            this.currentPlayer = this.nextPlayer();
            boolean dead = this.currentPlayer.isDead();
         
            if (dead)
            {
                this.currentPlayer.initTreasures();
            }
    }
     return stateOK;
    
    }
    
    // Devuelve true si result tiene el valor WinAndWinGame del enumerado CombatResult, en
    // caso contrario devuelve false.
    public boolean endOfGame( CombatResult result )
    {
        if( result == CombatResult.WinAndWinGame )
            return true ;
        else
            return false ;
    }
}
