import java.util.ArrayList;

public class Cromossomo implements Comparable {
	ArrayList<Node> nodes;
	int fitness;

	public Cromossomo() {
		nodes = new ArrayList<Node>();
	}
	
	public void calcFitness() {
	
	}

	@Override
	public int compareTo(Object arg) {
		Cromossomo c = (Cromossomo) arg;
		if(this.fitness > c.fitness)
			return 1;
		else if(this.fitness > c.fitness)
			return -1;
		else
			return  0;
	}
	
	public static Cromossomo crossover(Cromossomo c1, Cromossomo c2) {
		return null;
	} 
	
	public static Cromossomo mutation(Cromossomo c) {
		return null;
	}
	
	public String toString() {
		String s = "";
		for(int j = 0;  j< nodes.size(); j++)
			 s+="["+nodes.get(j)+"] ";
		
		s+=" - fitness "+fitness +"\n";
		
	
		return s;
	}
}
