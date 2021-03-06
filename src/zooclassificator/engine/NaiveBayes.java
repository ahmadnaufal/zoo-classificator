package zooclassificator.engine;

import java.util.ArrayList;
import zooclassificator.model.*;

/**
 * 
 * 
 * @author Wiwit Rifa'i
 */

public class NaiveBayes {
	int nAttr, nAll;
	private ArrayList< ArrayList< Integer > > countTable[];
	private ArrayList< Integer >[] sumTable;
	private ArrayList <String>[] domainAttr;
	private String[] nameAttr;
	private ArrayList< ArrayList< Integer > > confusion; 
	public NaiveBayes() {
		reset();
	}
	public void reset() {
		nAll = 0;
		nAttr = 0;
		countTable = null;
		sumTable = null;
		domainAttr = null;
		confusion = null;
	}
	
	public void init(Pair dataset) {
		ArrayList< Data > attribut  = dataset.getAttrLib();
		ArrayList< String > classAttr = attribut.get(attribut.size()-1).getAttributes();
		// Initailize domain Attribut
		nAttr = attribut.size();
		nAll = 0;
		domainAttr = new ArrayList[nAttr];
		nameAttr = new String[nAttr];
		for(int i = 0; i<nAttr; i++) {
			ArrayList<String> temp = attribut.get(i).getAttributes();
			domainAttr[i] = new ArrayList<>();
			for(String s : temp) {
				domainAttr[i].add(s);
			}
			nameAttr[i] = new String(attribut.get(i).getName());
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
		// Inisialisasi Confusion Matrix
		confusion = new ArrayList<>();
		for(int i = 0; i<domainAttr[nAttr-1].size(); i++) {
			confusion.add(new ArrayList());
			for(int j = 0; j<domainAttr[nAttr-1].size(); j++)
				confusion.get(i).add(0);
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
				if(id < 0) {
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
		int ix = -1;
		if(values.size() >= nAttr)
			ix = domainAttr[nAttr-1].indexOf(values.get(nAttr-1));
		if(ix >= 0)
			confusion.get(ix).set(id, confusion.get(ix).get(id)+1);
		return domainAttr[nAttr-1].get(id);
	}
        
	public String fulltraining(Pair dataset) {
        StringBuilder sb = new StringBuilder();
        
		ArrayList< Data > dataTable = dataset.getDataSet();
		reset();
		init(dataset);
		count(dataset, +1);
		sb.append(printModel());
		sb.append(printProbabilisticModel());
		int correct = 0;
                
		for(int i = 0; i<dataTable.size(); i++) {
			String result = test(dataTable.get(i));
			if(result.equals(dataTable.get(i).getAttributes().get(nAttr-1))) {
				correct++;
			}
		}
		sb.append(printConfusion());
		sb.append("\n--- Full Training Set ---\n");
		sb.append("Correct Answer\t: ").append(correct).append("\n");
		sb.append("Wrong Answer  \t: ").append(dataTable.size()-correct).append("\n");
		sb.append("Total         \t: ").append(dataTable.size()).append("\n");
		sb.append("Accuracy      \t: ").append(correct*100.0/dataTable.size()).append(" %\n");
                
                return sb.toString();
	}
        
	public String ten_fold(Pair dataset) {
        StringBuilder sb = new StringBuilder();
        
		ArrayList< Data > dataTable = dataset.getDataSet();
		reset();
		init(dataset);
		count(dataset, +1);
		sb.append(printModel());
		sb.append(printProbabilisticModel());
		int sizeMin = dataTable.size()/10, mod = dataTable.size() % 10;
		int offset = 0;
		int correct = 0;
                
		for(int i = 0; i<10; i++) {
			ArrayList datas = new ArrayList();
			int to = offset+sizeMin;
			if(mod > 0) {
				to++;
				mod--;
			}
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
			offset = to;
		}
		sb.append(printConfusion());
		sb.append("\n--- Cross Validation 10-fold ---\n");
		sb.append("Correct Answer\t: ").append(correct).append("\n");
		sb.append("Wrong Answer  \t: ").append(dataTable.size()-correct).append("\n");
		sb.append("Total         \t: ").append(dataTable.size()).append("\n");
		sb.append("Accuracy      \t: ").append(correct*100.0/dataTable.size()).append(" %\n");
        
		return sb.toString();
	}
        
	public String printProbabilisticModel() {
        StringBuilder sb = new StringBuilder();
                
		sb.append("--- Classifier Probabilistic Model (Full Training Set)---\n\n");
		sb.append(String.format(" %10s : ", nameAttr[nAttr-1]));
		for(int i = 0; i < domainAttr[nAttr-1].size(); i++)
			sb.append(String.format( " %10s", domainAttr[nAttr-1].get(i)));
		sb.append("\n");
		int cnt = 11*domainAttr[nAttr-1].size() + 14;
		for(int i = 0; i<cnt; i++)
			sb.append("-");
		sb.append("\n");
		for(int i = 0; i < nAttr-1; i++) {
			sb.append(nameAttr[i]).append(" :\n");
			for(int j = 0; j < domainAttr[i].size(); j++) {
				sb.append(" ").append(String.format("%10s", domainAttr[i].get(j))).append(" = ");
				for(int k = 0; k<domainAttr[nAttr-1].size(); k++) {
					sb.append(String.format(" %10.7s", (double)countTable[i].get(j).get(k)/sumTable[i].get(k)));
				}
				sb.append("\n");
			}
			sb.append("\n");
		}
                
        return sb.toString();
	}
	public String printConfusion() {
        StringBuilder sb = new StringBuilder();
		sb.append("--- Confusion Matrix ---\n\n");
		for(int i = 0; i < confusion.size(); i++) {
			sb.append(String.format("%10s ", "attr" + (i+1)));
		}
		sb.append("\n");
		for(int i = 0; i < confusion.size(); i++) {
			for(int j = 0; j<confusion.get(i).size(); j++) {
				sb.append(String.format("%10s ", confusion.get(i).get(j)));
			}
			sb.append(" | ").append("attr"+(i+1)).append(" = ").append(domainAttr[nAttr-1].get(i) + "\n");
		}
		return sb.toString();
	}
	public String printModel() {
        StringBuilder sb = new StringBuilder();
                
		sb.append("--- Classifier Model (Full Training Set) ---\n\n");
		sb.append(String.format(" %10s : ", nameAttr[nAttr-1]));
		for(int i = 0; i < domainAttr[nAttr-1].size(); i++)
			sb.append(String.format( " %10s", domainAttr[nAttr-1].get(i)));
		sb.append("\n");
		int cnt = 11*domainAttr[nAttr-1].size() + 14;
		for(int i = 0; i<cnt; i++)
			sb.append("-");
		sb.append("\n");
		for(int i = 0; i < nAttr-1; i++) {
			sb.append(nameAttr[i]).append(" :\n");
			for(int j = 0; j < domainAttr[i].size(); j++) {
				sb.append(" ").append(String.format("%10s", domainAttr[i].get(j))).append(" = ");
				for(int k = 0; k<domainAttr[nAttr-1].size(); k++) {
					sb.append(String.format(" %10s", countTable[i].get(j).get(k)));
				}
				sb.append("\n");
			}
			sb.append(" TOTAL      = ");
			for(int k = 0; k<domainAttr[nAttr-1].size(); k++) {
				sb.append(String.format(" %10s", sumTable[i].get(k)));
			}
			sb.append("\n\n");
		}
                
        return sb.toString();
	}
}