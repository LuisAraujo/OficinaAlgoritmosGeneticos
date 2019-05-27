import java.util.ArrayList;

/*Classe que representa um Grafo*/
public class Graph {
	ArrayList<Node> nodes;
	
	public Graph(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
	
	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
	
	public void addNodes(Node node) {
		this.nodes.add(node);
	}
	
}
