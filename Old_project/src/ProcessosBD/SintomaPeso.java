package ProcessosBD;

public class SintomaPeso {
    private Sintoma sintoma;
    private Doenca doenca;
    private float pesoClinico;
    
    
    public SintomaPeso() {
    }

    public SintomaPeso(Sintoma sintoma, Doenca doenca, float pesoClinico) {
        this.sintoma = sintoma;
        this.doenca = doenca;
        this.pesoClinico = pesoClinico;
    }

    //<editor-fold defaultstate="collapsed" desc="gets/sets">
    public Doenca getCodigoDoenca() {
        return doenca;
    }

    public void setCodigoDoenca(Doenca doenca) {
        this.doenca = doenca;
    }

    public Sintoma getCodigoSintoma() {
        return sintoma;
    }

    public void setCodigoSintoma(Sintoma sintoma) {
        this.sintoma = sintoma;
    }

    public float getPesoClinico() {
        return pesoClinico;
    }

    public void setPesoClinico(float pesoClinico) {
        this.pesoClinico = pesoClinico;
    }

    public Sintoma getSintoma() {
        return sintoma;
    }

    public Doenca getDoenca() {
        return doenca;
    }
    
    
    //</editor-fold>  
     
     @Override
    public String toString() {
        return getClass().toString()+'@'+"[sintoma ="+ sintoma.getCodigo()+" doenca ="+doenca.getCodigo()+" Peso ="+pesoClinico+']';
    }

 

    @Override
    public boolean equals(Object obj) {
        
        if(this.getClass() == obj.getClass()){
            SintomaPeso sintomaPeso = (SintomaPeso) obj;
            boolean sintomasIguais = (this.sintoma.equals(sintomaPeso.getSintoma()));
          
            if(sintomasIguais){ 
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
     
}
