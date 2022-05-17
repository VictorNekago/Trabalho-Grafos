package aaaa;
import java.util.*;

public class grafos2 {

	 static Scanner sc = new Scanner(System.in);

	  static int informacaoGrafo[] = new int[2];
	  static int Grafo[][] = new int[1][1];
	  static String verticesDesejados = "";
	  static int numVertices = 0;
	  static int tipoGrafo = 0;
	 

	  public static void ImprimeGrafoMatriz(int g[][]) {
	    for (int i = 0; i < g.length; i++) {
	      System.out.print(i + "-");
	      for (int j = 0; j < g[i].length; j++) {

	        System.out.printf("%4d ", g[i][j]);
	      }
	      System.out.printf("\n");
	    }
	  }

	  public static boolean CaracteristicasGrafo() {
		  

		  	System.out.println("+-------------------------------------------------------+");
	        System.out.println("+------------------Escolha uma Opção--------------------+");
	        System.out.println("+-------------------------------------------------------+");
	        System.out.println("+--------1)Grafo direcionado não-ponderado--------------+");
	        System.out.println("+--------2)Grafo não-direcionado não-ponderado----------+");
	        System.out.println("+--------3)Grafo direcionado ponderado------------------+");
	        System.out.println("+--------4)Grafo não-direcionado ponderado--------------+");
			System.out.println("+-------------------------------------------------------+");
	    tipoGrafo = sc.nextInt();

	    System.out.print("Informe a quantidade de vértices: ");
	    numVertices = sc.nextInt();

	    sc.nextLine();
	    
	    System.out.print("Em quais vértices deseja aresta? ");
	    verticesDesejados = sc.nextLine();
	    
	   
	    
	    //
	    //
	    //
	    //IMPLEMENTAR LOOP
	    // MELHORAR INTERFACE COM USUARIO
	    // TESTAR CÒDIGO
	    // VERIFICAR A POSSIBILIDADE DE GERAR GRAFOS ALEATORIOS
	    //
	    //
	    //
	    // ARRUMAR ESTE METODO, "PUXAR INDICE" PARA NUMEROS MAIORES DE 1 DIGITO

	    
	  //  for (int i = verticesDesejados.length() - 1; i >= 0; i--) {

	    //  int aux = Character.getNumericValue(verticesDesejados.charAt(i));

	    //  if (aux > numVertices) {
	      //  System.out.printf("o Vértice " + aux + " não existe.\n");
	      //  return false;
	    //  }
	  //  }
	    return true;

	  }

	  public static void insereArestaNaoPonderadoNaoDirecionado(int g[][], int origem, int destino) {
	    g[origem][destino] = 1;
	    g[destino][origem] = 1;
	  }

	  public static void insereArestaPonderadoNaoDirecionado(int g[][], int origem, int destino, int peso) {
	    g[origem][destino] = peso;
	    g[destino][origem] = peso;
	  }

	  public static void insereArestaNaoPonderadoDirecionado(int g[][], int origem, int destino) {
	    g[origem][destino] = 1;
	  }

	  public static void insereArestaPonderadoDirecionado(int g[][], int origem, int destino, int peso) {
	    g[origem][destino] = peso;
	  }

	  public static int retornaOrigem(String auxSplit[], int i) {

	    String auxNum = auxSplit[i].toString();
	    String auxNum2 = auxNum.substring(0, auxNum.length() / 2);
	    int origem = Integer.parseInt(auxNum2);
	    return origem;
	  }

	  public static int retornaDestino(String auxSplit[], int i) {

	    String auxNum = auxSplit[i].toString();
	    String auxNum2 = auxNum.substring(auxNum.length() / 2, auxNum.length());
	    int destino = Integer.parseInt(auxNum2);

	    return destino;
	  }

	  public static void main(String[] args) {
		  int x=0;
		  
		  while (x<10) {
		  

	    boolean caracteristicasCorretas = CaracteristicasGrafo();

	     Grafo = new int[numVertices][numVertices];

	    try {
	      if (caracteristicasCorretas) {
	        String auxSplit[] = verticesDesejados.split(" ");
	        System.out.println("valor de tipo grafo"+tipoGrafo);

	        for (int i = 0; i < auxSplit.length; i++) {

	          int origem = retornaOrigem(auxSplit, i);
	          int destino = retornaDestino(auxSplit, i);

	          if (tipoGrafo == 1) {
	            insereArestaNaoPonderadoDirecionado(Grafo, origem, destino);

	          } else if (tipoGrafo == 2) {
	            insereArestaNaoPonderadoNaoDirecionado(Grafo, origem, destino);
	          }
	          else if (tipoGrafo == 3) {
	            System.out.printf("\nInforme o peso na aresta: [%d->%d]: ", origem, destino);
	            int peso = sc.nextInt();
	            insereArestaPonderadoDirecionado(Grafo, origem, destino, peso);
	          } 
	          else if (tipoGrafo == 4) {
	            System.out.printf("\nInforme o peso na aresta: [%d-%d]: ", origem, destino);
	            int peso = sc.nextInt();
		          insereArestaPonderadoNaoDirecionado(Grafo, origem, destino, peso);
	          }
	          
	       
	        }

	        ImprimeGrafoMatriz(Grafo);
	      } else {

	      }
	    } catch (IndexOutOfBoundsException e) {
	      System.out.println("Erro ao buscar índice na matriz de adjacência.");
	      System.out.println(e);
	    }
	  }
	  }
}
