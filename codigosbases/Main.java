import java.util.ArrayList;

public class Main {
		
	public static void main(String[] args) {
		
		Graph graph = startGraph();

	}
	
	public static Population geratePopulation(Graph graph, int sizePopulation){
		return null;
	}
	
	public static Population selection(Population old) {
		
		return null;
	}
	
	public static Graph startGraph() {
		
		Node n1 = new Node("A"); 
		Node n2 = new Node("B"); 
		Node n3 = new Node("C"); 
		Node n4 = new Node("D"); 
		Node n5 = new Node("E"); 
		Node n6 = new Node("F"); 
		Node n7 = new Node("G"); 
		
		//A
		n1.addLink(new Link(n2, 10));
		n1.addLink(new Link(n3, 40));
		n1.addLink(new Link(n4, 50));
		n1.addLink(new Link(n5, 30));
		n1.addLink(new Link(n6, 50));
		n1.addLink(new Link(n7, 10));
		
		//B
		n2.addLink(new Link(n1, 10));
		n2.addLink(new Link(n3, 10));
		n2.addLink(new Link(n4, 30));
		n2.addLink(new Link(n5, 40));
		n2.addLink(new Link(n6, 60));
		n2.addLink(new Link(n7, 40));
		
		//C
		n3.addLink(new Link(n1, 40));
		n3.addLink(new Link(n2, 10));
		n3.addLink(new Link(n4, 5));
		n3.addLink(new Link(n5, 40));
		n3.addLink(new Link(n6, 50));
		n3.addLink(new Link(n7, 50));
		
		//D
		n4.addLink(new Link(n1, 50));
		n4.addLink(new Link(n2, 30));
		n4.addLink(new Link(n3, 5));
		n4.addLink(new Link(n5, 40));
		n4.addLink(new Link(n6, 40));
		n4.addLink(new Link(n7, 60));
		
		//E
		n5.addLink(new Link(n1, 30));
		n5.addLink(new Link(n2, 40));
		n5.addLink(new Link(n3, 40));
		n5.addLink(new Link(n4, 40));
		n5.addLink(new Link(n6, 10));
		n5.addLink(new Link(n7, 20));
		
		
		//F
		n6.addLink(new Link(n1, 50));
		n6.addLink(new Link(n2, 60));
		n6.addLink(new Link(n3, 50));
		n6.addLink(new Link(n4, 40));
		n6.addLink(new Link(n5, 10));
		n6.addLink(new Link(n7, 50));
		
		
		//G
		n7.addLink(new Link(n1, 10));
		n7.addLink(new Link(n2, 40));
		n7.addLink(new Link(n3, 50));
		n7.addLink(new Link(n4, 60));
		n7.addLink(new Link(n5, 20));
		n7.addLink(new Link(n6, 50));
		
		
		ArrayList<Node> nodes = new ArrayList();
		nodes.add(n1);
		nodes.add(n2);
		nodes.add(n3);
		nodes.add(n4);
		nodes.add(n5);
		nodes.add(n6);
		nodes.add(n7);
		
		Graph graph = new Graph(nodes);
		
		return graph;
		
	}

}
