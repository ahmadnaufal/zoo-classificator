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
public class Nominal extends Attribute{
    private String value;
    
    public Nominal(){}
    public Nominal(String inp){
        value = inp;
    }
    @Override
    String getValue() {
        return value;
    }

    @Override
    void setValue(String input) {
        value = input;
    }
    
}
