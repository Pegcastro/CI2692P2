/**
 * Vertice.java
 * Autores: 
 * @author Pablo González. Carnet: 13-10575
 * @author Luis Marval. Carnet: 12-10620
 */

import java.util.*;

public class Edificio
{
  private String id;
  private int altura;
  public LinkedList<Vertice> adyacentes;
  public LinkedList<Vertice> predecesores;
  public LinkedList<Vertice> sucesores;

/** 
 * Vertice:
 * Crea un vertice con identificador y peso
 * Parametros de entrada: 
 * @param id: tipo String, identificador del vertice
 * @param peso: tipo Double, peso del vertice
 * Parametros de salida:
 * @throws vertice: objeto tipo Vertice
*/ 
  public Vertice(String id, int altura) {
    this.id = id;
    this.altura = altura;

  }

/** 
 * getPeso:
 * Devuelve el peso del vertice
 * Parametros de entrada: 
 * @param vertice: tipo Vertice
 * Parametros de salida:
 * @throws peso: tipo Double, peso del vertice
*/ 
  public int getAltura() {
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


  public LinkedList<Vertice> getSuc(){
    return sucesores;
  }

  public LinkedList<Vertice> getPred(){
    return predecesores;
  }

  public LinkedList<Vertice> getAdy(){
    return adyacentes;
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
    String alturaStr = int.toString(altura); 
  	return id + " " + alturaStr;
  }
}