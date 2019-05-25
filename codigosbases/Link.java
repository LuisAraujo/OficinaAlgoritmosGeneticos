
public class Link {
	
	int weight;
	Node node;

	public Link(Node node, int weight) {
		this.weight = weight;
		this.node = node;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public Node getNode() {
		return node;
	}

}
