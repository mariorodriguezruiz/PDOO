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
    
    BadConsequence(String text, int levels, int nVisible, int nHidden)
    {
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    
    BadConsequence(String txt, boolean death)
    {
        this.text = txt;
        this.death = death;
    }
    
    BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden)
    {
        this.text = text;
        this.levels = levels;
        this.specificHiddenTreasures = tHidden;
        this.specificVisibleTreasures = tVisible;
    }
    
    int getLevels()
    {
        return levels;
    }
    
    String getText()
    {
        return text;
    }
    
    int getnVisibleTreasures()
    {
        return nVisibleTreasures;
    }
    
    int getnHiddenTreasures()
    {
        return nHiddenTreasures;
    }
    
    boolean getDeath()
    {
        return death;
    }
    
    //Devuelve los tesoros visibles especificos de treasurekind
    public ArrayList<TreasureKind> getNvisible(){
        return specificVisibleTreasures;
    }

    //Devuelve los tesoros ocultos especificos de treasurekind
    public ArrayList<TreasureKind> getNhidden(){
        return specificHiddenTreasures;
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
}
