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
public class BadConsequence {
    private String text; //representa lo que dice un mal rollo.
    private int levels; //representa el número de tesoros visibles que se pierden.
    private int nVisibleTreasures; //representa el número de tesoros visibles que se pierden.
    private int nHiddenTreasures; //representa el número de tesoros ocultos que se pierden.
    private boolean death; //representa un mal rollo de tipo muerte.
    
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden)
    {
        this.nVisibleTreasures = nVisible ;
        this.nHiddenTreasures = nHidden ;        
        this.text = text;
        this.levels = levels;        
    }
    
    public BadConsequence(String txt, boolean death)
    {
        this.text = txt;
        this.death = death;
    }
    
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden)
    {        
        this.specificVisibleTreasures = tVisible;
        this.text = text;
        this.levels = levels;
        this.specificHiddenTreasures = tHidden;
        
    }
    
    public int getLevels()
    {
        return levels ;
    }
    
    public String getText()
    {
        return text ;
    }
    
    public int getnVisibleTreasures()
    {
        return nVisibleTreasures ;
    }
    
    public int getnHiddenTreasures()
    {
        return nHiddenTreasures ;
    }
    
    public boolean getDeath()
    {
        return death ;
    }
    
    //Devuelve los tesoros visibles especificos de treasurekind
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures ;
    }

    //Devuelve los tesoros ocultos especificos de treasurekind
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures ;
    }  
    
    // Actualiza el mal rollo que tiene que cumplir el jugador, en función del tipo de tesoro de t y
    // del tipo de mal rollo que tenga que cumplir el jugador.
    public void substractVisibleTreasure( Treasure t )
    {
        if( !this.specificVisibleTreasures.isEmpty() ){
            for( TreasureKind tk : this.specificVisibleTreasures ){
                if(t.getType() == tk )
                    this.specificVisibleTreasures.remove( tk ) ;
            }
        }        
        else
            this.nVisibleTreasures -- ;
    }
    
    // Igual que el anterior, pero para los ocultos.
    public void substractHiddenTreasure( Treasure t )
    {        
        if( !this.specificHiddenTreasures.isEmpty() ){
            for( TreasureKind tk : this.specificHiddenTreasures ){
                if(t.getType() == tk )
                    this.specificHiddenTreasures.remove( tk ) ;
            }
        }
        else
            this.nHiddenTreasures -- ;
    }
    
    /* Devuelve true cuando el mal rollo que tiene que cumplir el jugador está vacío, eso
       significa que el conjunto de atributos del mal rollo indican que no hay mal rollo que
       cumplir, plantéate qué valores deberán tener.
    */
    public boolean isEmpty()
    {        
        if( this.levels == 0 && this.nHiddenTreasures == 0 && this.nVisibleTreasures == 0
                && this.specificHiddenTreasures.isEmpty() && this.specificVisibleTreasures.isEmpty()
                && this.death == false )
            return true;
        else
            return false;
    }
/*
    Recibe como parámetros los tesoros visibles y ocultos de los que dispone el jugador y
    devuelve un nuevo objeto mal rollo que contiene una lista de tipos tesoros visibles y
    ocultos de los que el jugador debe deshacerse. El objeto de mal rollo devuelto por
    adjustToFitTreasureList solo contendrá tipos de tesoros y en una cantidad
    adecuada a los que el jugador puede llegar a deshacerse en función de los que dispone.    */
    public BadConsequence adjustToFitTreasureLists( ArrayList<Treasure> v, ArrayList<Treasure> h )
    {
        BadConsequence bc;
        if (death)
           bc = new BadConsequence(text, death);

        else if(specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty())
        {
            int nTesorosVisibles = v.size();
            int nTesorosOcultos = h.size();
            int minVisible = (nTesorosVisibles < nVisibleTreasures) ? nTesorosVisibles : nVisibleTreasures;
            int minOcultos = (nTesorosOcultos < nHiddenTreasures) ? nTesorosOcultos : nHiddenTreasures;
            bc = new BadConsequence(text, 0, minVisible, minOcultos);
        }else
        {
            ArrayList<TreasureKind> t_visibles = new ArrayList();
            ArrayList<TreasureKind> t_ocultos = new ArrayList();
            ArrayList<TreasureKind> tipos = new ArrayList();
            
            tipos.add(TreasureKind.ARMOR);
            tipos.add(TreasureKind.BOTHHAND);
            tipos.add(TreasureKind.HELMET);
            tipos.add(TreasureKind.NECKLACE);
            tipos.add(TreasureKind.ONEHAND);
            tipos.add(TreasureKind.SHOE);
            
            for ( TreasureKind tesoro : tipos ) 
            {
                int contVisible = 0, contOculto = 0, minimo;
                //visibles
                for ( TreasureKind t : specificVisibleTreasures ) 
                    if (t == tesoro) 
                        contVisible++ ;              
                
                int cont = 0;
                for( int i = 0; i < v.size() ; i++ )
                    if( v.get( i ).getType() == tesoro )
                        cont++ ;
                
                minimo = ( cont < contVisible ) ? cont : contVisible ;
                for (int i = 0; i < minimo; i++) 
                    t_visibles.add( tesoro ) ;
                
                //ocultos
                for ( TreasureKind t : specificHiddenTreasures ) 
                    if ( t == tesoro ) 
                        contOculto++ ;
                
                cont = 0;
                for (int i = 0; i < h.size(); i++ ) 
                    if ( h.get( i ).getType() == tesoro ) 
                        cont++ ;
                
                minimo = ( cont < contOculto ) ? cont : contOculto ;
                for ( int i = 0; i < minimo; i++ ) 
                    t_ocultos.add(tesoro);
                
            } 
            bc = new BadConsequence( this.text, 0, t_visibles, t_ocultos ) ;
        }        
        return bc;
    }
    
    // Devuelve true si es un mal rollo es muerte, false en caso contrario.
    public boolean myBadConsequencesIsDeath()
    {
        return getDeath() ;
    }
    
    @Override    
    public String toString(){
        String cadena = "\n Descripción: " + text 
                + "\n Nivel: " + Integer.toString(levels) 
                + "\n Tesoros visibles: " + Integer.toString(nVisibleTreasures) 
                + "\n Tesoros ocultos: " + Integer.toString(nHiddenTreasures)
                + "\n Muerte: " + Boolean.toString(death);
        
        for(TreasureKind t: this.specificHiddenTreasures)
        {
            cadena = cadena + "\n Tesoros ocultos específicos: " + t.toString();
        }
        
        for(TreasureKind t: this.specificVisibleTreasures)
        {
            cadena = cadena + "\n Tesoros visibles específicos: " + t.toString();
        }
        return cadena;
    }
            
}
