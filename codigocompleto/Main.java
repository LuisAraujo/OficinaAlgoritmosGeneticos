import java.util.ArrayList;


public class Main {
		
	public static void main(String[] args) {
		
		 //numero maximo de geracões
		int maxgeneration = 1000;
		//geração atual
		int currentgeneration = 0;
		//melhor individuo de todas as populações
		Cromossomo bestfitness = null;
		//geração onde o melhor indivíduo foi gerado
		int gerationofbestfitness = 0;
		//número maximo de gerações sem melhoria de fitness
		int maxgenerationofbestfitness = maxgeneration/2;
		
		//inicia o grafo
		Graph graph = startGraph();
		//gera a população inicial
		Population p = geratePopulation(graph, 1000);
		//calcula o fitness dessa população
		p.calcFitness();
		
		System.out.println("População Inicial:");
		System.out.println(p);
		
		
		//critério de parada:
		//1 - geração atual > do que o máximo de gerações
		//2 - número de geração sem melhora > maxgeração sem melhora
		while ( (currentgeneration  < maxgeneration) && 
				(currentgeneration - gerationofbestfitness < maxgenerationofbestfitness ) ){
			
			//seleciona a nova população (realizando cruzamento)
			p = selection(p);
			//realiza mutação
			p = mutation(p);
			//calcula o fitness dessa população
			p.calcFitness();
			
			//incremente a geração
			currentgeneration++;
			
			//se encontrar um melhor indivíduo 
			if(p.individuals.get(0) != bestfitness) {
				bestfitness = p.individuals.get(0);
				gerationofbestfitness = currentgeneration;
			}
			
		}
		
		//exibe a população final
		System.out.println("Final");
		System.out.println(p);
		
		//melhor fitness
		System.out.println("Melhor fitness" + p.individuals.get(0));

	}
	
	/* Gera a população inicial, dado um grafo e um numero de
	 * indivíduos (tamanho da população)*/
	public static Population geratePopulation(Graph graph, int sizePopulation){
		
		ArrayList<Cromossomo> cromossomos = new ArrayList<Cromossomo>();
		
		//cria n cromossmos
		for(int j = 0; j < sizePopulation; j++) {
			
			ArrayList<Node> a = new ArrayList<Node>();
			
			//copiando de graph para a [A, B, C, D, E, F, G]
			for(int i = 0; i < graph.nodes.size(); i++)
				a.add(graph.nodes.get(i));
			
			//novo cromossomo
			Cromossomo c = new Cromossomo();
			
			//de forma aleatória retira de a e adiciona em c
			for(int i = 0; i < graph.nodes.size(); i++) {
				int n = (int) ( Math.random() * a.size() );
				c.nodes.add( a.remove(n)  ); 
			}
			//adicioma o cromosso na lista de cromossomos
			cromossomos.add(c);
		}
		
		//cria a população como a lista de cromossomos
		Population np = new Population(cromossomos);
		
		return np;
	}
	
	/*Realiza seleção dos indivíduos para a próxima geração.*/
	public static Population selection(Population old) {
		
		ArrayList<Cromossomo> cromossomos = new ArrayList<Cromossomo>();
		
		//Elitista: pega os dois melhores para seguirem na geração seguinte
		cromossomos.add(old.individuals.get(0));
		cromossomos.add(old.individuals.get(1));
		
		//Gera 50% da população através de cruzamento
		for(int i = 0; i < old.individuals.size(); i+=2) {
			Cromossomo c = Cromossomo.crossover(old.individuals.get(i),
					old.individuals.get(i+1));
			
			cromossomos.add(c);
		}
		
		//pega outra metade da população. 
		for(int i = 0; i < old.individuals.size()/2-2; i++) {
			
			Cromossomo c = Cromossomo.crossover( old.individuals.get(i),
					old.individuals.get(old.individuals.size() - i - 1));
			cromossomos.add(c);
		}

		//nova população
		Population newp = new Population(cromossomos);
		
		return newp;
	}
	
	/*realiza mutação da população*/
	public static Population mutation(Population p) {
		//para toda a população, menos para os dois melhores	
	    for(int i = 2; i< p.individuals.size()-1; i++)
	    	//50% de chance de mutar
	        if(Math.random() > 0.5)
	        	p.individuals.get(i).mutation(p.individuals.get(i+1));
	
		return p;
	}
	
	/*Gerando grafo inicial*/
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
