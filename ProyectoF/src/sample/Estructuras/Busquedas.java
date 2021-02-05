package sample.Estructuras;

public class Busquedas {
    public int secuencial(String[][] array, String dato1, String dato2){
        int indice = -1;
        for(int i=0; i<array.length; i++){
            if (array[i][1].equals(dato1) && array[i][2].equals(dato2)){
                indice = i;
                return indice;
            }
        }
        return indice;
    }
    public int binario(Inventario[] array, int numB){
        int num_buscado=numB;
        int pocision=0;
        int inferior = 0;
        int centro;
        int superior = array.length - 1;
        while (inferior<=superior){
            centro = (superior + inferior)/2;
            if (array[centro].getCodigo() == num_buscado) {
                pocision = centro+1;
                System.out.println("El codigo buscado esta en la posicion " + pocision + " de la tabla");
                break;
            }else if(num_buscado < array[centro].getCodigo()){
                superior = centro -1;
            }else {
                inferior = centro + 1;
            }
        }
        return pocision;
    }
}