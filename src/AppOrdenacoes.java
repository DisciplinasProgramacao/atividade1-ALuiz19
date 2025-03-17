import java.util.Random;

public class AppOrdenacoes {
    /**
     * Gerador de vetores aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static Integer[] gerarVetor(int tamanho){
        Integer[] vetor = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho/2);
        }
        return vetor;
    }
    static Random aleatorio = new Random(42);

    
    public static void main(String[] args){
        Integer[] vetor = gerarVetor(100_000);
        Bubblesort<Integer> ordernador = new Bubblesort<Integer>();
        Integer[] vetorOrdenado = ordernador.ordernar(vetor);

        System.out.println(vetor.length);
        System.out.println(ordernador.getComparacoes());
        System.out.println(ordernador.getMovimentacoes());
        System.out.println(ordernador.getTempoOrdenacao());

    }
}
