import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Bubblesort<T extends Comparable<T>> implements IOrdenador<T>{

    private long movimentacoes;
    private long comparacoes;
    private LocalDateTime inicio, fim;


    @Override
    public T[] ordernar(T[] dados) {
        T[] copiaDados = Arrays.copyOf(dados, dados.length);
        int tamanho = copiaDados.length;
        comparacoes = movimentacoes = 0;
        inicio = LocalDateTime.now();
        for (int posRef = tamanho-1; posRef > 0; posRef--){
            for(int posicao = 0; posicao < posRef; posicao++){
                comparacoes++;
                if (copiaDados[posicao].compareTo(copiaDados[posicao+1]) > 0){
                    trocar(posicao, posicao+1, copiaDados);
                } 
            }
        }
        fim = LocalDateTime.now();
        return copiaDados;
    }

    @Override
    public long getComparacoes(){
        return comparacoes;
    }

    @Override
    public long getMovimentacoes() {
        return movimentacoes;
    }

    private void trocar(int pos1, int pos2, T[] dados){
        T temp = dados[pos1];
        dados[pos1] = dados[pos2];
        dados[pos2] = temp;
        movimentacoes+= 3;
    }

    @Override
    public double getTempoOrdenacao() {
        return Duration.between(inicio, fim).toMillis();
    }
}
