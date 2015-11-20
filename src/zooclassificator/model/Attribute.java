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
public abstract class Attribute {
    private String name;
    
    public String getName(){
        return name;
    }
    public void setName(String input){
        name = input;
    }
    abstract String getValue();
    abstract void setValue(String input);
}
