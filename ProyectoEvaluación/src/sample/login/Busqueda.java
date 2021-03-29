package sample.login;

public class Busqueda {
    public int secuencial(String[][] array, String dato1, String dato2){
        int i=-1;
            for (int x=0;x<array.length;x++){
                if(array[x][1].equals(dato1) && array[x][2].equals(dato2)){
                    i=x;
                    return i;
                }
            }
            return i;
    }
}
