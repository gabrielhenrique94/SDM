package ProcessosBD;

import java.sql.Date;

public class NovoSintoma {
    private int codigo;
    private int tema;
    private String doenca;
    private String comentario;
    private Date dataPedido;
    private int votoContra;
    private int votoFavor;
    private Sintoma sintoma;

    public NovoSintoma() {
    }
    
    public NovoSintoma(int codigo, int tema, String doenca, String comentario, int votoContra, int votoFavor, Sintoma sintoma) {
        this.codigo = codigo;
        this.tema = tema;
        this.doenca = doenca;
        this.comentario = comentario;
        this.votoContra = votoContra;
        this.votoFavor = votoFavor;
        this.sintoma = sintoma;
    }

    //<editor-fold defaultstate="collapsed" desc="gets/sets">
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public Sintoma getSintoma() {
        return sintoma;
    }

    public void setSintoma(Sintoma sintoma) {
        this.sintoma = sintoma;
    }

    public int getTema() {
        return tema;
    }

    public void setTema(int tema) {
        this.tema = tema;
    }

    public int getVotoContra() {
        return votoContra;
    }

    public void setVotoContra(int votoContra) {
        this.votoContra = votoContra;
    }

    public int getVotoFavor() {
        return votoFavor;
    }

    public void setVotoFavor(int votoFavor) {
        this.votoFavor = votoFavor;
    }
    //</editor-fold>       
}
