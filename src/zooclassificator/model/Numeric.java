/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zooclassificator.model;

/**
 *
 * @author fauzanrifqy
 */
public class Numeric extends Attribute {
    private Float value;
    
    public Numeric(){}
    public Numeric(float inp){
        value = inp;
    }
    
    @Override
    String getValue() {
        return String.valueOf(value);
    }

    @Override
    void setValue(String input) {
        value = Float.parseFloat(input);
    }
    
}
