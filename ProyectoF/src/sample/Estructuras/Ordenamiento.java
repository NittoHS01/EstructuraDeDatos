package sample.Estructuras;

public class Ordenamiento {
    public static Inventario[] burbujaCodigo(Inventario[] arreglo) {
        Inventario auxiliar;
        Inventario[] arregloOrdenado;
        for(int i = 1; i < arreglo.length; i++) {
            for(int j = 0;j < arreglo.length-i;j++) {
                if(arreglo[j].getCodigo() > arreglo[j+1].getCodigo()) {
                    auxiliar = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1]= auxiliar;
                }
            }
        }
        arregloOrdenado = arreglo;
        return arregloOrdenado;
    }

    public static Inventario[] burbujaPrecio(Inventario[] arreglo) {
        Inventario auxiliar;
        Inventario[] arregloOrdenado;
        for(int i = 1; i < arreglo.length; i++) {
            for(int j = 0;j < arreglo.length-i;j++) {
                if(arreglo[j].getPrecio() > arreglo[j+1].getPrecio()) {
                    auxiliar = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1]= auxiliar;
                }
            }
        }
        arregloOrdenado = arreglo;
        return arregloOrdenado;
    }

    public static Inventario[] ShellSortStoke(Inventario[] arreglo){
        int salto;
        Inventario aux;
        int i;
        boolean cambios;

        for (salto = arreglo.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {   // Mientras se intercambie algún elemento
                cambios = false;
                for (i = salto; i < arreglo.length; i++)   // se da una pasada
                {
                    if (arreglo[i - salto].getUnidades() > arreglo[i].getUnidades()) {       // y si están desordenados
                        aux = arreglo[i];                  // se reordenan
                        arreglo[i] = arreglo[i - salto];
                        arreglo[i - salto] = aux;
                        cambios = true;              // y se marca como cambio.
                    }
                }
            }
        }
        return arreglo;
    }
}
