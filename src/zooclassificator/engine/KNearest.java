/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zooclassificator.engine;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import zooclassificator.model.Data;
import zooclassificator.model.Pair;

/**
 *
 * @author fauzanrifqy
 */
public class KNearest {
    private PriorityQueue<Data> sortedData;
    private Comparator<Data> comparator;
    private Data dummy;
    private int n;
    
    public KNearest(int n){
        this.n = n;
        comparator = new KNNComparator();
        sortedData = new PriorityQueue(n, comparator);
    }
    public String Classificate(Pair dataset, Data data){
        dummy = data;
        for(Data eachdata : dataset.getDataSet()){
            sortedData.add(eachdata);
        }
        int sizeData = dataset.getDataSet().size();
        int nAttr = dataset.getAttrLib().size();
        int nLastAttr = dataset.getAttrLib().get(nAttr-1).getAttributes().size();
        int[] i = new int[nLastAttr];
        for(int j=0; j<nLastAttr; j++){
            i[j] = 0;
        }
        /* Itung nilai attribut terakhir untuk hasil data yang telah di sort */
        for(int j=0; j<sizeData; j++){
            for(int k=0; k<nLastAttr; k++){
                out.println(nLastAttr);
                /*if(dummy.getAttributes().get(nAttr-1).equals(dataset.getAttrLib().get(nLastAttr-1).getAttributes().get(k))){
                    i[k]++;
                }*/
            }   
        }
        
        /* Cari yang paling banyak */
        int indMax= 0;
        for(int j=1; j<nLastAttr; j++){
            if(i[j]>i[indMax]){
                indMax = j;
            }
        }
        
        return dataset.getAttrLib().get(nLastAttr).getAttributes().get(indMax);
    }
    
    private class KNNComparator implements Comparator<Data>{

        @Override
        public int compare(Data a, Data b) {
            if(theValue(a,dummy)>theValue(b,dummy)){
                return 1;
            }else if(theValue(a,dummy)<theValue(b,dummy)){
                return -1;
            }
            return 0;
        }
    }
    private int theValue(Data a, Data b){
        int value = 0,i = 0;
        for(String attr : a.getAttributes()){
            if(attr == b.getAttributes().get(i)){
                //do nothing
            }else{
                value++;
            }
            i++;
        }
        return value;
    }
}
