/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zooclassificator.model;

import java.util.ArrayList;

public class Data {
    private String name;
    private ArrayList<String> attributes;
    
    public Data(ArrayList<String> attributes) {
        this.attributes = attributes;
    }
    public Data(String name, ArrayList<String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Data{" + "name=" + getName() + ", elmts=" + getAttributes() + '}';
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the attributes
     */
    public ArrayList<String> getAttributes() {
        return attributes;
    }

    /**
     * @param attributes the attributes to set
     */
    public void setAttributes(ArrayList<String> attributes) {
        this.attributes = attributes;
    }
    
}