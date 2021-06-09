package algoritmos.impl;

import algoritmos.Habilitado;
import algoritmos.Ordenador;

@Habilitado
public class BubbleSort extends Ordenador {


    public BubbleSort(boolean impressao) {
        super(impressao);
    }

    protected int[] executarAlgoritmoSort(int[] array) {
        int n = array.length;
        int temp = 0;

        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                int x = array[j - 1];
                int y = array[j];

                if(x > y){
                    temp = x;
                    array[j-1] = y;
                    array[j] = temp;
                }
            }
        }

        return array;
    }
}
