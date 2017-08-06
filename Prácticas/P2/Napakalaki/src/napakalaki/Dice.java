/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.Random ;
/**
 *
 * @author Mario
 */
public class Dice {
    
     private Random gen = new Random() ;
    
    //El constructor privado asegura que no se puede instanciar desde otras clases.
    private Dice() {
    }
    
    public static Dice getInstance() {
        return DiceHolder.INSTANCE;
    }
    //Se dice que una clase es un singleton cuando solo puede tener una instancia.
    private static class DiceHolder {
        private static final Dice INSTANCE = new Dice();
    }
    
    public int nextNumber()
    {
        return ( gen.nextInt( 6 ) + 1 ) ;
    }
    
}
