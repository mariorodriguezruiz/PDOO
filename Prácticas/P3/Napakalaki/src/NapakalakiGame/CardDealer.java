/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Mario
 */
public class CardDealer {
    
    private ArrayList<Monster> usedMonsters = new ArrayList();
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    
    //El constructor privado asegura que no se puede instanciar desde otras clases.
    private CardDealer() 
    {        
    }
    
    public static CardDealer getInstance() 
    {
        return CardDealerHolder.INSTANCE;
    }
    
    //Se dice que una clase es un singleton cuando solo puede tener una instancia.
    private static class CardDealerHolder 
    {
        private static final CardDealer INSTANCE = new CardDealer();
    }
    
    // Inicializa en mazo de cartas de Tesoros.
    private void initTreasureCardDeck()
    {
        // ----------- TESOROS ----------- \\
        
        unusedTreasures.add(new Treasure("¡Si mi amo!", 0, 4, 7, TreasureKind.HELMET));        
        unusedTreasures.add(new Treasure("Botas de investigacion", 600, 3, 4, TreasureKind.SHOE));        
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 500, 3, 5, TreasureKind.HELMET));        
        unusedTreasures.add(new Treasure("A prueba de babas", 400, 2, 5, TreasureKind.ARMOR));        
        unusedTreasures.add(new Treasure("Botas de lluvia acida", 800, 1, 1, TreasureKind.BOTHHAND));        
        unusedTreasures.add(new Treasure("Casco minero", 400, 2, 4, TreasureKind.HELMET));        
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 600, 4, 8, TreasureKind.BOTHHAND));        
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 100, 1, 7, TreasureKind.ARMOR));        
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 400, 3, 6, TreasureKind.ONEHAND));        
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 300, 2, 3, TreasureKind.ONEHAND));        
        unusedTreasures.add(new Treasure("Fez alopodo", 700, 3, 5, TreasureKind.HELMET));        
        unusedTreasures.add(new Treasure("Hacha prehistorica", 500, 2, 5, TreasureKind.ONEHAND));        
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 900, 4, 8, TreasureKind.ARMOR));        
        unusedTreasures.add(new Treasure("Gaita", 500, 4, 5, TreasureKind.BOTHHAND));        
        unusedTreasures.add(new Treasure("Insecticida", 300, 2, 3, TreasureKind.ONEHAND));        
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 700, 4, 6, TreasureKind.BOTHHAND));        
        unusedTreasures.add(new Treasure("Garabato mistico", 300, 2, 2, TreasureKind.ONEHAND));        
        unusedTreasures.add(new Treasure("La fuerza de Mr. T", 1000, 0, 0, TreasureKind.NECKLACE));        
        unusedTreasures.add(new Treasure("La rebeca metalica", 400, 2, 3, TreasureKind.ARMOR));        
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 200, 3, 4, TreasureKind.ONEHAND));        
        unusedTreasures.add(new Treasure("Necroplayboycon", 300, 3, 5, TreasureKind.ONEHAND));        
        unusedTreasures.add(new Treasure("Lanzallamas", 800, 4, 8, TreasureKind.BOTHHAND));        
        unusedTreasures.add(new Treasure("Necrocomicon", 100, 1, 1, TreasureKind.ONEHAND));        
        unusedTreasures.add(new Treasure("Necronomicon", 800, 5, 7, TreasureKind.BOTHHAND));        
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 400, 3, 6, TreasureKind.BOTHHAND));        
        unusedTreasures.add(new Treasure("Necrognomicon", 200, 2, 4, TreasureKind.ONEHAND));        
        unusedTreasures.add(new Treasure("Necrotelecom", 300, 2, 3, TreasureKind.HELMET));        
        unusedTreasures.add(new Treasure("Porra preternatural", 200, 2, 3, TreasureKind.ONEHAND));        
        unusedTreasures.add(new Treasure("Tentaculo de pega", 200, 0, 1, TreasureKind.HELMET));        
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 500, 0, 1, TreasureKind.SHOE));        
        unusedTreasures.add(new Treasure("Shogulador", 600, 1, 1, TreasureKind.BOTHHAND));        
        unusedTreasures.add(new Treasure("Varita de atizamiento", 400, 3, 4, TreasureKind.ONEHAND));
        
        // ----------- FIN DE TESOROS ----------- \\
    }
    
    // Inicializa el mazo de cartas de monstruos.
    private void initMonsterCardDeck()
    {       
        // ----------- MONSTRUOS ----------- \\
        
        //Ángeles de la noche ibicenca
        BadConsequence badConsequences = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0,
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        Prize prizes = new Prize(4,1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequences, prizes));
        
        //3 Byakhees de bonanza
        badConsequences = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0, 
            new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prizes = new Prize(2, 1);       
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequences, prizes));
        
        //Chibithulhu
        badConsequences = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, 
            new ArrayList(Arrays.asList(TreasureKind.HELMET)),
            new ArrayList(Arrays.asList()));        
        prizes = new Prize(1, 1);        
        unusedMonsters.add(new Monster("Chibithulhu", 2, badConsequences, prizes));
        
        //El sopor de Dunwich
        badConsequences = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0, 
            new ArrayList(Arrays.asList(TreasureKind.SHOE)),
            new ArrayList(Arrays.asList()));        
        prizes = new Prize(1, 1);        
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequences, prizes));
        
        //El gorrón en el umbral
        badConsequences = new BadConsequence("Pierdes todos tus tesoros visibles", 0, 999, 0);       
        prizes = new Prize(3, 1);        
        unusedMonsters.add(new Monster("El gorrón en el umbral", 10, badConsequences, prizes));
        
        //H.P. Munchcraft
        badConsequences = new BadConsequence("Pierdes la armadura visible", 0, 
            new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList(Arrays.asList()));        
        prizes = new Prize(2, 1);        
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequences, prizes));
        
        //Bichgooth
        badConsequences = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, 
            new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList(Arrays.asList()));        
        prizes = new Prize(1, 1);        
        unusedMonsters.add(new Monster("Bichgooth", 2, badConsequences, prizes));
        
        //El rey de rosa
        badConsequences = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prizes = new Prize(4, 2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequences, prizes));
        
        //La que redacta en las tinieblas
        badConsequences = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);        
        prizes = new Prize(1, 1);        
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequences, prizes));
        
        //Los hondos
        badConsequences = new BadConsequence("Estos monstruos resultan bastante superficiales"
                + " y te aburren mortalmente. Estás muerto", true);        
        prizes = new Prize(2, 1);        
        unusedMonsters.add(new Monster("Los hondos", 8, badConsequences, prizes));
        
        //Semillas Cthulhu
        badConsequences = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2);        
        prizes = new Prize(2, 1);        
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequences, prizes));
        
        //Dameargo
        badConsequences = new BadConsequence("Te intentas escaquear. Pierdes una mano visible.", 0, 
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
            new ArrayList(Arrays.asList()));      
        prizes = new Prize(2, 1);        
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequences, prizes));
        
        //Pollipólipo volante
        badConsequences = new BadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);        
        prizes = new Prize(1, 1);        
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequences, prizes));
        
        //Yskhtihyssg-Goth
        badConsequences = new BadConsequence("No le hace gracia que pronuncien mal su nombre. "
                + "Estás muerto", true);        
        prizes = new Prize(3, 1);        
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequences, prizes));
        
        //Familia feliz
        badConsequences = new BadConsequence("La familia te atrapa. Estás muerto.", true);        
        prizes = new Prize(4, 1);        
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequences, prizes));
                
        //Roboggoth
        badConsequences = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles"
                + " y un tesoro 2 manos visible", 2, 
            new ArrayList(Arrays.asList(TreasureKind.BOTHHAND)),
            new ArrayList(Arrays.asList()));       
        prizes = new Prize(2, 1);        
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequences, prizes));
        
        //El espía
        badConsequences = new BadConsequence("Te asusta en la noche. Pierdes un casco visible.", 0, 
            new ArrayList(Arrays.asList(TreasureKind.HELMET)),
            new ArrayList(Arrays.asList()));        
        prizes = new Prize(1, 1);        
        unusedMonsters.add(new Monster("El espía", 5, badConsequences, prizes));
        
        //El Lenguas
        badConsequences = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);        
        prizes = new Prize(1, 1);        
        unusedMonsters.add(new Monster("El Lenguas", 20, badConsequences, prizes));
        
        //Bicéfalo
        badConsequences = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros "
                + "visibles de las manos.", 3, 
            new ArrayList(Arrays.asList(TreasureKind.BOTHHAND)),
            new ArrayList(Arrays.asList()));        
        prizes = new Prize(1, 1);        
        unusedMonsters.add(new Monster("Bicéfalo", 20, badConsequences, prizes));       
        
        // ----------- FIN DE MONSTRUOS ----------- \\
    }
    
    // Baraja el mazo de cartas de tesoros unusedTreasures.
    private void shuffleTreasures()
    {
        Collections.shuffle(this.unusedTreasures) ;
    }
    
    private void shuffleMonsters()
    {
        Collections.shuffle(this.unusedMonsters) ;
    }
    
    /*Devuelve el siguiente tesoro que hay en el mazo de tesoros (unusedTreasures) y lo
      elimina de él. Si el mazo está vacío, pasa el mazo de descartes (usedTreasures) al mazo
      de tesoros y lo baraja, dejando el mazo de descartes vacío.*/
    public Treasure nextTreasure()
    {        
        if (this.unusedTreasures.isEmpty()) 
        {
            this.unusedTreasures.addAll( this.usedTreasures ) ;          
            this.shuffleTreasures() ;            
            this.usedTreasures.clear() ;        
        }
        
        Treasure t = this.unusedTreasures.get( 0 ) ;
        this.usedTreasures.add( t ) ;
        this.unusedTreasures.remove( t ) ;
        return t;
    }
    
    // Igual que la anterior pero con el mazo de monstruos.
    public Monster nextMonster()
    {
        if (this.unusedMonsters.isEmpty()) 
        {
            this.unusedMonsters.addAll( this.usedMonsters ) ;           
            this.shuffleMonsters() ;            
            this.usedMonsters.clear() ;        
        }
        
        Monster m = this.unusedMonsters.get(0) ;
        this.usedMonsters.add( m ) ;
        this.unusedMonsters.remove( m ) ;
        return m;
    }
    
    // Introduce en el mazo de descartes de tesoros (usedTreasures) el tesoro t.
    public void giveTreasureBack( Treasure t )
    {
        usedTreasures.add( t ) ;
    }
    
    // Introduce en el mazo de descartes de monstruos (usedMonsters) al monstruo m.
    public void giveMonsterBack( Monster m )
    {
        usedMonsters.add( m ) ;
    }
    
    public void initCards()
    {
        this.initTreasureCardDeck() ;
        this.initMonsterCardDeck() ;
    }
}
