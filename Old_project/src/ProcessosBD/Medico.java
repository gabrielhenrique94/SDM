package ProcessosBD;

import java.sql.Date;

public class Medico {
    private int codigo;
    private String nome;
    private String rg;
    private int crmNumero;
    private String crmUF;
    private String dataNasc;
    private String endereco;
    private String endComplemento;
    private String cidade;
    private String UF;
    private String estadoCivil;
    private String sexo;
    private int telResidencial;
    private int telCelular;
    private Usuario usuario;
    
    public Medico() {
    }

    public Medico(int codigo, String nome, String rg, int crmNumero, String crmUF, String dataNasc, String endereco, String endComplemento, String cidade, String UF, String estadoCivil, String sexo, int telResidencial, int telCelular, Usuario usuario) {
        this.codigo = codigo;
        this.nome = nome;
        this.rg = rg;
        this.crmNumero = crmNumero;
        this.crmUF = crmUF;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.endComplemento = endComplemento;
        this.cidade = cidade;
        this.UF = UF;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.telResidencial = telResidencial;
        this.telCelular = telCelular;
        this.usuario = usuario;
    }

    //<editor-fold defaultstate="collapsed" desc="gets/sets">
    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

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

    public int getCrmNumero() {
        return crmNumero;
    }

    public void setCrmNumero(int crmNumero) {
        this.crmNumero = crmNumero;
    }

    public String getCrmUF() {
        return crmUF;
    }

    public void setCrmUF(String crmUF) {
        this.crmUF = crmUF;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
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

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(int telCelular) {
        this.telCelular = telCelular;
    }

    public int getTelResidencial() {
        return telResidencial;
    }

    public void setTelResidencial(int telResidencial) {
        this.telResidencial = telResidencial;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    //</editor-fold>   
    
}
