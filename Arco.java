/**
 * Arco.java
 * Autores: 
 * @author Pablo González. Carnet: 13-10575
 * @author Luis Marval. Carnet: 12-10620
 */

public class Arco extends Lado
{
  private Vertice extremoInicial;
  private Vertice extremoFinal;

/** 
 * Arco:
 * Crea un arco con identificador, peso, vertice extremo inicial y vertice extremo final del arco
 * Parametros de entrada: 
 * @param id: tipo String, identificador del arco
 * @param peso: tipo Double, peso del arco
 * @param vi: objeto tipo Vertice, vertice extremo inicial del arco 
 * @param vf: objeto tipo Vertice, vertice extremo final del arco 
 * Parametros de salida:
 * @throws arco: objeto Arco
*/ 
  public Arco(String id, int peso, Vertice extremoInicial, Vertice extremoFinal) {
    super(id, peso);
    id = id;
    peso = peso;
  	this.extremoInicial = extremoInicial;
    this.extremoFinal = extremoFinal;
  }

/** 
 * getExtremoInicial:
 * Obtiene el vertice que es el extremo inicial del arco
 * Parametros de entrada: 
 * @param arco: tipo Arco
 * Parametros de salida:
 * @throws extremoInicial: tipo Vertice, vertice inicial del arco
*/ 
  public Vertice getExtremoInicial() {
  	return this.extremoInicial;
  }

/** 
 * getExtremoFinal:
 * Obtiene el vertice que es el extremo final del arco
 * Parametros de entrada: 
 * @param arco: tipo Arco
 * Parametros de salida:
 * @throws extremoFinal: tipo Vertice, vertice final del arco
*/ 
  public Vertice getExtremoFinal() {
  	return this.extremoFinal;
  }


/** 
 * toString:
 * Retorna la representacion en String del arco
 * Parametros de entrada: 
 * @param arco: tipo Arco
 * Parametros de salida:
 * @throws String: tipo String, representacion en cadena de caracteres del arco
 */
  public String toString() {
  	String space = " ";
    String pesoStr = Integer.toString(this.getPeso());
    return this.getId() + space + extremoInicial.getId() + space + extremoFinal.getId() + space + pesoStr;
  }
  
}
