package ProcessosBD;

public class FichaMedica {
    private int codigo;
    private String sexo;
    private String tipoSang;
    
    public FichaMedica() {
    }

    public FichaMedica(int codigo, String sexo, String tipoSang) {
        this.codigo = codigo;
        this.sexo = sexo;
        this.tipoSang = tipoSang;
    }

    //<editor-fold defaultstate="collapsed" desc="gets/sets">
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoSang() {
        return tipoSang;
    }

    public void setTipoSang(String tipoSang) {
        this.tipoSang = tipoSang;
    }
    //</editor-fold>
}
