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
        ArrayList<Monster> monstruos = new ArrayList();
        Prize p;        
        
        // ----------- MONSTRUOS ----------- \\
        
        //Ángeles de la noche ibicenca
        BadConsequence badConsequences = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0,
            new ArrayList(Arrays.asList(TreasureKind.oneHand)),
            new ArrayList(Arrays.asList(TreasureKind.oneHand)));
        Prize prizes = new Prize(4,1);
        monstruos.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequences, prizes));
        
        //3 Byakhees de bonanza
        badConsequences = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0, 
            new ArrayList(Arrays.asList(TreasureKind.armor)),
            new ArrayList(Arrays.asList(TreasureKind.armor)));
        prizes = new Prize(2, 1);       
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequences, prizes));
        
        //Chibithulhu
        badConsequences = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, 
            new ArrayList(Arrays.asList(TreasureKind.helmet)),
            new ArrayList(Arrays.asList()));        
        prizes = new Prize(1, 1);        
        monstruos.add(new Monster("Chibithulhu", 2, badConsequences, prizes));
        
        //El sopor de Dunwich
        badConsequences = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0, 
            new ArrayList(Arrays.asList(TreasureKind.shoe)),
            new ArrayList(Arrays.asList()));        
        prizes = new Prize(1, 1);        
        monstruos.add(new Monster("El sopor de Dunwich", 2, badConsequences, prizes));
        
        //El gorrón en el umbral
        badConsequences = new BadConsequence("Pierdes todos tus tesoros visibles", 0, 999, 0);       
        prizes = new Prize(3, 1);        
        monstruos.add(new Monster("El gorrón en el umbral", 10, badConsequences, prizes));
        
        //H.P. Munchcraft
        badConsequences = new BadConsequence("Pierdes la armadura visible", 0, 
            new ArrayList(Arrays.asList(TreasureKind.armor)),
            new ArrayList(Arrays.asList()));        
        prizes = new Prize(2, 1);        
        monstruos.add(new Monster("H.P. Munchcraft", 6, badConsequences, prizes));
        
        //Bichgooth
        badConsequences = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, 
            new ArrayList(Arrays.asList(TreasureKind.armor)),
            new ArrayList(Arrays.asList()));        
        prizes = new Prize(1, 1);        
        monstruos.add(new Monster("Bichgooth", 2, badConsequences, prizes));
        
        //El rey de rosa
        badConsequences = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prizes = new Prize(4, 2);
        monstruos.add(new Monster("El rey de rosa", 13, badConsequences, prizes));
        
        //La que redacta en las tinieblas
        badConsequences = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);        
        prizes = new Prize(1, 1);        
        monstruos.add(new Monster("La que redacta en las tinieblas", 2, badConsequences, prizes));
        
        //Los hondos
        badConsequences = new BadConsequence("Estos monstruos resultan bastante superficiales"
                + " y te aburren mortalmente. Estás muerto", true);        
        prizes = new Prize(2, 1);        
        monstruos.add(new Monster("Los hondos", 8, badConsequences, prizes));
        
        //Semillas Cthulhu
        badConsequences = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2);        
        prizes = new Prize(2, 1);        
        monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequences, prizes));
        
        //Dameargo
        badConsequences = new BadConsequence("Te intentas escaquear. Pierdes una mano visible.", 0, 
            new ArrayList(Arrays.asList(TreasureKind.oneHand)),
            new ArrayList(Arrays.asList()));      
        prizes = new Prize(2, 1);        
        monstruos.add(new Monster("Dameargo", 1, badConsequences, prizes));
        
        //Pollipólipo volante
        badConsequences = new BadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);        
        prizes = new Prize(1, 1);        
        monstruos.add(new Monster("Pollipólipo volante", 3, badConsequences, prizes));
        
        //Yskhtihyssg-Goth
        badConsequences = new BadConsequence("No le hace gracia que pronuncien mal su nombre. "
                + "Estás muerto", true);        
        prizes = new Prize(3, 1);        
        monstruos.add(new Monster("Yskhtihyssg-Goth", 12, badConsequences, prizes));
        
        //Familia feliz
        badConsequences = new BadConsequence("La familia te atrapa. Estás muerto.", true);        
        prizes = new Prize(4, 1);        
        monstruos.add(new Monster("Familia feliz", 1, badConsequences, prizes));
                
        //Roboggoth
        badConsequences = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles"
                + " y un tesoro 2 manos visible", 2, 
            new ArrayList(Arrays.asList(TreasureKind.bothHand)),
            new ArrayList(Arrays.asList()));       
        prizes = new Prize(2, 1);        
        monstruos.add(new Monster("Roboggoth", 8, badConsequences, prizes));
        
        //El espía
        badConsequences = new BadConsequence("Te asusta en la noche. Pierdes un casco visible.", 0, 
            new ArrayList(Arrays.asList(TreasureKind.helmet)),
            new ArrayList(Arrays.asList()));        
        prizes = new Prize(1, 1);        
        monstruos.add(new Monster("El espía", 5, badConsequences, prizes));
        
        //El Lenguas
        badConsequences = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);        
        prizes = new Prize(1, 1);        
        monstruos.add(new Monster("El Lenguas", 20, badConsequences, prizes));
        
        //Bicéfalo
        badConsequences = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros "
                + "visibles de las manos.", 3, 
            new ArrayList(Arrays.asList(TreasureKind.bothHand)),
            new ArrayList(Arrays.asList()));        
        prizes = new Prize(1, 1);        
        monstruos.add(new Monster("Bicéfalo", 20, badConsequences, prizes));
        
        
        
        // ----------- FIN DE MONSTRUOS ----------- \\
        
        
        /*
        //Mostrar todos los monstruos.
        for(int i=0; i<monstruos.size(); i++)
        {
            System.out.println(monstruos.get(i));
        }
        */
        
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
                    && ( monstruos.get(i).bc.getNhidden().isEmpty() ) && ( monstruos.get(i).bc.getNvisible().isEmpty() ) 
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
            if( (monstruos.get(i).bc.getNhidden().isEmpty() == false ) || ( monstruos.get(i).bc.getNvisible().isEmpty() == false ) )
            {
                System.out.println( monstruos.get(i) );
                cont++;
            }
        }
        System.out.println( "Número de monstruos encontrados: " + cont);
        System.out.println( "------- FIN Monstruos con mal rollo que implica la pérdida de un determinado tipo de tesoros ya sea visibles y/o ocultos cualquier tipo de tesoro. -------" );
        
        // ----------- FIN DE CONSULTAS ----------- \\
    }
    
}
