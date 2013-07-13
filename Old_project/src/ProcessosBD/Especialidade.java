
package ProcessosBD;

public class Especialidade {
    private int codigo;
    private String nome, area;
    
    public Especialidade() {
    }

    public Especialidade(int codigo, String nome, String area) {
        this.codigo = codigo;
        this.nome = nome;
        this.area = area;
    }

    //<editor-fold defaultstate="collapsed" desc="gets/sets">
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    //</editor-fold>
}
