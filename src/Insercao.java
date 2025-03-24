import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Insercao<T extends Comparable<T>> 
    implements IOrdenador<T>
{
    private long movimentacoes;
    private long comparacoes;
    private LocalDateTime inicio, fim;


    @Override
    public T[] ordernar(T[] dados) {
        T[] copiaDados = Arrays.copyOf(dados, dados.length);
        int tamanho = copiaDados.length;
        comparacoes = movimentacoes = 0;
        inicio = LocalDateTime.now();
        for (int posRef = 1; posRef <= tamanho - 1; posRef++){
            T valor = copiaDados[posRef];
            int j = posRef - 1;
            comparacoes++;
            while (j >= 0 && valor.compareTo(copiaDados[j]) < 0) {
                j--;
                comparacoes++;
            }
            copiarDados(j+1, posRef, copiaDados);
            copiaDados[j+1] = valor;
            movimentacoes += 2;
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

    private void copiarDados(int inicio, int fim, T[] vet){
        for (int i = fim; i > inicio; i--) {
            movimentacoes++;
            vet[i] = vet[i-1];
        }
    }

    @Override
    public double getTempoOrdenacao() {
        return Duration.between(inicio, fim).toMillis();
    }
}
