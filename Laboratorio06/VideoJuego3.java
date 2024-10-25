    
    import java.util.ArrayList;
    public class VideoJuego3
    {
        public static void main (String [] args)
        {
            ArrayList <Soldado> ejercito1 = new ArrayList <Soldado>();
            ArrayList <Soldado> ejercito2 = new ArrayList <Soldado>();
            
            // LABORATORIO 06 - LISTA DE LOS NUEVOS METODOS
            ArrayList<ArrayList<Soldado>> tablero = new ArrayList <ArrayList<Soldado>>();
            inicializarVacio(tablero);
            
            // NOTA IMPORTANTE: Los ejercitos se ubicaran al final como STRINGS, 1 y 2
            crear (tablero, ejercito1, "1");
            crear (tablero, ejercito2, "2");
            mostrarTabla        (tablero);
            
            // Los de mayor vida segun ejercito
            mostrarMayorVida    (tablero, "1");
            mostrarMayorVida    (tablero, "2");
            
            // Vida promedio
            double vida1 = mostrarPromedioVida (tablero, "1");
            double vida2 = mostrarPromedioVida (tablero, "2");
            
            // MOSTRAR VIDA DE TODOS LOS SOLDADOS
            System.out.println ("\n| VIDA TOTAL DEL EJERCITO 1 |");
            System.out.println ("La vida total es: " + vida1 );
            
            System.out.println ("\n| VIDA TOTAL DEL EJERCITO 2 |");
            System.out.println ("La vida total es: " + vida2 );

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
            if (vida1 > vida2)
                System.out.println("\n| EJERCITO 1 - GANADOR POR MAYOR VIDA DEL EJERCITO |");
            else
                System.out.println("\n| EJERCITO 2 - GANADOR POR MAYOR VIDA DEL EJERCITO |");
        }
        
        public static int posicionRandom ()
        {
            return (int) (Math.random() * 10);
        }

        public static int vida ()
        {
            return (int) (Math.random() * 5 + 1);
        }
        
        public static void crear (ArrayList< ArrayList<Soldado> > tablero, ArrayList<Soldado> ejercito, String e)
        {
            int aleatorio = posicionRandom()+1, fila, columna;
            
            for (int i = 0 ; i < aleatorio ; i++)
            {
                // VERIFICA POSICION LIBRE
                do
                {
                    fila    = posicionRandom();
                    columna = posicionRandom();
                }
                while ( tablero.get(fila).get(columna).getNombre().equals("") );
                
                // INICIALIZA DATOS DEL SOLDADO
                inicializar (tablero, fila, columna, i, e);

                // ARREGLO ESTANDAR PARA TRABAJAR CON ORDENAMIENTO
                ejercito.add( tablero.get(fila).get(columna) );
            }
        }
       
        public static void inicializarVacio (ArrayList< ArrayList<Soldado> > tablero)
        {
           for (int i = 0 ; i < 10 ; i++)
            {
                tablero.add( new ArrayList<Soldado>() );
                for (int j = 0 ; j < 10 ; j++)
                {
                  tablero.get(i).add( new Soldado() );
                }
            }
        }
        
        public static void inicializar (ArrayList< ArrayList<Soldado> > t, int f, int c, int cont, String e)
        {
            String columnaLetras [] = {"A","B","C","D","E","F","G","H","I","J"};
             
            t.get(f).get(c).setNombre ("Soldado"+cont+"X"+e);
            t.get(f).get(c).setVida   ( vida() );
            t.get(f).get(c).setFila   (f+1);
            t.get(f).get(c).setColumna(columnaLetras[c]);
            t.get(f).get(c).setEjercito(e);
        }
        
        public static void mostrarTabla (ArrayList< ArrayList<Soldado> > tablero)
        {
            String letras [] = {"A","B","C","D","E","F","G","H","I","J"};
            System.out.print ("     ");
            
            // MUESTRA LAS COLUMNAS
            for (int i = 0 ; i < letras.length ; i++)
            {
                System.out.print (letras[i]+"            ");
            }
            System.out.println(" ");
            
            for (int i = 0 ; i < tablero.size() ; i++)
            {
            	// MUESTRA LAS FILAS
                System.out.print (i+1);
                for (Soldado soldado : tablero.get(i) )
                {
                        System.out.print (" "+soldado.getNombre()+" |");
                }
                System.out.println("\n-----------------------------------------------------------------"
                	          +"------------------------------------------------------------------");
            }
        }
        
        // Uso de metodos con el arreglo bidimensional para la demostracion de conocimiento en este mismo.
        
        public static void mostrarMayorVida (ArrayList< ArrayList<Soldado> > tablero, String e)
        {
            int fila = 0, columna = 0;
            
            // LOS MAYORES VALORES INICIALES
            for (int i = 0 ; i < tablero.size() ; i++) {
                for (int j = 0 ; j < tablero.get(i).size() ; j++)
                {
                        if ( !(tablero.get(i).get(j).getNombre().equals("          ")) &&
                               tablero.get(i).get(j).getEjercito().equals(e)             )
                        { fila = i; columna = j; break; }
                }
            }
           
           // BUSQUEDA DEL SOLDADO CON MAYOR VIDA 
           for (int i = 0 ; i < tablero.size() ; i++)
           {
                for (int j = 0 ; j < tablero.get(i).size() ; j++){
                    if (  !(tablero.get(i).get(j).getNombre().equals("          ")) &&
                            tablero.get(i).get(j).getEjercito().equals(e)            )
                    {
                        if ( tablero.get(fila).get(columna).getVida() < tablero.get(i).get(j).getVida() )
                        {
                            fila = i;
                            columna = j;
                        }
                    }        
                }
            }
            
            // MOSTRAR
            System.out.println ("\n\t| SOLDADO CON MAYOR VIDA |\n");
            System.out.println (tablero.get(fila).get(columna)+"\n");
        }
        
        public static double mostrarPromedioVida (ArrayList< ArrayList<Soldado> > tablero, String e)
        {
           double suma = 0, cont = 0;
           
           // PROMEDIO DE VIDA
           for (int i = 0 ; i < tablero.size() ; i++)
           {
                for (int j = 0 ; j < tablero.get(i).size() ; j++)
                {
                   if (  !(tablero.get(i).get(j).getNombre().equals("          ")) &&
                           tablero.get(i).get(j).getEjercito().equals(e)             )
                    {
                         suma += tablero.get(i).get(j).getVida();
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
  
    }