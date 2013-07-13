package ProcessosBD;

public class Consultorio {
    private int codigo, telefone;
    private String identificacao, endereco, endComplemento, cidade, uf;
    
    public Consultorio() {
    }

    public Consultorio(int codigo, int telefone, String identificacao, String endereco, String endComplemento, String cidade, String uf) {
        this.codigo = codigo;
        this.telefone = telefone;
        this.identificacao = identificacao;
        this.endereco = endereco;
        this.endComplemento = endComplemento;
        this.cidade = cidade;
        this.uf = uf;
    }

    //<editor-fold defaultstate="collapsed" desc="gets/sets">
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEndComplemento() {
        return endComplemento;
    }

    public void setEndComplemento(String endComplemento) {
        this.endComplemento = endComplemento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    //</editor-fold>
}