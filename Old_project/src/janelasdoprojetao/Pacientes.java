/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Pacientes.java
 *
 * Created on 14/08/2011, 17:18:16
 */
package janelasdoprojetao;

import DAO.PacienteDAO;
import ProcessosBD.*;
import janelasConsultaSimilaridade.JanelaCasoFichaMedica;
import janelasConsultaSimilaridade.ReferenciasSimilaridade;
import java.awt.Component;
import java.util.*;

/**
 *
 * @author Glaupe e Iris
 */
public class Pacientes extends javax.swing.JPanel {

    /** Creates new form Pacientes */
    public Pacientes() {
        initComponents();


        PacienteDAO dao = new PacienteDAO();
        
        ArrayList<Paciente> lista = dao.selectMedicoNomeParcial(Controle.Referencias.getMedicoLogado(), "");
        atualizaLista(lista);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        list1 = new java.awt.List();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setToolTipText("");
        setAutoscrolls(true);

        jLabel1.setText("Selecione um paciente para visualizar sua ficha medica:");

        list1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list1MouseClicked(evt);
            }
        });
        list1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                list1ItemStateChanged(evt);
            }
        });
        list1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list1ActionPerformed(evt);
            }
        });
        list1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                list1KeyPressed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fecharbutton.jpg"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Pesquisar:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void list1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list1ActionPerformed
    }//GEN-LAST:event_list1ActionPerformed

    private void list1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_list1ItemStateChanged
    }//GEN-LAST:event_list1ItemStateChanged

    private void list1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_list1KeyPressed
    }//GEN-LAST:event_list1KeyPressed

    private void list1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list1MouseClicked
        String item = list1.getSelectedItem();
        int codigo = pegaCodigo(item);
        PacienteDAO dao = new PacienteDAO();
        Paciente paciente = dao.selectCodigo(codigo);
        ReferenciasSimilaridade.setPaciente(paciente);
        JanelaCasoFichaMedica janelaNova = new JanelaCasoFichaMedica();
        janelaNova.setName(paciente.getNome());       
        JanelaPrincipal.getInstance().jTabbedPaneHome.add(janelaNova);
        JanelaPrincipal.getInstance().jTabbedPaneHome.setSelectedComponent(janelaNova);
    }//GEN-LAST:event_list1MouseClicked
    
    private int pegaCodigo(String item){
        Scanner scanner = new Scanner(item);
        scanner.useDelimiter("-");
        String stringCodigo  = scanner.next();
        int codigo = Integer.parseInt(stringCodigo);
        return codigo;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JanelaPrincipal.getInstance().jTabbedPaneHome.remove(this);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // QUANDO PRESSIONA ENTER NO TEXTBOX!
        // COPIAR CODIGO DE BAIXO. =)
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        PacienteDAO dao = new PacienteDAO();
        String NomeParcial = jTextField1.getText();
        ArrayList<Paciente> lista = dao.selectMedicoNomeParcial(Controle.Referencias.getMedicoLogado(), NomeParcial);
        atualizaLista(lista);
    }//GEN-LAST:event_jTextField1KeyReleased

    private void atualizaLista(ArrayList<Paciente> lista) {
        list1.removeAll();
        Iterator iterator = lista.iterator();
        while (iterator.hasNext()) {
            Paciente paciente = (Paciente) iterator.next();
            String nome = paciente.getNome();
            int codigo = paciente.getCodigo();
            
            String item =  codigo+  "-" + nome;
            list1.add(item);

        }


    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private java.awt.List list1;
    // End of variables declaration//GEN-END:variables
}