import java.util.Arrays;

public class Pilha {

    private int[] numeros;

    public Pilha() {
        this.numeros = new int[0];
    }

    public void push(int num){
        numeros = Arrays.copyOf(numeros, numeros.length + 1);  //O(n)
        numeros[numeros.length-1] = num; //O(1)
    }

    public void pop() {
        numeros = Arrays.copyOf(numeros, numeros.length - 1); //O(n)
    }

    public int top() {
       return numeros[numeros.length - 1];
    }

    public boolean isEmpty() {
        return numeros.length == 0;
    }

    public int size() {
        return numeros.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(numeros);
    }
}
