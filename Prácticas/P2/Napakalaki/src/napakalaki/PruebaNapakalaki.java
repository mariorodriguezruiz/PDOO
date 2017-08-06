/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Mario
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
               
        /*
        //Mostrar todos los monstruos.
        for(int i=0; i<monstruos.size(); i++)
        {
            System.out.println(monstruos.get(i));
        }
        
        
        // ----------- CONSULTAS ----------- \\
        
        //Monstrar todos los monstruos que tengan combatLevel superior a 10
        System.out.println( "\n------- Monstruos con combatLevel mayor a 10. -------" );
        int cont = 0 ;
        for( int i=0 ; i < monstruos.size() ; i++)
        {
            if( monstruos.get(i).getCombatLevel() > 10 ){
                System.out.println( monstruos.get(i) );
                cont++;
            }
        }
        System.out.println( "Número de monstruos encontrados: " + cont);
        System.out.println( "------- FIN Monstruos con combatLevel mayor a 10. -------" );
        
        //Monstrar todos los monstruos que tengan un mal rollo que implique sólo pérdida de niveles.
        System.out.println( "\n------- Monstruos con mal rollo que implica sólo perdida de niveles. -------" );
        cont = 0;
        for( int i = 0 ; i < monstruos.size() ; i++ )
        {
            if( (monstruos.get(i).bc.getLevels() > 0 ) && ( monstruos.get(i).bc.getnHiddenTreasures() == 0 ) 
                    && ( monstruos.get(i).bc.getnVisibleTreasures() == 0 ) 
                    && ( monstruos.get(i).bc.getSpecificHiddenTreasures().isEmpty() ) && ( monstruos.get(i).bc.getSpecificVisibleTreasures().isEmpty() ) 
                    && ( monstruos.get(i).bc.getDeath() == false) )
            {
                System.out.println( monstruos.get(i) );
                cont++;
            }
        }
        System.out.println( "Número de monstruos encontrados: " + cont);
        System.out.println( "------- FIN Monstruos con mal rollo que implica sólo perdida de niveles. -------" );        
        
        //Monstrar todos los monstruos que tengan un buen rollo que indiquen una ganancia de niveles superior a 1.
        System.out.println( "\n------- Monstruos con buen rollo con ganancia de niveles superior a 1. -------" );
        cont = 0;
        for( int i = 0; i < monstruos.size() ; i++ )
        {
            if( monstruos.get(i).price.getLevel() > 1 )
            {
                System.out.println( monstruos.get(i) );
                cont++ ;
            }
        }
        System.out.println( "Número de monstruos encontrados: " + cont);
        System.out.println( "------- FIN Monstruos con buen rollo con ganancia de niveles superior a 1. -------" );
        
        //Monstrar todos los monstruos que tengan un mal rollo que suponga la pérdida de un determinado tipo de tesoros ya sea visibles y/o ocultos.
        System.out.println(" \n------- Monstruos con mal rollo que implica la pérdida de un determinado tipo de tesoros ya sea visibles y/o ocultos. -------" );
        cont = 0;
        for( int i = 0 ; i < monstruos.size() ; i++ )
        {
            if( (monstruos.get(i).bc.getSpecificHiddenTreasures().isEmpty() == false ) || ( monstruos.get(i).bc.getSpecificVisibleTreasures().isEmpty() == false ) )
            {
                System.out.println( monstruos.get(i) );
                cont++;
            }
        }
        System.out.println( "Número de monstruos encontrados: " + cont);
        System.out.println( "------- FIN Monstruos con mal rollo que implica la pérdida de un determinado tipo de tesoros ya sea visibles y/o ocultos cualquier tipo de tesoro. -------" );
        
        // ----------- FIN DE CONSULTAS ----------- \\
        */
    }
    
}
