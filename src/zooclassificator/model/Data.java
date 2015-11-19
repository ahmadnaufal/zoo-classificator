/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zooclassificator.model;

import java.util.ArrayList;

public class Data {
    ArrayList<Attribute> L ; 

    public Data() {
        L = new ArrayList<>()   ;  
    }

    public Data(ArrayList<Attribute> L) {
        this.L = L;
    }

    public void setL(ArrayList<Attribute> L) {
        this.L = L;
    }   

    public ArrayList<Attribute> getL() {
        return L;
    }
    
    public void addAttr(Attribute a) {
        L.add(a);
    }
    
    public Attribute getAttr(int i) {
        return L.get(i);
    }
    
    public void delAttr(int i) {
        //delete L with first elemt is 0
        L.remove(L.get(i));
    }
}
