package ProcessosBD;

public class MedicoConsultorio {
    private Medico medico;
    private Consultorio consultorio;

    public MedicoConsultorio() {
    }

    public MedicoConsultorio(Medico medico, Consultorio consultorio) {
        this.medico = medico;
        this.consultorio = consultorio;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
}
