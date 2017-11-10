import java.util.*;

public class Tarjan{

	private int nvertices; // Numero de vertices
	private int preCount; // Numero de preorden
	private int[] low; // low number of v
	private boolean[] visitado; // arreglo para verificar si fue visitado
	private LinkedList<Vertice> graph; // Guardar los vertices del grafo
	private List<List<Vertice>> sccComp;
	private Stack<Vertice> stack;

	public List<List<Vertice>> Tarjan(List<Vertice>[] graph){

		verts = graph.vertices.size();
		this.graph = graph;
		low = new int[];
		visitado = new boolean[verts];
		stack = new Stack<Vertice>();
		sccComp = new ArrayList<>();
		preCount = 0;

		for (int n = 0; n<v; n++){
			if (!visitado[n]){
				dfs(n);
			}
		}

		return sccComp;
	}

	public void dfs(Vertice v){

		low[v.getId()] = preCount++;
		visitado[v.getId] = true;
		stack.push(v);
		int min = low[v];
		for (int w:v.getSuc()){
			if(!visitado[w.getId()]){
				dfs(w);
			}
			if(low[w.getId()] < min){
				min = low[w.getId()];
			}
		}

		if (min < low[w.getId()]){

			low[v.getId()] = min;
			return;
		}
		
		List<Integer> componente = new ArrayList<Integer>();
		while(w.getId() != v.getId()){
			w = stack.pop();
			componente.add(w);
			low[w.getId()] = v;
		}

		sccComp.add(componente);
	}


}