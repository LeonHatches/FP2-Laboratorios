
    public class Soldado
    {
        private String  nombre, columna, ejercito;
        private int     vida, fila;

        public void setNombre (String n) {
                nombre = n;
        }
        public void setVida (int v) {
                vida = v;
        }
        public void setFila (int f) {
                fila = f;
        }
        public void setColumna (String c) {
                columna = c;
        }
        public void setEjercito (String e) {
            ejercito = e;
        }

        public String getNombre ()
        {	return nombre;	}

        public int getVida ()
        {	return vida;	}

        public int getFila ()
        {	return fila;	}

        public String getColumna ()
        {	return columna;	}
        
        public String getEjercito ()
        {       return ejercito;    }
            
        public String toString ()
        {
            return    "NOMBRE:\t\t" +nombre +"\n"
                    + "FILA:\t\t"   +fila   +"\n"
                    + "COLUMNA:\t"  +columna+"\n"
                    + "VIDA:\t\t"   +vida;
        }
    }
    
