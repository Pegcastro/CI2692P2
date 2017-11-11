/**
 * Lado.java
 * Autores: 
 * @author Pablo González. Carnet: 13-10575
 * @author Luis Marval. Carnet: 12-10620
 */

public abstract class Lado
{
  private String id;
  private int altura;

/**
 * Lado:
 * Crea un nuevo lado identificador y peso 
 * Parametros de entrada: 
 * @param id: tipo String, identificador del lado
 * @param peso: tipo Double, peso del lado 
 * Parametros de salida:
 * @throws lado: objeto tipo Lado 
*/
  public Lado(String id, int altura) {
    this.id = id;
    this.altura = altura;
  }

/**
 * getId:
 * Obtiene el identificador del lado
 * Parametros de entrada: 
 * @param lado: objeto tipo Lado 
 * Parametros de salida:
 * @throws id: tipo String, identificador del lado
*/
  public String getId() {
  	return id;
  }

/**
 * getPeso:
 * Obtiene el peso del lado
 * Parametros de entrada: 
 * @param lado: objeto tipo Lado 
 * Parametros de salida:
 * @throws id: tipo String, identificador del lado
*/
  public int getPeso() {
  	return altura;
  }

  public abstract String toString();

}