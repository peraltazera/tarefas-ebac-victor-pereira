import java.util.Arrays;

public class Fila {

    private int[] numeros;

    public Fila() {
        this.numeros = new int[0];
    }

    public void enqueue(int num){
        numeros = Arrays.copyOf(numeros, numeros.length + 1); //O(n)
        numeros[numeros.length-1] = num; //O(1)
    }

    public void dequeue() {
        int[] arrayOriginal = numeros; //O(1)
        int[] novoArray = new int[arrayOriginal.length - 1]; //O(1)
        System.arraycopy(arrayOriginal, 1, novoArray, 0, novoArray.length); //O(n)
        numeros = novoArray; //O(1)
    }

    public int rear() {
        return numeros[numeros.length - 1]; //O(1)
    }

    public int front() {
        return numeros[0]; //O(1)
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
