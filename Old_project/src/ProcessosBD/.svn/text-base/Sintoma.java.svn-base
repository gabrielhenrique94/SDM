package ProcessosBD;

public class Sintoma {
    private int codigo;
    private String nome;
    private String descricao;
    private String tipo;
    private int pendente;
    
    public Sintoma() {
    }

    public Sintoma(int codigo, String nome, String descricao, String tipo, int pendente) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.pendente = pendente;
    }
    
    //<editor-fold defaultstate="collapsed" desc="gets/sets">
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPendente() {
        return pendente;
    }

    public void setPendente(int pendente) {
        this.pendente = pendente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    //</editor-fold>
       @Override
    public int hashCode() {
        return codigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(this.getClass())) {
            return (this.hashCode() == obj.hashCode());
        }else{
            return false;
        }   
    }
    
}
