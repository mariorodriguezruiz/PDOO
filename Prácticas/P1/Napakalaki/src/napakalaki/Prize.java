/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package napakalaki;

/**
 *
 * @author Mario
 */
public class Prize {
    private int treasures;
    private int level;
       
    Prize(int treasures, int level)
    {
        this.treasures=treasures;
        this.level=level;
    }
    
    int getTreasures()
    {
        return treasures;
    }
    
    int getLevel()
    {
        return level;
    }
       
    @Override
    public String toString(){
        return " \n\t\tTreasures = " + Integer.toString(treasures) 
                + " \n\t\tLevels = " + Integer.toString(level);
    }
}
