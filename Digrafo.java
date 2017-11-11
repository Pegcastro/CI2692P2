/**
 * Digrafo.java
 * Autores: 
 * @author Pablo González. Carnet: 13-10575
 * @author Luis Marval. Carnet: 12-10620
 */

import java.util.*;
import java.io.*;

public class Digrafo implements Grafo
{
    private List<Vertice> vertices;
    private LinkedList<Arco> arcos;
    private int[][] mat;
    private int nLados;

/**
* Digrafo:
* Creacion del digrafo o grafo dirigido
*/
    public Digrafo() {
        vertices = new LinkedList<Vertice>();
        arcos = new LinkedList<Arco>();
        nLados = 0;
    }

/**
*cargarGrafo:
* Carga la información almacenada en un archivo de texto para crear un grafo.
* Parametros de entrada:
* @param g: grafo.
* @param dirArchivo: Nombre(direccion) del archivo con informacion.
* Parametros de salida:
* @throws boolean: true en caso de cargar exitosamente el grafo, false en caso contrario.
*/
    public boolean cargarGrafo(String dirArchivo) {
        String id,extI,extF;
        int n;
        Double peso;

        try{
            BufferedReader buffer = new BufferedReader(new FileReader(dirArchivo));
            String linea;
            String[] datos;
            linea = buffer.readLine();
            n = Integer.parseInt(linea);

            linea = buffer.readLine();
            m = Integer.parseInt(linea);

            mat = int[n][m];

            for(int i=0; i < n; i++){
                linea = buffer.readLine();
                datos = linea.split(" ");
                for (int j=0, j < m, j++){
                    mat[i][j] = Integer.parseInt(datos[j]);
                    id = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                    altura = mat[i][j];
                    Vertice v = new Vertice(id, altura);
                    vertices.add(v);
                }
            }

            buffer.close();
            return true;
        }catch(IOException e){
            System.out.println("Hubo un error");
            return false;
        }

        // Crear el grafo
        i = 0;
        j = 0;

        String id1;
        String id2;
        String id3;

        while(i < n){

            if (i=0){ // primera fila
                if(j = 0){ // primera columna
                    if(mat[i][j+1] <= mat[i][j]){ // derecha
                        id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                        id2 = "(" + String.valueOf(i) + "," + String.valueOf(j+1) + ")";
                        id3 = "[" + id1 + id2 + "]";
                        Vertice v = obtenerVertice(id1);
                        Vertice w = obtenerVertice(id2);
                        agregarArco(id3,0,v,w);
                    }

                    if(mat[i+1][j] <= mat[i][j]){ // abajo
                        id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                        id2 = "(" + String.valueOf(i+1) + "," + String.valueOf(j) + ")";
                        id3 = "[" + id1 + id2 + "]";
                        Vertice v = obtenerVertice(id1);
                        Vertice w = obtenerVertice(id2);
                        agregarArco(id3,0,v,w);
                    }
                    j++;
                    continue;
                }

                if(j = m-1){ // ultima columna
                    if(mat[i][j-1] <= mat[i][j]){ // izquierda
                        id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                        id2 = "(" + String.valueOf(i) + "," + String.valueOf(j-1) + ")";
                        id3 = "[" + id1 + id2 + "]";
                        Vertice v = obtenerVertice(id1);
                        Vertice w = obtenerVertice(id2);
                        agregarArco(id3,0,v,w);
                    }

                    if(mat[i+1][j] <= mat[i][j]){ // abajo
                        id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                        id2 = "(" + String.valueOf(i+1) + "," + String.valueOf(j) + ")";
                        id3 = "[" + id1 + id2 + "]";
                        Vertice v = obtenerVertice(id1);
                        Vertice w = obtenerVertice(id2);
                        agregarArco(id3,0,v,w);
                    }
                    j=0;
                    i++;
                    continue;
                }

                // 0 < j < m-1
                if(mat[i][j-1] <= mat[i][j]){ // izquierda
                    id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                    id2 = "(" + String.valueOf(i) + "," + String.valueOf(j-1) + ")";
                    id3 = "[" + id1 + id2 + "]";
                    Vertice v = obtenerVertice(id1);
                    Vertice w = obtenerVertice(id2);
                    agregarArco(id3,0,v,w);
                }

                if(mat[i+1][j] <= mat[i][j]){ // abajo
                    id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                    id2 = "(" + String.valueOf(i+1) + "," + String.valueOf(j) + ")";
                    id3 = "[" + id1 + id2 + "]";
                    Vertice v = obtenerVertice(id1);
                    Vertice w = obtenerVertice(id2);
                    agregarArco(id3,0,v,w);
                }

                if(mat[i][j+1] <= mat[i][j]){ // derecha
                    id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                    id2 = "(" + String.valueOf(i) + "," + String.valueOf(j+1) + ")";
                    id3 = "[" + id1 + id2 + "]";
                    Vertice v = obtenerVertice(id1);
                    Vertice w = obtenerVertice(id2);
                    agregarArco(id3,0,v,w);
                }
                j++;
            }

            if (i=n-1){ // ultima fila
                if(j = 0){ // primera columna
                    if(mat[i][j+1] <= mat[i][j]){ // derecha
                        id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                        id2 = "(" + String.valueOf(i) + "," + String.valueOf(j+1) + ")";
                        id3 = "[" + id1 + id2 + "]";
                        Vertice v = obtenerVertice(id1);
                        Vertice w = obtenerVertice(id2);
                        agregarArco(id3,0,v,w);
                    }

                    if(mat[i-1][j] <= mat[i][j]){ // arriba
                        id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                        id2 = "(" + String.valueOf(i-1) + "," + String.valueOf(j) + ")";
                        id3 = "[" + id1 + id2 + "]";
                        Vertice v = obtenerVertice(id1);
                        Vertice w = obtenerVertice(id2);
                        agregarArco(id3,0,v,w);
                    }
                    j++;
                    continue;
                }

                if(j = m-1){ // ultima columna
                    if(mat[i][j-1] <= mat[i][j]){ // izquierda
                        id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                        id2 = "(" + String.valueOf(i) + "," + String.valueOf(j-1) + ")";
                        id3 = "[" + id1 + id2 + "]";
                        Vertice v = obtenerVertice(id1);
                        Vertice w = obtenerVertice(id2);
                        agregarArco(id3,0,v,w);
                    }

                    if(mat[i-1][j] <= mat[i][j]){ // arriba
                        id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                        id2 = "(" + String.valueOf(i-1) + "," + String.valueOf(j) + ")";
                        id3 = "[" + id1 + id2 + "]";
                        Vertice v = obtenerVertice(id1);
                        Vertice w = obtenerVertice(id2);
                        agregarArco(id3,0,v,w);
                    }
                    j=0;
                    i++;
                    continue;
                }

                // 0 < j < m-1
                if(mat[i][j-1] <= mat[i][j]){ // izquierda
                    id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                    id2 = "(" + String.valueOf(i) + "," + String.valueOf(j-1) + ")";
                    id3 = "[" + id1 + id2 + "]";
                    Vertice v = obtenerVertice(id1);
                    Vertice w = obtenerVertice(id2);
                    agregarArco(id3,0,v,w);
                }

                if(mat[i-1][j] <= mat[i][j]){ // arriba
                    id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                    id2 = "(" + String.valueOf(i-1) + "," + String.valueOf(j) + ")";
                    id3 = "[" + id1 + id2 + "]";
                    Vertice v = obtenerVertice(id1);
                    Vertice w = obtenerVertice(id2);
                    agregarArco(id3,0,v,w);
                }

                if(mat[i][j+1] <= mat[i][j]){ // derecha
                    id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                    id2 = "(" + String.valueOf(i) + "," + String.valueOf(j+1) + ")";
                    id3 = "[" + id1 + id2 + "]";
                    Vertice v = obtenerVertice(id1);
                    Vertice w = obtenerVertice(id2);
                    agregarArco(id3,0,v,w);
                }
                j++;
            }

            // en el medio
            if(j = 0){ // primera columna
                if(mat[i][j+1] <= mat[i][j]){ // derecha
                    id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                    id2 = "(" + String.valueOf(i) + "," + String.valueOf(j+1) + ")";
                    id3 = "[" + id1 + id2 + "]";
                    Vertice v = obtenerVertice(id1);
                    Vertice w = obtenerVertice(id2);
                    agregarArco(id3,0,v,w);
                }

                if(mat[i+1][j] <= mat[i][j]){ // abajo
                    id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                    id2 = "(" + String.valueOf(i+1) + "," + String.valueOf(j) + ")";
                    id3 = "[" + id1 + id2 + "]";
                    Vertice v = obtenerVertice(id1);
                    Vertice w = obtenerVertice(id2);
                    agregarArco(id3,0,v,w);
                }

                if(mat[i-1][j] <= mat[i][j]){ // arriba
                    id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                    id2 = "(" + String.valueOf(i-1) + "," + String.valueOf(j) + ")";
                    id3 = "[" + id1 + id2 + "]";
                    Vertice v = obtenerVertice(id1);
                    Vertice w = obtenerVertice(id2);
                    agregarArco(id3,0,v,w);
                }
                j++;
                continue;
            }

            if(j = m-1){ // ultima columna
                if(mat[i][j-1] <= mat[i][j]){ // izquierda
                    id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                    id2 = "(" + String.valueOf(i) + "," + String.valueOf(j-1) + ")";
                    id3 = "[" + id1 + id2 + "]";
                    Vertice v = obtenerVertice(id1);
                    Vertice w = obtenerVertice(id2);
                    agregarArco(id3,0,v,w);
                }

                if(mat[i+1][j] <= mat[i][j]){ // abajo
                    id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                    id2 = "(" + String.valueOf(i+1) + "," + String.valueOf(j) + ")";
                    id3 = "[" + id1 + id2 + "]";
                    Vertice v = obtenerVertice(id1);
                    Vertice w = obtenerVertice(id2);
                    agregarArco(id3,0,v,w);
                }

                if(mat[i-1][j] <= mat[i][j]){ // arriba
                    id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                    id2 = "(" + String.valueOf(i-1) + "," + String.valueOf(j) + ")";
                    id3 = "[" + id1 + id2 + "]";
                    Vertice v = obtenerVertice(id1);
                    Vertice w = obtenerVertice(id2);
                    agregarArco(id3,0,v,w);
                }
                j=0;
                i++;
                continue;
            }

            // 0 < j < m-1
            if(mat[i][j-1] <= mat[i][j]){ // izquierda
                id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                id2 = "(" + String.valueOf(i) + "," + String.valueOf(j-1) + ")";
                id3 = "[" + id1 + id2 + "]";
                Vertice v = obtenerVertice(id1);
                Vertice w = obtenerVertice(id2);
                agregarArco(id3,0,v,w);
            }

            if(mat[i+1][j] <= mat[i][j]){ // abajo
                id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                id2 = "(" + String.valueOf(i+1) + "," + String.valueOf(j) + ")";
                id3 = "[" + id1 + id2 + "]";
                Vertice v = obtenerVertice(id1);
                Vertice w = obtenerVertice(id2);
                agregarArco(id3,0,v,w);
            }

            if(mat[i][j+1] <= mat[i][j]){ // derecha
                id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                id2 = "(" + String.valueOf(i) + "," + String.valueOf(j+1) + ")";
                id3 = "[" + id1 + id2 + "]";
                Vertice v = obtenerVertice(id1);
                Vertice w = obtenerVertice(id2);
                agregarArco(id3,0,v,w);
            }

            if(mat[i-1][j] <= mat[i][j]){ // arriba
                id1 = "(" + String.valueOf(i) + "," + String.valueOf(j) + ")";
                id2 = "(" + String.valueOf(i-1) + "," + String.valueOf(j) + ")";
                id3 = "[" + id1 + id2 + "]";
                Vertice v = obtenerVertice(id1);
                Vertice w = obtenerVertice(id2);
                agregarArco(id3,0,v,w);
            }
            j++;
        }
    }

/**
* numeroDeVertices:
* Indica el numero de vertices existentes en el grafo
* Parametros de entrada:
* @param g: grafo
* Parametros de salida:
* @throws nVertices: tipo int, numero de vertices en el grafo
*/
    public int numeroDeVertices() {
        return vertices.size();
    }

/**
* numeroDeLados:
* Indica el numero de lados existentes en el grafo
* Parametros de entrada:
* @param g: grafo
* Parametros de salida:
* @throws nLados: tipo int, numero de lados en el grafo
*/
    public int numeroDeLados() {
        return arcos.size();
    }

/**
* agregarVertice:
* Agrega el vertice v al grafo g
* Parametros de entrada:
* @param g: grafo
* @param v: objeto tipo Vertice
* Parametros de salida:
* @throws boolean: true, en caso de agregar el vertice de manera exitosa; false, en caso contrario
*/     
    public boolean agregarVertice(Vertice v) {

        if(vertices.size() == 0) {
            vertices.add(v);
            return true;
        }

        if(this.estaVertice(v.getId())){
            return false;
        }

        else{
        vertices.add(v);
        return true;
        }
    }

/**
* agregarVertice:
* Agrega el vertice v al grafo g
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del vertice
* @param peso: tipo Double, peso del vertice
* Parametros de salida:
* @throws boolean: true, en caso de agregar el vertice de manera exitosa; false, en caso contrario
*/
    public boolean agregarVertice(String id, double peso) {

        if(this.estaVertice(id)){
            return false;
        }

        if(vertices.size() == 0) {
            Vertice v = new Vertice(id, peso);
            vertices.add(v);
            return true;
        }

        Vertice v = new Vertice(id, peso);
        vertices.add(v);
        return true;
    }

/**
* obtenerVertice:
* Retorna el vertice contenido en el grafo que posee el identificador
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del vertice
* Parametros de salida:
* @throws Vertice: objeto tipo Vertice
*/   
    public Vertice obtenerVertice(String id) {
        for(int i=0; i<vertices.size(); i++){
            if(vertices.get(i).getId().equals(id)){
                return vertices.get(i);
            }
        }
        throw new NoSuchElementException();
    }

/**
* estaVertice:
* Indica si un vertice con el identificador id se encuentra o no en el grafo
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del vertice
* Parametros de salida:
* @throws boolean: true, en caso de que el vertice exista en el grafo; false, en caso contrario
*/
    public boolean estaVertice(String id) {
        for(int i=0; i<vertices.size(); i++){
            if (vertices.get(i).getId().equals(id)){
                return true;
            }
        }
        return false;
    }

/**
* estaLado:
* Indica si un lado pertenece al grafo
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del lado
* Parametros de salida:
* @throws boolean: true, en caso de que el lado pertenezca al grafo; false, en caso contrario
*/
    public boolean estaLado(String u, String v){
        for(int i=0; i<arcos.size(); i++){
            if (arcos.get(i).getExtremoInicial().equals(u) && arcos.get(i).getExtremoFinal().equals(v)){
                return true;
            }
        }
        return false; 
    }

/**
* eliminarVertice:
* Elimina el vertice con identificador id del grafo g
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del vertice
* Parametros de salida:
* @throws boolean: true, en caso de que el vertice se elimine exitosamente del grafo g; false, en caso contrario
*/
    public boolean eliminarVertice(String id) {

        if (this.estaVertice(id)){
            Vertice eliminar = this.obtenerVertice(id);

            // Debo eliminar los arcos incidentes al vertive eliminar
            // Busco el arco
            for(int i=0;i<arcos.size();i++){
                if(arcos.get(i).getExtremoInicial().getId().equals(eliminar.getId()) || arcos.get(i).getExtremoFinal().getId().equals(eliminar.getId())){
                    this.eliminarArco(arcos.get(i).getId());
                }
            }
            vertices.remove(eliminar);
            return true;
        }
        return false;
    }

/**
* vertices:
* Retorna una lista con los vertices del grafo
* Parametros de entrada:
* @param g: grafo
* Parametros de salida:
* @throws vertices: tipo Lista de Vertice, lista con los vertices contenidos en el grafo
*/
    public List<Vertice> vertices() {
        return vertices;
    }

/**
* lados:
* Retorna una lista con los lados del grafo
* Parametros de entrada:
* @param g: grafo
* Parametros de salida:
* @throws arcos: tipo Lista de Arco, lista con los lados del grafo
*/
    public List<Lado> lados() {
        LinkedList<Lado> lados2 = new LinkedList();
        for (int i=0;i<arcos.size();i++){
            lados2.add(arcos.get(i));
        }
        return lados2;
    }

/**
* grado:
* Calcula el grado del vertice identificado por id en el grafo
* Parametros de entrada:
* @param g: grafo
* @param: id: tipo String, identificador del vertice
* Parametros de salida:
* @throws grado: tipo int, grado del vertice
*/
    public int grado(String id) {
        if(!this.estaVertice(id)){
            throw new NoSuchElementException();
        }
        Vertice vAux = this.obtenerVertice(id);
        int suc = vAux.sucesores.size();
        int pre = vAux.predecesores.size();
        return suc + pre;
    }

/**
* adyacentes:
* Retorna una lista con los vertices adyacentes al vertice con identificador id
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del vertice
* Parametros de salida:
* @throws vAux.sucesores: tipo Lista de Vertice, lista con los vertices adyacentes al vertice id
*/
    public List<Vertice> adyacentes(String id) {
        if(!this.estaVertice(id)){
            throw new NoSuchElementException();
        }
        Vertice vAux = this.obtenerVertice(id);
        return vAux.sucesores;
    }

/**
* incidentes:
* Retorna una lista con los vertices incidentes al vertice con identificador id
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del vertice
* Parametros de salida:
* @throws vAux.predecesores: tipo Lista de Vertice, lista con los vertices incidentes al vertice id
*/ 
    public List<Lado> incidentes(String id) {
        if(!this.estaVertice(id)){
            throw new NoSuchElementException();
        }

        LinkedList<Lado> listaIncidentes = new LinkedList<Lado>();
        for(int i=0; i<nLados; i++){
            if(arcos.get(i).getExtremoFinal().getId().equals(id) || arcos.get(i).getExtremoInicial().getId().equals(id)){
                listaIncidentes.add(arcos.get(i));
            }
        }
        return listaIncidentes;
    }

/**
* clone:
* Retorna un nuevo grafo con la misma composición del grafo de entrada
* Parametros de entrada:
* @param g: grafo
* Parametros de salida:
* @throws : tipo Digrafo, copia del digrafo original
*/
    public Object clone() {
        Digrafo nvoDiGrafo = new Digrafo();
        for (int i=0; i<vertices.size(); i++) {
            nvoDiGrafo.agregarVertice(vertices.get(i));
        }
        for (int j=0; j<arcos.size(); j++) {
            nvoDiGrafo.agregarArco(arcos.get(j));
        }
        
        return nvoDiGrafo;
    }

/**
* toString:
* Devuelve una representacion del contenido del grafo como una cadena de caracteres
* Parametros de entrada:
* @param g: grafo
* Parametros de salida:
* @throws : tipo String, representacion del contenido del grafo en cadena de caracateres
*/
    public String toString() {
        String newLine = "\n";
        String salida = "";
        salida = salida + String.valueOf(vertices.size()) + newLine + String.valueOf(arcos.size()) + newLine;
        // guardar vertices en salida
        for(int i=0; i<vertices.size(); i++){
                salida = salida + vertices.get(i).toString() + newLine;
                }
        // guardar lados en salida
        for(int i=0; i<arcos.size(); i++){
                salida = salida + arcos.get(i).toString() + newLine;
                }
        // guardar salida a archivo
        File archivo = new File("Digrafo.txt");
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(salida);
            bw.close();
        }
        catch(IOException e){
            System.out.println("Hubo un error al crear el archivo");
        }

        return salida;
    }

/**
* estaArco:
* Verifica que el arco con identificador id pertenezca al grafo
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del arco
* Parametros de salida:
* @throws boolean: true, en caso de que el arco pertenezca al grafo; false, en caso contrario
*/
     public boolean estaArco(String id){
        for(int i=0; i<arcos.size(); i++){
            if (arcos.get(i).getId().equals(id)){
                return true;
            }
        }
        return false;
    }

/**
* agregarArco:
* Agrega un nuevo arco con identificador id al grafo
* Parametros de entrada:
* @param g: grafo
* @param a: tipo Arco, arco
* Parametros de salida:
* @throws boolean: true, en caso de que el arco se agregue de manera exitosa al grafo; false, en caso contrario
*/
    public boolean agregarArco(Arco a) {
        Vertice x;
        Vertice y;
        x = a.getExtremoInicial();
        y = a.getExtremoFinal();

        if(arcos.size() == 0){
            //Verificamos si los extremos de el arco estan en la lista de vertices
            if(this.estaVertice(x.getId()) && this.estaVertice(y.getId())){
                arcos.addFirst(a);
                // Agregamos los vertices a la listas
                x.predecesores.add(y);
                y.sucesores.add(x);
                    return true;
            }else{ // Caso en que alguno de los vertices no exista
                System.out.println("ERROR: Uno de los vértices del arco" + a.getId() + "no existe");
                return false;
            }
        }

        //Verificamos si ya existe Arco a
        if(!this.estaArco(a.getId())){
            //Verificamos si los extremos de el arco estan en la lista de vertices
            if(this.estaVertice(x.getId()) && this.estaVertice(y.getId())){
                arcos.add(a);
                // Agregamos los vertices a la listas
                x.predecesores.add(y);
                y.sucesores.add(x);
                return true;
            }else{ // Caso en que alguno de los vertices no exista
                System.out.println("ERROR: Uno de los vértices del arco" + a.getId() + "no existe");
                return false;
            }
        }
        return false;
    } 

/**
* agregarArco:
* Agrega un nuevo arco con identificador id al grafo
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del arco
* @param peso: tipo Double, peso del arco
* @param u: tipo Vertice, vertice extremo inicial del arco
* @param v: tipo Vertice, vertice extremo final del arco
* Parametros de salida:
* @throws boolean: true, en caso de que el arco se agregue de manera exitosa al grafo; false, en caso contrario
*/
    public boolean agregarArco(String id, double peso, String eInicial, String eFinal){
        
        if(arcos.size() == 0){
            //Verificamos si los extremos de el arco estan en la lista de vertices
            if(this.estaVertice(eInicial) && this.estaVertice(eFinal)){
                Vertice vertF = obtenerVertice(eFinal);
                Vertice vertI = obtenerVertice(eInicial);
                Arco a = new Arco(id,peso,vertI,vertF);
                Vertice x = obtenerVertice(eInicial);
                Vertice y = obtenerVertice(eFinal);
                arcos.add(a);
                // Agregamos los vertices a la listas
                x.predecesores.add(y);
                y.sucesores.add(x);
                return true;
            }
        }

        //Verificamos si ya existe Arco con id
        if(!this.estaArco(id)){
            //Verificamos si los extremos de el arco estan en la lista de vertices
            if(this.estaVertice(eInicial) && this.estaVertice(eFinal)){
                Vertice vertF = obtenerVertice(eFinal);
                Vertice vertI = obtenerVertice(eInicial);
                Arco a = new Arco(id,peso,vertI,vertF);
                Vertice x = obtenerVertice(eInicial);
                Vertice y = obtenerVertice(eFinal);
                arcos.add(a);
                // Agregamos los vertices a la listas
                x.predecesores.add(y);
                y.sucesores.add(x);
                return true;
            }
            else{ // Caso en que alguno de los vertices no exista
                System.out.println("ERROR: Uno de los vértices de la arista" + id + "no existe");
                return false;
            }
        }
        return false; 
    }

/**
* gradoInterior:
* Calcula el grado interior del vertice identificado por id
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del vertice
* Parametros de salida:
* @throws tipo int, grado interno del vertice id
*/
    public int gradoInterior(String id) {
        if(!this.estaVertice(id)){
            throw new NoSuchElementException();
        }
        Vertice vAux = this.obtenerVertice(id);
        return vAux.sucesores.size();
    }

/**
* gradoExterior:
* Calcula el grado exterior del vertice identificado por id
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del vertice
* Parametros de salida:
* @throws tipo int, grado externo del vertice id
*/
    public int gradoExterior(String id) {
        if(!this.estaVertice(id)){
            throw new NoSuchElementException();
        }
        Vertice vAux = this.obtenerVertice(id);
        return vAux.predecesores.size();
    }

/**
* sucesores:
* Devuelve una lista con los vertices sucesores del vertice id
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del vertice
* Parametros de salida:
* @throws tipo List de Vertice, vertices sucesores del vertice id
*/
    public List<Vertice> sucesores(String id) {
        if(!this.estaVertice(id)){
            throw new NoSuchElementException();
        }
        Vertice vAux = this.obtenerVertice(id);
        return vAux.sucesores;
    }

/**
* predecesores:
* Devuelve una lista con los vertices predecesores del vertice id
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del vertice
* Parametros de salida:
* @throws tipo List de Vertice, vertices predecesores del vertice id
*/
    public List<Vertice> predecesores(String id) {
        if(!this.estaVertice(id)){
            throw new NoSuchElementException();
        }
        Vertice vAux = this.obtenerVertice(id);
        return vAux.predecesores;
    }

/**
* eliminarArco:
* Elimina el arco con identificador id del grafo
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del arco
* Parametros de salida:
* @throws boolean: true, en caso de que el arco se elimine de manera exitosa al grafo; false, en caso contrario
*/
    public boolean eliminarArco(String id) {

        if(this.estaArco(id)){
            Arco aux = this.obtenerArco(id);
            aux.getExtremoInicial().predecesores.remove(aux.getExtremoFinal());
            aux.getExtremoFinal().sucesores.remove(aux.getExtremoInicial());
            arcos.remove(aux);

            return true;
        }
        return false;
    }

/**
* obtenerArco:
* Devuelve el arco que tiene como identificador id
* Parametros de entrada:
* @param g: grafo
* @param id: tipo String, identificador del arco
* Parametros de salida:
* @throws Arco: objeto tipo Arco, en caso de que el arco exista en el grafo; NoSuchElementException error, en caso contrario
*/
    public Arco obtenerArco(String id) {
        for(int i=0; i<arcos.size(); i++){
            if(arcos.get(i).getId().equals(id)){
                return arcos.get(i);
            }
        }
        throw new NoSuchElementException();
    }  	
}