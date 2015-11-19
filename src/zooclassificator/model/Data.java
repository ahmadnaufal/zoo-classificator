/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zooclassificator.model;

import java.util.ArrayList;

public class Data {
    ArrayList<String> Attrs = new ArrayList<>();

    public Data(ArrayList<String> Atrrs) {
        this.Attrs = Atrrs;
    }
    
    public ArrayList<String> getAttrs() {
        return Attrs;
    } 

    @Override
    public String toString() {
        return "Data{" + "Attrs=" + Attrs + '}';
    }
    
}