package ProcessosBD;

public class TratamentoCaso {
    
    private Tratamento tratamento;
    private Caso caso;

    public TratamentoCaso() {
    }

    public TratamentoCaso(Tratamento tratamento, Caso caso) {
        this.tratamento = tratamento;
        this.caso = caso;
    }

    public Caso getCaso() {
        return caso;
    }

    public void setCaso(Caso caso) {
        this.caso = caso;
    }

    public Tratamento getTratamento() {
        return tratamento;
    }

    public void setTratamento(Tratamento tratamento) {
        this.tratamento = tratamento;
    }
               
}
