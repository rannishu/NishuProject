/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Card {
   private String type; //number cards, special cards- reverse, skip, draw 2 etc
   private int value;//0-50
   private String color;

   public static final String [] TYPES = {"Number", "Reverse", "Skip", "Wild", "Draw2", "WildDraw4"};
   public static final String [] COLORS={"Red", "Green", "Blue", "Yellow"};
   /**
     * @return the suit
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }
    /**
     * @return the value
     */
    public String getColor() {
        return color;
    }

    /**
     * @param value the value to set
     */
    public void setColor(String color) {
        this.color = color;
    }
   

}
