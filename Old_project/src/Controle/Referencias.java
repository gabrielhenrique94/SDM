/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import ProcessosBD.*;

/**
 *
 * @author Gabriel
 */
public class Referencias {
    private static Medico medicoLogado ;
    private static Usuario usuarioLogado;

    public Referencias() {
    }
    
    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario usuarioLogado) {
        Referencias.usuarioLogado = usuarioLogado;
    }
    
    public static Medico getMedicoLogado() {
        return medicoLogado;
    }

    public static void setMedicoLogado(Medico medicoLogado) {
        Referencias.medicoLogado = medicoLogado;
    }
    
}
