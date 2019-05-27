import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*Classe representa uma populuação, ou seja, contém uma
 * lista de indivíduos.
 */
public class Population {
	//lista de individuos (cromossomos)
	ArrayList<Cromossomo> individuals;
	
	public Population(ArrayList<Cromossomo> individuals) {
		this.individuals = individuals;
	}
	
	//Calcula o fitness
	@SuppressWarnings("unchecked")
	public void calcFitness() {
		
		//calcula o fitness de cada cromossomo
		for(int i = 0;  i< this.individuals.size(); i++)
			this.individuals.get(i).calcFitness();
		
		//ordenando o arraylista conforme o fitness dos
		//cromossomos
		Collections.sort(this.individuals, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				Cromossomo c1 = (Cromossomo) o1;
				Cromossomo c2 = (Cromossomo) o2;
				if(c1.fitness > c2.fitness)
					return 1;
				else if(c1.fitness < c2.fitness)
					return -1;
				else
					return  0;
			}

		});
	}
	
	@Override
	public String toString() {
		 String s = "";
		 for(int i = 0;  i< this.individuals.size(); i++) {
			 for(int j = 0;  j< this.individuals.get(i).nodes.size(); j++) {
				 s+="["+this.individuals.get(i).nodes.get(j)+"] ";
				 
			 }
		 
			 s+=" - fitness "+this.individuals.get(i).fitness +"\n";	 
		 }
		 
		
;		 
		 return s;
	}
}
