package zooclassificator.engine;

import java.util.ArrayList;
import zooclassificator.model.*;

public class NaiveBayes {
	int nAttr, nAll;
	private ArrayList< ArrayList< Integer > > countTable[];
	private ArrayList< Integer >[] sumTable;
	private ArrayList <String>[] domainAttr;
	public NaiveBayes() {
		reset();
	}
	public void reset() {
		nAll = 0;
		nAttr = 0;
		countTable = null;
		sumTable = null;
		domainAttr = null;
	}
	
	public void init(Pair dataset) {
		ArrayList< Data > attribut  = dataset.getAttrLib();
		ArrayList< String > classAttr = attribut.get(attribut.size()-1).getAttributes();
		// Initailize domain Attribut
		nAttr = attribut.size();
		nAll = 0;
		domainAttr = new ArrayList[nAttr];
		for(int i = 0; i<nAttr; i++) {
			ArrayList<String> temp = attribut.get(i).getAttributes();
			domainAttr[i] = new ArrayList<>();
			for(String s : temp) {
				domainAttr[i].add(s);
			}
		}
		
		// Inisialisasi tabel count dan tabel sum
		countTable = new ArrayList[nAttr];
		sumTable = new ArrayList[nAttr];
		for(int i = 0; i<nAttr; i++) {
			countTable[i] = new ArrayList<>();
			sumTable[i] = new ArrayList<>();
			for(int j = 0; j<domainAttr[i].size(); j++) {
				countTable[i].add(new ArrayList());
				for(int k = 0; k < classAttr.size(); k++)
					countTable[i].get(j).add(0);
			}
			for(int j = 0; j<classAttr.size(); j++)
				sumTable[i].add(0);
		}
	}
	
	public void count(Pair dataset, int change) {
		ArrayList< Data > dataTable = dataset.getDataSet();
		for(int i = 0; i<dataTable.size(); i++) {
			ArrayList< String > dataValue = dataTable.get(i).getAttributes();
			int classId = domainAttr[nAttr-1].indexOf(dataValue.get(dataValue.size()-1));
			if(classId < -1)
				continue;
			for(int j = 0; j<nAttr; j++) {
				int id = domainAttr[j].indexOf(dataValue.get(j));
				if(id < -1) {
					id = domainAttr[j].size();
					domainAttr[j].add(dataValue.get(j));
					countTable[j].add(new ArrayList());
					for(int k = 0; k< domainAttr[nAttr-1].size(); k++)
						countTable[j].get(id).add(0);
				}
				int bef = countTable[j].get(id).get(classId);
				countTable[j].get(id).set(classId, bef + change);
				bef = sumTable[j].get(classId);
				sumTable[j].set(classId, bef + change);
			}
			nAll += change;
		}
	}
	public String test(Data data) {
		ArrayList< String > values = data.getAttributes();
		double high = 0;
		int id = 0;
		for(int i = 0; i<domainAttr[nAttr-1].size(); i++) {
			double fnow = (double)sumTable[nAttr-1].get(i)/nAll;
			for(int j = 0; j<nAttr-1; j++) {
				int val = 0;
				int idx = domainAttr[j].indexOf(values.get(j));
				if(idx >= 0)
					val = countTable[j].get(idx).get(i);
				fnow *= (double)val/(double)sumTable[j].get(i);
			}
			if(fnow > high) {
				high = fnow;
				id = i;
			}
		}
		return domainAttr[nAttr-1].get(id);
	}
	public void fulltraining(Pair dataset) {
		ArrayList< Data > dataTable = dataset.getDataSet();
		reset();
		init(dataset);
		count(dataset, +1);
		int correct = 0;
		for(int i = 0; i<dataTable.size(); i++) {
			String result = test(dataTable.get(i));
			if(result.equals(dataTable.get(i).getAttributes().get(nAttr-1))) {
				correct++;
			}
		}
		System.out.println("Correct Answer : " + correct);
		System.out.println("Wrong Answer : " + (dataTable.size()-correct));
		System.out.println("Accuracy : " + (correct*100.0/dataTable.size()));
	}
	public void ten_fold(Pair dataset) {
		ArrayList< Data > dataTable = dataset.getDataSet();
		reset();
		init(dataset);
		count(dataset, +1);
		int sizeGroup = (dataTable.size()+9)/10;
		int offset = 0;
		int correct = 0;  
		for(int i = 0; i<10; i++) {
			ArrayList datas = new ArrayList();
			int to = offset+sizeGroup;
			if(to > dataTable.size())
				to = dataTable.size();
			for(int j = offset; j< to; j++) {
				datas.add(dataTable.get(j));
			}
			Pair datatest = new Pair(dataset.getAttrLib(), datas);
			count(datatest, -1);
			for(int j = offset; j<to; j++) {
				String result = test(dataTable.get(j));
				if(result.equals(dataTable.get(i).getAttributes().get(nAttr-1)))
					correct++;
			}
			count(datatest, +1);
			offset += sizeGroup;
		}
		System.out.println("Correct Answer : " + correct);
		System.out.println("Wrong Answer : " + (dataTable.size()-correct));
		System.out.println("Accuracy : " + (correct*100.0/dataTable.size()));
	}
}