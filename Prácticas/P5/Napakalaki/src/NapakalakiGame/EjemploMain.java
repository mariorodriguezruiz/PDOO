
package NapakalakiGame;

import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;

/**
 *
 * @author Mario 
 */

public class EjemploMain {

    public static void main(String[] args) {
              
        // Variable de la clase Napakalaki que referencia a su única instancia.
        Napakalaki napakalakiModel = Napakalaki.getInstance() ;

        // Variable de tipo NapakalakiView que referencia al objeto de la clase NapakalakiView que se construya.       
        NapakalakiView napakalakiView = new NapakalakiView() ;

        // Crea la única instancia del dado gráfico, asociado a la ventana principal del juego.
        Dice.createInstance(napakalakiView);
                
        ArrayList< String > names = new ArrayList() ;
        
        // Referencia a un objeto que se cree de dicha clase
        PlayerNamesCapture namesCapture = new PlayerNamesCapture( napakalakiView, true ) ;
        
        // Lee los nombres de los jugadores.
        names = namesCapture.getNames();
        
        //Iniciar el juego
        napakalakiModel.initGame( names ) ;
        
        // Se enlaza el modelo a la vista.
        napakalakiView.setNapakalaki(napakalakiModel); 
        
        // Se muestra la ventana principal de la aplicación.
        napakalakiView.showView();                          
    }
}
