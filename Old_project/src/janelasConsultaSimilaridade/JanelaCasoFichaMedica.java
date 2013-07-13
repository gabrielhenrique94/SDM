/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JanelaCasoFichaMedica.java
 *
 * Created on 09/11/2011, 01:41:01
 */
package janelasConsultaSimilaridade;

import Controle.MetodosUteis;
import ProcessosBD.*;
import janelasdoprojetao.JanelaPrincipal;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;
import janelasdepesquisas.*;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import sun.awt.color.CMM.CSAccessor;

/**
 *
 * @author Fernanda
 */
public class JanelaCasoFichaMedica extends javax.swing.JPanel {

    Paciente paciente;
    private MaskFormatter mascaraFormat;

    public JanelaCasoFichaMedica() {
        initComponents();
        this.paciente = ReferenciasSimilaridade.getPaciente();
        GregorianCalendar calendario = new GregorianCalendar();

        Date data = calendario.getTime();
        int idade = data.getYear() - paciente.getDataNasc().getYear();
        if (data.getMonth() < paciente.getDataNasc().getMonth()) {
            idade++;
        } else if (data.getMonth() == paciente.getDataNasc().getMonth()) {
            if (data.getDay() < paciente.getDataNasc().getDay()) {
                idade++;
            }
        }
        campoIdade.setText(String.valueOf(idade));
        jLabel5.setText(paciente.getNome());
        if (ReferenciasSimilaridade.getCaso() != null) {
            colocaCaso(ReferenciasSimilaridade.getCaso());
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jButton2 = new javax.swing.JButton();
        labelNomePaciente = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        try{
            mascaraFormat = new MaskFormatter("#.##");}
        catch(Exception e){
        }
        campoAltura = new javax.swing.JFormattedTextField(mascaraFormat);
        jScrollPane1 = new javax.swing.JScrollPane();
        campoMedicacoes = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        try{
            mascaraFormat = new MaskFormatter("###.##");}
        catch(Exception e){
        }
        campoPeso = new javax.swing.JFormattedTextField(mascaraFormat);
        jLabel2 = new javax.swing.JLabel();
        Label4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        campoIdade = new javax.swing.JFormattedTextField();

        jFormattedTextField4.setText("jFormattedTextField1");

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fecharbutton.jpg"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 26, 26));

        labelNomePaciente.setText("Paciente:");
        add(labelNomePaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 11, -1, -1));

        jLabel5.setText("jLabel5");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 11, -1, -1));

        campoAltura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoAlturaActionPerformed(evt);
            }
        });
        add(campoAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 31, 181, -1));

        campoMedicacoes.setColumns(20);
        campoMedicacoes.setRows(5);
        jScrollPane1.setViewportView(campoMedicacoes);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 109, 181, 115));

        jLabel4.setText("Peso:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 60, -1, -1));
        add(campoPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 57, 181, -1));

        jLabel2.setText("Medicações Frequentes:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 109, -1, -1));

        Label4.setText("Altura:");
        add(Label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 34, -1, -1));

        jButton1.setText("Inserir Sintomas >>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 235, -1, -1));

        jLabel6.setText("Idade:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 86, -1, -1));

        campoIdade.setEditable(false);
        add(campoIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 83, 181, -1));

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ReferenciasSimilaridade.limpaReferencias();
        JanelaPrincipal.getInstance().jTabbedPaneHome.remove(this);

}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Caso caso = pegaCaso();
        ReferenciasSimilaridade.setCaso(caso);
        JanelaCasoInsereSintomas janelaNova = new JanelaCasoInsereSintomas(caso, paciente);
        JanelaPrincipal.getInstance().jTabbedPaneHome.add(janelaNova);
        JanelaPrincipal.getInstance().jTabbedPaneHome.setSelectedComponent(janelaNova);
        JanelaPrincipal.getInstance().jTabbedPaneHome.remove(this);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void campoAlturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoAlturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoAlturaActionPerformed

    private Caso pegaCaso() {
        Caso retorno = new Caso();
        retorno.setMedico(Controle.Referencias.getMedicoLogado());
        retorno.setAltura(Float.parseFloat(campoAltura.getText() + 'f'));
        retorno.setPeso(Float.parseFloat(campoPeso.getText() + 'f'));
        retorno.setMedicacoes(campoMedicacoes.getText());
        return retorno;
    }

    private void colocaCaso(Caso caso) {

        campoAltura.setText(MetodosUteis.truncaFloat(caso.getAltura(), 2));
        campoPeso.setText(MetodosUteis.truncaFloat(caso.getPeso(), 2));
        campoMedicacoes.setText(caso.getMedicacoes());

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label4;
    private javax.swing.JFormattedTextField campoAltura;
    private javax.swing.JFormattedTextField campoIdade;
    private javax.swing.JTextArea campoMedicacoes;
    private javax.swing.JFormattedTextField campoPeso;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelNomePaciente;
    // End of variables declaration//GEN-END:variables
}
