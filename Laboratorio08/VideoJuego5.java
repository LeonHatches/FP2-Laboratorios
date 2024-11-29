    
    // LABORATORIO 08 - HASHMAPS

    import java.util.*;
    public class VideoJuego5
    {
        public static void main (String [] args)
        {
        	int decision = 1;
        	
        	do
        	{
	            HashMap <String, Soldado> ejercito1 = new HashMap <String, Soldado>();
	            HashMap <String, Soldado> ejercito2 = new HashMap <String, Soldado>();
	            Soldado [][]                 tablero = new Soldado [10][10];
	            
	            // NOTA IMPORTANTE: Los ejercitos se ubicaran al final como STRINGS, 1 y 2 | Luego la vida (HP)
	            ejercito1 = crear (tablero, "1");
	            ejercito2 = crear (tablero, "2");
	            mostrarTabla      (tablero);
	            
	            // Mostrar los de mayor vida segun el ejercito
	            mostrarMayorVida (ejercito1, "1");
	            mostrarMayorVida (ejercito2, "2");

	            // Vida promedio de cada ejercito con HashMap
	            double vida1 = mostrarPromedioVida (ejercito1, "1");
	            double vida2 = mostrarPromedioVida (ejercito2, "2");
	            
	            // MOSTRAR VIDA DE TODOS LOS SOLDADOS
	            System.out.println ("\n| VIDA TOTAL DEL EJERCITO 1 |");
	            System.out.println ("La vida total es: " + vida1 );
	            
	            System.out.println ("\n| VIDA TOTAL DEL EJERCITO 2 |");
	            System.out.println ("La vida total es: " + vida2 );
	            
	            /*
	            // ArrayList estandar para ordenamientos
	            System.out.println("\n| SOLDADOS - EJERCITO 1 - ORDEN DE CREACION |");
	            mostrar (ejercito1);
	            
	            System.out.println("\n| SOLDADOS - EJERCITO 2 - ORDEN DE CREACION |");
	            mostrar (ejercito2);
	            
	            // RANKING DEL EJERCITO 1
	            System.out.println("\n| SOLDADOS - EJERCITO 1 - RANKING DE VIDA MAYOR A MENOR |");
	            mostrarRankingMayor (ejercito1);
	            System.out.println("\n| SOLDADOS - EJERCITO 1 - RANKING DE VIDA MENOR A MAYOR |");
	            mostrarRankingMenor (ejercito1);
	            
	            // RANKING DEL EJERCITO 2
	            System.out.println("\n| SOLDADOS - EJERCITO 2 - RANKING DE VIDA MAYOR A MENOR |");
	            mostrarRankingMayor (ejercito2);
	            System.out.println("\n| SOLDADOS - EJERCITO 2 - RANKING DE VIDA MENOR A MAYOR |");
	            mostrarRankingMenor (ejercito2);
	            
	            // GANADOR
	            if (vida1 == vida2)
	            	System.out.println("\n| EMPATE POR VIDA DEL EJERCITO IGUALES |");
	            
	            else if (vida1 > vida2)
	            	System.out.println("\n| EJERCITO 1 - GANADOR POR MAYOR VIDA DEL EJERCITO |");
	            
	            else
	                System.out.println("\n| EJERCITO 2 - GANADOR POR MAYOR VIDA DEL EJERCITO |");
	            */
	            decision = iteracion();
        	} 
            while (decision == 1);
        }
        

        public static int iteracion ()
        {
        	Scanner sc = new Scanner (System.in);
        	System.out.print ("\n¿Desea otra batalla? | Si: 1 | No: 0 |: ");
        	return sc.nextInt();
        }
        	
        public static int posicionRandom () {
            return (int) (Math.random() * 10);
        }

        public static int vida () {
            return (int) (Math.random() * 5 + 1);
        }
        
        public static HashMap <String, Soldado> crear (Soldado [][] tablero, String e)
        {
            int                       aleatorio = posicionRandom()+1, fila, columna;
            HashMap <String, Soldado>  ejercito = new HashMap <String, Soldado>();
            
            for (int i = 0 ; i < aleatorio ; i++)
            {
                // VERIFICA POSICION LIBRE
                    do
                    {
                        fila	= posicionRandom();
                        columna = posicionRandom();
                    }
                    while ( tablero[fila][columna] != null );

                // CREA E INICIALIZA DATOS DEL SOLDADO
                tablero[fila][columna] = new Soldado();
                inicializar (tablero, fila, columna, i, e);

                // HASHMAP PARA TRABAJAR CON ORDENAMIENTO
            	ejercito.put(tablero[fila][columna].getNombre(), tablero[fila][columna]);
            }
            return ejercito;
        }
        
        public static void inicializar (Soldado [][] tablero, int f, int c, int cont, String e)
        {
            String columnaLetras [] = {"A","B","C","D","E","F","G","H","I","J"};
             
            tablero[f][c].setNombre  ("Soldado"+cont+"X"+e);
            tablero[f][c].setVida    ( vida() );
            tablero[f][c].setFila    (f+1);
            tablero[f][c].setColumna (columnaLetras[c]);
        }
        
        
        public static void mostrarTabla (Soldado [][] tablero)
        {
            String letras [] = {"A","B","C","D","E","F","G","H","I","J"};
            System.out.print ("\n\n          ");
            
            // MUESTRA LAS COLUMNAS
	            for (int i = 0 ; i < letras.length ; i++)
	            {
	                System.out.print (letras[i]+"                  ");
	            }
	            System.out.println(" ");
            
	            
            for (int i = 0 ; i < tablero.length ; i++)
            {
            	// MUESTRA LAS FILAS
	                System.out.print (i+1);
	                for (int j = 0 ; j < tablero[i].length ; j++)
	                {
	                    if (tablero[i][j] != null)
	                        System.out.print (" "+tablero[i][j].getNombre()+" HP: "+tablero[i][j].getVida()+" |");
	                    
	                    else
	                        System.out.print ("                  |");
	                }
                
	                
                // MUSTRA LAS LINEAS HORIZONTALES
	                System.out.println();
	                
	                for (int n = 0 ; n < 191 ; n++)
	                    System.out.print("-");
	                
	                System.out.println();
            }
        }
        
        // Uso de HASHMAP para la demostracion de conocimiento
        public static void mostrarMayorVida (HashMap <String, Soldado> ejercito, String e)
        {
        	String keyMayor = "Soldado0X"+e;
        	
        	for  (String key : ejercito.keySet() )
        	{
        		if ( ejercito.get(keyMayor).getVida() < ejercito.get(key).getVida() )
        			keyMayor = key;
        	}
        	
        	// MOSTRAR
            System.out.println ("\n\t| SOLDADO CON MAYOR VIDA DEL EJERCITO "+e+" |\n");
            System.out.println (ejercito.get(keyMayor)+"\n");
        }
        
        public static double mostrarPromedioVida (HashMap <String, Soldado> ejercito, String e)
        {
        	double suma = 0;
            
            // PROMEDIO DE VIDA
        	for  (String key : ejercito.keySet() )
        		suma += ejercito.get(key).getVida();
        	
			// MOSTRAR
			System.out.println ("\n| PROMEDIO DE VIDA DEL EJERCITO "+e+" |");
			System.out.println ("El promedio de vida es: " + ( suma/ejercito.size() ));
			
			return suma;
        }
        
        /*
        // Desde ahora, metodos con ArrayList estandar para trabajar el ordenamiento o metodos que lo requieran.
        public static void mostrarRankingMayor (ArrayList<Soldado> ejercito)
        { 
        	Soldado intercambio;
        	
        	// Algoritmo de ordenamiento Insercion
    		for (int i = 1 ; i < ejercito.size() ; i++)
    		{
    			for (int r = i ; r > 0 && ejercito.get(r-1).getVida() < ejercito.get(r).getVida() ; r--)
    			{
                            intercambio = ejercito.remove(r-1);
                            ejercito.add(r, intercambio);
    			}
    		}
    		
    		mostrar (ejercito);
        }
        
        public static void mostrarRankingMenor (ArrayList<Soldado> ejercito)
        {
            Soldado intercambio;
            
            // Algoritmo de ordenamiento Burbuja
            for (int i = ejercito.size() - 1 ; i > 0 ; i--)
                for (int n = 0 ; n < i ; n++)
                {
                    if ( ejercito.get(n).getVida() > ejercito.get(n+1).getVida() )
                    {
                        intercambio = ejercito.remove(n);
                        ejercito.add(n+1, intercambio);
                    }
                }
            
            mostrar(ejercito);
        }
        
        public static void mostrar (ArrayList<Soldado> ejercito)
	    {
            for (int i = 0 ; i < ejercito.size() ; i++)
                System.out.println("\t| SOLDADO N-"+(i+1)+" |\n"+ejercito.get(i)+"\n");
        }   
    */
    }