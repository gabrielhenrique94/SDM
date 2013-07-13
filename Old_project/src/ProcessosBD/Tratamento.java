package ProcessosBD;

import java.sql.Date;

public class Tratamento {
    private int  codigo;
    private String receituario, observacoes;
    private Date data;
    
    public Tratamento() {
    }

    public Tratamento(int codigo, String receituario, String observacoes, Date data) {
        this.codigo = codigo;
        this.receituario = receituario;
        this.observacoes = observacoes;
        this.data = data;
        
    }

    //<editor-fold defaultstate="collapsed" desc="gets/sets">
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getReceituario() {
        return receituario;
    }

    public void setReceituario(String receituario) {
        this.receituario = receituario;
    }
    
     public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    //</editor-fold>
   
}
