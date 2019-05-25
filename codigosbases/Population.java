import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Population {

	ArrayList<Cromossomo> population;
	
	public Population(ArrayList<Cromossomo> population) {
		this.population = population;
	}
	
	
	
	
	public String toString() {
		 String s = "";
		 for(int i = 0;  i< this.population.size(); i++) {
			 for(int j = 0;  j< this.population.get(i).nodes.size(); j++)
			 s+="["+this.population.get(i).nodes.get(j)+"] ";
		 s+=" - fitness "+this.population.get(i).fitness +"\n";
		 }
		 
		 return s;
	}
}
