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
    
    @Override    
    public String toString(){
        String cadena = "\n\t\tText = " + text 
                + " \n\t\tLevel = " + Integer.toString(levels) 
                + " \n\t\tNVisibleTreasures = " + Integer.toString(nVisibleTreasures) 
                + " \n\t\tNHiddenTreasures = " + Integer.toString(nHiddenTreasures)
                + " \n\t\tDeath = " + Boolean.toString(death);
        
        for(TreasureKind t: specificHiddenTreasures)
        {
            cadena = cadena + " \n\t\tSpecificHiddenTreasures = " + t.toString();
        }
        
        for(TreasureKind t: specificVisibleTreasures)
        {
            cadena = cadena + " \n\t\tSpecificVisibleTreasures = " + t.toString();
        }
        return cadena;
    }
    
    public void substractVisibleTreasure( Treasure t )
    {
        
    }
    
    public void substractHiddenTreasure( Treasure t )
    {
        
    }
    
    /* Devuelve true cuando el mal rollo que tiene que cumplir el jugador está vacío, eso
       significa que el conjunto de atributos del mal rollo indican que no hay mal rollo que
       cumplir, plantéate qué valores deberán tener.
    */
    public boolean isEmpty()
    {
        if( levels == 0 && nHiddenTreasures == 0 && nVisibleTreasures == 0
                && specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty()
                && death == false )
            return true;
        else
            return false;
    }
    
    public BadConsequence adjustToFitTreasureLists( ArrayList<Treasure> v, ArrayList<Treasure> h )
    {
        return null ;
    }
    
    // Devuelve true si es un mal rollo es muerte, false en caso contrario.
    public boolean myBadConsequencesIsDeath()
    {
        return getDeath() ;
    }
            
}
