public interface IOrdenador <T extends Comparable<T>>{
    public T[] ordernar(T[] dados);
    public long getComparacoes();
    public long getMovimentacoes();
    public double getTempoOrdenacao(); 
}
