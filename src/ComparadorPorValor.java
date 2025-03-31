import java.util.Comparator;

public class ComparadorPorValor implements Comparator <Produto> {

    @Override
    public int compare(Produto p1, Produto p2) {
        int resposta = 0;
        if (p1.valorDeVenda() != p2.valorDeVenda()) 
            resposta = p1.valorDeVenda() > p2.valorDeVenda() ? 1 : -1;

        return resposta;
    }
    
}
