public class GrafoCliente{

	public static void main(String[] args){
		Digrafo g = new Digrafo();
		boolean success = g.cargarGrafo(args[0]);
		System.out.println(g.toString());
	}
}