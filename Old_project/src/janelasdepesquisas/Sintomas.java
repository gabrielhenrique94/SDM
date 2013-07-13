/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.a
 */

/*
 * Sintomas.java
 *
 * Created on 23/11/2011, 23:20:00
 */

package janelasdepesquisas;

import ProcessosBD.Sintoma;
import DAO.SintomaDAO;
import janelasdoprojetao.Cadastro.JanelaCadastroSintoma;
import janelasdoprojetao.JanelaPrincipal;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Fernanda
 */
public class Sintomas extends javax.swing.JPanel {

    ArrayList<String> sintomasNaLista;

    public Sintomas() {
        initComponents();
        this.sintomasNaLista = new ArrayList<String>();
        initComponents();

        SintomaDAO dao = new SintomaDAO();
        ArrayList<Sintoma> lista = dao.selectNomeParcial(jTextField1.getText());
        atualizaLista(lista);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list1 = new java.awt.List();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

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

        jButton1.setText("Novo Sintoma");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addComponent(jButton1)))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void list1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list1MouseClicked

    }//GEN-LAST:event_list1MouseClicked

    private void list1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_list1ItemStateChanged

}//GEN-LAST:event_list1ItemStateChanged

    private void list1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list1ActionPerformed
//        Object selecionado = list1.getSelectedItem();
//        final JanelaCadastroSintoma cas = new JanelaCadastroSintoma();
//        cas.setName("Sintoma: " + selecionado.toString().toUpperCase());
//        JanelaPrincipal.getInstance().jTabbedPaneHome.add(cas);
//        JanelaPrincipal.getInstance().jTabbedPaneHome.setSelectedComponent(cas);
}//GEN-LAST:event_list1ActionPerformed

    private void list1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_list1KeyPressed

}//GEN-LAST:event_list1KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JanelaPrincipal.getInstance().jTabbedPaneHome.remove(this);
}//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

}//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        SintomaDAO dao = new SintomaDAO();
        ArrayList<Sintoma> lista = dao.selectNomeParcial(jTextField1.getText());
        atualizaLista(lista);
}//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        janelasdoprojetao.Cadastro.JanelaCadastroSintoma jcs = new JanelaCadastroSintoma();
        jcs.setName("Cadastro de Sintoma");
        JanelaPrincipal.getInstance().jTabbedPaneHome.add(jcs);
        JanelaPrincipal.getInstance().jTabbedPaneHome.setSelectedComponent(jcs);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private java.awt.List list1;
    // End of variables declaration//GEN-END:variables

        public void atualizaLista(ArrayList<Sintoma> sintomas) {
        list1.removeAll();
        Iterator iterator = sintomas.iterator();
        while (iterator.hasNext()) {
            Sintoma sintoma = (Sintoma) iterator.next();
            String nomeSintoma = sintoma.getNome();
            if(!sintomasNaLista.contains(nomeSintoma)){
            list1.add(nomeSintoma);
            }

        }

    }

}
