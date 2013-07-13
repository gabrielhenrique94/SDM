package ProcessosBD;

public class EspecialidadeMedico {
    private Especialidade especialidade;
    private Medico medico;

    public EspecialidadeMedico() {
    }

    public EspecialidadeMedico(Especialidade especialidade, Medico medico) {
        this.especialidade = especialidade;
        this.medico = medico;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
        
}
