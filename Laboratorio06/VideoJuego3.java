    import java.util.ArrayList;
    public class VideoJuego3
    {
        public static void main (String [] args)
        {
            Soldado [] tableroUni;
            Soldado [][] tablero = new Soldado [10][10];
            
            // LABORATORIO 06 - LISTA DE LOS NUEVOS METODOS
            ArrayList<ArrayList<Soldado>> table = new ArrayList <ArrayList<Soldado>>();
            inicializarVacio(table);
            
                // Los ejercitos se ubicaran al final como numero, 1 y 2
                tableroUni = crear (table, 1);
                tableroUni = crear (table, 1);
                
            // Arreglos bidimensionales
            tableroUni = crear  (tablero);
            mostrarTabla        (tablero);
            mostrarMayorVida    (tablero);
            
            
            
            double vida = mostrarPromedioVida (tablero);
            
            // MOSTRAR VIDA DE TODOS LOS SOLDADOS
            System.out.println ("\n| VIDA TOTAL DEL EJERCITO |");
            System.out.println ("La vida total es: " + vida );

            // Arreglos estandar
            System.out.println("\n| SOLDADOS - ORDEN DE CREACION |");
            mostrar (tableroUni);
            
            System.out.println("\n| SOLDADOS - RANKING DE VIDA MAYOR A MENOR |");
            mostrarRankingMayor (tableroUni);
            
            System.out.println("\n| SOLDADOS - RANKING DE VIDA MENOR A MAYOR |");
            mostrarRankingMenor (tableroUni);
           
        }
        
        public static int posicionRandom ()
        {
            return (int) (Math.random() * 10);
        }

        public static int vida ()
        {
            return (int) (Math.random() * 5 + 1);
        }
        
        public static Soldado [] crear (ArrayList< ArrayList<Soldado> > tablero, int ejercito)
        {
            int aleatorio = posicionRandom()+1, fila, columna;
            ArrayList <Soldado> tableroUni = new ArrayList <Soldado>();
            
            for (int i = 0 ; i < aleatorio ; i++)
            {
                // VERIFICA POSICION LIBRE
                do
                {
                    fila    = posicionRandom();
                    columna = posicionRandom();
                }
                while ( tablero.get(fila).get(columna).getNombre() != "" );
                
                // INICIALIZA DATOS DEL SOLDADO
                inicializar (tablero, fila, columna, i, ejercito);

                // ARREGLO ESTANDAR PARA TRABAJAR CON ORDENAMIENTO
                tableroUni.add( new Soldado () );
                tableroUni.get(i) = tablero.get(fila).get(columna);
            }
            return tableroUni;
        }
       
        public static void inicializarVacio (ArrayList< ArrayList<Soldado> > tablero)
        {
           for (int i = 0 ; i < 10 ; i++)
            {
                for (int j = 0 ; j < 10 ; j++)
                  tablero.get(i).add( new Soldado () );
            }
        }
        
        public static void inicializar (ArrayList< ArrayList<Soldado> > t, int f, int c, int cont, int e)
        {
            String columnaLetras [] = {"A","B","C","D","E","F","G","H","I","J"};
             
            t.get(f).get(c).setNombre ("Soldado"+cont+"X"+e);
            t.get(f).get(c).setVida   ( vida() );
            t.get(f).get(c).setFila   (f+1);
            t.get(f).get(c).setColumna(columnaLetras[c]);
        }
        
        
        
        
       
        public static Soldado [] crear (Soldado [][] tablero)
        {
            int aleatorio = posicionRandom()+1, fila, columna;
            Soldado [] tableroUni = new Soldado[aleatorio];
            
            for (int i = 0 ; i < aleatorio ; i++)
            {
            // VERIFICA POSICION LIBRE
                do
                {
                    fila    = posicionRandom();
                    columna = posicionRandom();
                }
                while ( tablero[fila][columna] != null );
            
            // CREA E INICIALIZA DATOS DEL SOLDADO
            tablero[fila][columna] = new Soldado();
            inicializar (tablero, fila, columna, i);
            
            // ARREGLO ESTANDAR PARA TRABAJAR CON ORDENAMIENTO
            tableroUni[i] = new Soldado ();
            tableroUni[i] = tablero[fila][columna];
            }
            return tableroUni;
        }
        
        public static void inicializar (Soldado [][] tablero, int f, int c, int cont)
        {
            String columnaLetras [] = {"A","B","C","D","E","F","G","H","I","J"};
             
            tablero[f][c].setNombre ("Soldado"+cont);
            tablero[f][c].setVida   ( vida() );
            tablero[f][c].setFila   (f+1);
            tablero[f][c].setColumna(columnaLetras[c]);
        }
        
        public static void mostrarTabla (Soldado [][] tablero)
        {
            String letras [] = {"A","B","C","D","E","F","G","H","I","J"};
            System.out.print ("     ");
            
            // MUESTRA LAS COLUMNAS
            for (int i = 0 ; i < letras.length ; i++)
            {
                System.out.print (letras[i]+"          ");
            }
            System.out.println(" ");
            
            for (int i = 0 ; i < tablero.length ; i++)
            {
            	// MUESTRA LAS FILAS
                System.out.print (i+1);
                for (int j = 0 ; j < tablero[i].length ; j++)
                {
                	// SI NO EXISTE SOLDADO, MUESTRA UN ESPACIO EN BLANCO
                    if (tablero[i][j] == null)
                        System.out.print ("          |");
                    else
                        System.out.print (" "+tablero[i][j].getNombre()+" |");
                }
                System.out.println("\n-------------------------------------------------"
                	  + "-------------------------------------------------------------");
            }
        }
        
        // Uso de metodos con el arreglo bidimensional para la demostracion de conocimiento en este mismo.
        
        public static void mostrarMayorVida (Soldado[][]tablero)
        {
            int fila = 0, columna = 0;
            
            // LOS MAYORES VALORES INICIALES
            for (int i = 0 ; i < tablero.length ; i++) {
                for (int j = 0 ; j < tablero[i].length ; j++)
                {
                        if ( !(tablero[i][j] == null) )
                        { fila = i; columna = j; break; }
                }
            }
           
           // BUSQUEDA DEL SOLDADO CON MAYOR VIDA 
           for (int i = 0 ; i < tablero.length ; i++)
           {
                for (int j = 0 ; j < tablero[i].length ; j++){
                    if ( !(tablero[i][j] == null) ) {
                        if ( tablero[fila][columna].getVida() < tablero[i][j].getVida() )
                        {
                            fila = i;
                            columna = j;
                        }
                    }        
                }
            }
            
            // MOSTRAR
            System.out.println ("\n\t| SOLDADO CON MAYOR VIDA |\n");
            System.out.println (tablero[fila][columna]+"\n");
        }
        
        public static double mostrarPromedioVida (Soldado[][] tablero)
        {
           double suma = 0, cont = 0;
           
           // PROMEDIO DE VIDA
           for (int i = 0 ; i < tablero.length ; i++)
           {
                for (int j = 0 ; j < tablero[i].length ; j++){
                    if ( !(tablero[i][j] == null) )
                    {
                         suma += tablero[i][j].getVida();
                         cont++;
                    }       
                }
           }
           
            // MOSTRAR
            System.out.println ("\n| PROMEDIO DE VIDA |");
            System.out.println ("El promedio de vida es: " + (suma/cont) );
            
            return suma;
        }
        
        // Desde ahora, metodos con arreglo estandar para trabajar el ordenamiento o metodos que lo requieran.
        
        public static void mostrarRankingMayor (Soldado [] tablero)
        { 
        	Soldado intercambio;
        	
        	// Algoritmo de ordenamiento Insercion
    		for (int i = 1 ; i < tablero.length ; i++)
    		{
    			for (int r = i ; r > 0 && tablero[r-1].getVida() < tablero[r].getVida() ; r--)
    			{
    				intercambio   = tablero [r-1];
    				tablero [r-1] = tablero   [r];
    				tablero   [r] = intercambio;
    			}
    		}
    		
    		mostrar (tablero);
        }
        
        public static void mostrarRankingMenor (Soldado [] tablero)
        {
            Soldado intercambio;
            
            // Algoritmo de ordenamiento Burbuja
            for (int i = tablero.length - 1 ; i > 0 ; i--)
                for (int n = 0 ; n < i ; n++)
                {
                    if ( tablero[n].getVida() > tablero[n+1].getVida() )
                    {
                        intercambio  = tablero[n];
                        tablero[n]   = tablero[n+1];
                        tablero[n+1] = intercambio;
                    }
                }
            
            mostrar(tablero);
        }
        
        public static void mostrar (Soldado [] tablero)
	    {
            for (int i = 0 ; i < tablero.length ; i++)
                System.out.println("\t| SOLDADO N-"+(i+1)+" |\n"+tablero[i]+"\n");
	    }
  
    }