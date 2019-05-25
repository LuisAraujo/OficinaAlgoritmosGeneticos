import java.util.ArrayList;

public class Cromossomo implements Comparable {
	ArrayList<Node> nodes;
	int fitness;

	public Cromossomo() {
		nodes = new ArrayList<Node>();
	}
	
	public void calcFitness() {
		int[] count = new int[7];
		fitness = 0;
		
		for(int i = 0; i < this.nodes.size() - 1; i++) {
			fitness += nodes.get(i).getLinkTo(nodes.get(i+1));
			if(nodes.get(i).label.equals("A")) {
					count[0]++;
			}else if(nodes.get(i).label.equals("B")) {
				count[1]++;
			}else if(nodes.get(i).label.equals("C")) {
				count[2]++;
			}else if(nodes.get(i).label.equals("D")) {
				count[3]++;
			}else if(nodes.get(i).label.equals("E")) {
				count[4]++;
			}else if(nodes.get(i).label.equals("F")) {
				count[5]++;
			}else if(nodes.get(i).label.equals("G")) {
				count[6]++;
			}
		}
		
		//punindo
		for(int i = 0; i < count.length; i++) {
			if(count[i]>1)
				fitness = Integer.MAX_VALUE;
		}
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
		Cromossomo newc = new Cromossomo();

		for(int i = 0; i < c1.nodes.size(); i++)
			if(i%2 == 0)
				newc.nodes.add(i, c1.nodes.get(i));
			else
				newc.nodes.add(i, c2.nodes.get(i));
				
		if((int) Math.random()  > 0.5)
			newc = mutation(newc);
		
		return newc;
	} 
	
	public static Cromossomo mutation(Cromossomo c) {
		
	   int i = (int) Math.random() * c.nodes.size();
	   int j = (int) Math.random() * c.nodes.size();
	   Node n = c.nodes.get(i);
	   c.nodes.set(i, c.nodes.get(j));
	   c.nodes.set(j, n);
	   
	   return c;	
	}
	
	public String toString() {
		String s = "";
		for(int j = 0;  j< nodes.size(); j++)
			 s+="["+nodes.get(j)+"] ";
		
		s+=" - fitness "+fitness +"\n";
		
	
		return s;
	}
}
