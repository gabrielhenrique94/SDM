/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janelasConsultaSimilaridade;
import ProcessosBD.*;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class ReferenciasSimilaridade {
    //As referencias guardadas nessa classe , servem para que o voltar durante o processo da similaridade funcione , sem que você perca tudo o que ja tinha feito

    private static Paciente paciente;
    private static Caso caso;
    private static ArrayList<String> sintomasNaLista;
    public static void setPaciente(Paciente paciente) {
        ReferenciasSimilaridade.paciente = paciente;
    }

    public static Paciente getPaciente() {
        return paciente;
    }

    public static Caso getCaso() {
        return caso;
    }

    public static void setCaso(Caso caso) {
        ReferenciasSimilaridade.caso = caso;
    }

    public static ArrayList<String> getSintomasNaLista() {
        return sintomasNaLista;
    }

    public static void setSintomasNaLista(ArrayList<String> sintomasNaLista) {
        ReferenciasSimilaridade.sintomasNaLista = sintomasNaLista;
    }
    public static void limpaReferencias(){
        setSintomasNaLista(null);
        setCaso(null);
        setPaciente(null);
    }

  
    
    
   
}
