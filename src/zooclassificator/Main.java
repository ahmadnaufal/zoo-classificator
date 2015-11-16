/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zooclassificator;


/**
 * Main app class for zoo classificator
 * @author Ahmad Naufal Farhan
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ZooClassificator zc = new ZooClassificator("D:/zoo.data.txt");
        
        System.out.println(zc.getData());
        System.out.println(zc.getNumAttributes());
        System.out.println(zc.getNumRows());
    }
}
