/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zooclassificator.model;

import java.util.ArrayList;

public class Data {
    String name;
    ArrayList<String> attributes;
    
    public Data(ArrayList<String> attributes) {
        this.attributes = attributes;
    }
    public Data(String name, ArrayList<String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Data{" + "name=" + name + ", elmts=" + attributes + '}';
    }
    
}