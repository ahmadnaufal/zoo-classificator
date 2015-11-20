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
        //out.println(sortedData);
        int sizeData = n;
        int nAttr = dataset.getAttrLib().size();
        int nLastAttr = dataset.getAttrLib().get(nAttr-1).getAttributes().size();
        int[] i = new int[nLastAttr];
        for(int j=0; j<nLastAttr; j++){
            i[j] = 0;
        }
        /* Itung nilai attribut terakhir untuk hasil data yang telah di sort */
        for(int j=0; j<sizeData; j++){
            for(int k=0; k<nLastAttr; k++){
                
                if(dataset.getAttrLib().get(nAttr-1).getAttributes().get(k).equals(sortedData.peek().getAttributes().get(nAttr-1))){
                    i[k]++;
                }
            }   
            sortedData.poll();
        }
        
        /* Cari yang paling banyak */
        int indMax= 0;
        for(int j=1; j<nLastAttr; j++){
            if(i[j]>i[indMax]){
                indMax = j;
            }
        }
        freeData();
        return dataset.getAttrLib().get(nAttr-1).getAttributes().get(indMax);
    }
    
    public void freeData(){
        sortedData.clear();
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
    private int theValue(Data b, Data a){
        int value = 0;
        int size = b.getAttributes().size()-1;
        for(int j=0; j<size; j++){
            if(a.getAttributes().get(j).equals(b.getAttributes().get(j))){
                //do nothing
            }else{
                value++;
            }
        }
        return value;
    }
    public void FullTraining(Pair datasett){
        double rightValue = 0;
        for(int i = 0; i < datasett.getDataSet().size(); i++){
            Pair dataset = datasett;
            Data data = dataset.getDataSet().get(i);
            int size = data.getAttributes().size();
            if(Classificate(dataset, data).equals(data.getAttributes().get(size-1))){
                rightValue = rightValue + 1;
            }
        }
        out.println(rightValue/datasett.getDataSet().size());
    }
    public void tenFold(Pair dataset){
        double rightValue = 0;
        int dataSize = dataset.getDataSet().size();
        int[] arrTemp = new int[10];
        int retDiv = dataSize/10;
        int retMod = dataSize%10;
        for(int j=0; j<10; j++){
            int plus=0;
            if(retMod > 0){
                plus++;
                retMod--;
            }
            arrTemp[j] = retDiv + plus;
        }
        int checker=0;
        int stDel = 0;
        for(int i = 0; i<dataset.getDataSet().size(); i++){
            Pair temp = new Pair(dataset);
            Data data = temp.getDataSet().get(i);
            int fnDel = arrTemp[checker]-1;
            
            if(i > fnDel&&checker<9){
                stDel += arrTemp[checker];
                checker++;
                fnDel += arrTemp[checker];
            }
            for(int t=stDel; t<=fnDel; t++){
                temp.getDataSet().remove(t);
            }
            
            int size = data.getAttributes().size();
            if(Classificate(temp, data).equals(data.getAttributes().get(size-1))){
                rightValue = rightValue + 1;
            }
        }
        out.println(rightValue/dataset.getDataSet().size());
    }
    
}
