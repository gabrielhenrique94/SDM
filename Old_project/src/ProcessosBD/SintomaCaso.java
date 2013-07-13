package ProcessosBD;

public class SintomaCaso {
    private Sintoma sintoma;
    private Caso caso;

    public SintomaCaso() {
    }

    public SintomaCaso(Sintoma sintoma, Caso caso) {
        this.sintoma = sintoma;
        this.caso = caso;
    }

    public Caso getCaso() {
        return caso;
    }

    public void setCaso(Caso caso) {
        this.caso = caso;
    }

    public Sintoma getSintoma() {
        return sintoma;
    }

    public void setSintoma(Sintoma sintoma) {
        this.sintoma = sintoma;
    }   
    
}
