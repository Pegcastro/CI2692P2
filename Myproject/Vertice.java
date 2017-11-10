/**
 * Vertice.java
 * Autores: 
 * @author Pablo González. Carnet: 13-10575
 * @author Luis Marval. Carnet: 12-10620
 */

import java.util.*;

public class Vertice
{
  private String id;
  private int altura;
  public LinkedList<Vertice> adyacentes;
  public LinkedList<Vertice> predecesores;
  public LinkedList<Vertice> sucesores;

/** 
 * Vertice:
 * Crea un vertice con identificador y altura
 * Parametros de entrada: 
 * @param id: tipo String, identificador del vertice
 * @param altura: tipo Double, altura del vertice
 * Parametros de salida:
 * @throws vertice: objeto tipo Vertice
*/ 
  public Vertice(String id, int altura) {
    this.id = id;
    this.altura = altura;
    adyacentes = new LinkedList<Vertice>();
    predecesores = new LinkedList<Vertice>();
    sucesores = new LinkedList<Vertice>();
  }

/** 
 * getaltura:
 * Devuelve el altura del vertice
 * Parametros de entrada: 
 * @param vertice: tipo Vertice
 * Parametros de salida:
 * @throws altura: tipo Double, altura del vertice
*/ 
  public double getAltura() {
  	return altura;
  }

/** 
 * getId:
 * Devuelve el id del vertice
 * Parametros de entrada: 
 * @param vertice: tipo Vertice
 * Parametros de salida:
 * @throws id: tipo int, id del vertice
*/ 
  public String getId() {
  	return id;
  }

/**
* toString:
* Devuelve una representacion del vertice v como una cadena de caracteres
* Parametros de entrada:
* @param vertice: objeto tipo Vertice
* Parametros de salida:
* @throws : tipo String, representacion del vertice como una cadena de caracteres
*/
  public String toString() { 
  	return id + " " + String.valueOf(altura);
  }
}