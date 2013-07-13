package ProcessosBD;

import java.sql.Date;

public class Agenda {

    private int codigo;
    private Date data;
    private String queixa;
    private Paciente paciente;
    private Medico medico;

    public Agenda() {
    }

    public Agenda(int codigo, Date data, String queixa, Paciente paciente, Medico medico) {

        this.codigo = codigo;
        this.data = data;
        this.queixa = queixa;
        this.paciente = paciente;
        this.medico = medico;

    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @return the queixa
     */
    public String getQueixa() {
        return queixa;
    }

    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @return the medico
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * @param aCodigo the codigo to set
     */
    public void setCodigo(int aCodigo) {
        codigo = aCodigo;
    }

    /**
     * @param aData the data to set
     */
    public void setData(Date aData) {
        data = aData;
    }

    /**
     * @param aQueixa the queixa to set
     */
    public void setQueixa(String aQueixa) {
        queixa = aQueixa;
    }

    /**
     * @param aPaciente the paciente to set
     */
    public void setPaciente(Paciente aPaciente) {
        paciente = aPaciente;
    }

    /**
     * @param aMedico the medico to set
     */
    public void setMedico(Medico aMedico) {
        medico = aMedico;
    }
}
