	import java.util.ArrayList;

public class Node {
	String label;
	ArrayList<Link> links;

	public Node(String label) {
		this.label = label; 
		this.links = new ArrayList<Link>();
	}
	
	public String getLabel() {
		return label;
	}
	public void addLink(Link link) {
		links.add(link);
	}
	public ArrayList<Link> getLink() {
		return links;
	}
	
	public int getWeightBtw(Node node) {
		for(int i = 0; i < this.links.size(); i++)
			if(links.get(i).getNode() == node)		
				return links.get(i).getWeight();
		
		return 0;
	}
	
	public String toString() {
		return this.label;
	}
}
