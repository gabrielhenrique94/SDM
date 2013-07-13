/*
 * To change this template, choose Toools | Templatesa
 * and open the template in the editor.a
 */

/*
 * JanelaPrincipal.javaa
 *
 * Created on 14/08/2011, 15:45:24
 */
package janelasdoprojetao;

import Controle.Referencias;
import janelasdepesquisas.*;
import java.awt.event.ActionEvent;
import janelasdoprojetao.Cadastro.*;
import ProcessosBD.*;
import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author Glaupe e Iris
 */
public class JanelaPrincipal extends javax.swing.JFrame {

    private static JanelaPrincipal instancia;
    
    public static JanelaPrincipal getInstance(){
        if(instancia == null){
            instancia = new JanelaPrincipal();
        }
        return instancia;
    }
    /** Creates new form JanelaPrincipal */
    public JanelaPrincipal() {
        initComponents();
        
        this.setSize(1250, 750);

        PrincipalAbas pa = new PrincipalAbas();
        pa.setName("Home");
        jTabbedPaneHome.add(pa);
        
        if(Referencias.getUsuarioLogado().getNivel() == 1 || Referencias.getUsuarioLogado().getNivel() == 2){
            //item novo>medico
            jMenuItem14.setVisible(false);
        }else{
            jMenuItem15.setText("Sintoma");
            jMenuItem16.setText("Doença");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneHome = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        javax.swing.JMenuItem jMenuItem6 = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItem7 = new javax.swing.JMenuItem();
        javax.swing.JMenu jMenu4 = new javax.swing.JMenu();
        javax.swing.JMenuItem jMenuItem17 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        javax.swing.JMenu jMenu2 = new javax.swing.JMenu();
        javax.swing.JMenuItem jMenuItemPacientes1 = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItem4 = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItem8 = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItem13 = new javax.swing.JMenuItem();
        javax.swing.JMenu jMenu3 = new javax.swing.JMenu();
        javax.swing.JMenuItem jMenuItem10 = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItem11 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Sistema Diagnóstico Médico Beta 1.0");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);
        setName("Form"); // NOI18N
        setResizable(false);

        jTabbedPaneHome.setToolTipText("");
        jTabbedPaneHome.setName("jTabbedPaneHome"); // NOI18N

        jMenuBar1.setName("jMenuBar1"); // NOI18N

        jMenu1.setText("Arquivo");
        jMenu1.setName("jMenu1"); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem6.setText("Log out");
        jMenuItem6.setName("jMenuItem6"); // NOI18N
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setText("Encerrar");
        jMenuItem7.setName("jMenuItem7"); // NOI18N
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Editar");
        jMenu4.setName("jMenu4"); // NOI18N
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        jMenuItem17.setText("Dados Pessoais");
        jMenuItem17.setName("jMenuItem17"); // NOI18N
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem17);

        jMenuBar1.add(jMenu4);

        jMenu6.setText("Novo");
        jMenu6.setName("jMenu6"); // NOI18N
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });

        jMenuItem3.setText("Paciente");
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);

        jMenuItem14.setText("Médico");
        jMenuItem14.setName("jMenuItem14"); // NOI18N
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem14);

        jMenuItem15.setText("Solicitação de Nova Doença");
        jMenuItem15.setName("jMenuItem15"); // NOI18N
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem15);

        jMenuItem16.setText("Solicitação de Novo Sintoma");
        jMenuItem16.setName("jMenuItem16"); // NOI18N
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem16);

        jMenuItem1.setText("Consulta");
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        jMenuBar1.add(jMenu6);

        jMenu2.setText("Pesquisar");
        jMenu2.setName("jMenu2"); // NOI18N
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItemPacientes1.setText("Pacientes");
        jMenuItemPacientes1.setName("jMenuItemPacientes1"); // NOI18N
        jMenuItemPacientes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPacientes1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemPacientes1);

        jMenuItem4.setText("Doenças");
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem8.setText("Sintomas");
        jMenuItem8.setName("jMenuItem8"); // NOI18N
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem13.setText("Casos");
        jMenuItem13.setName("jMenuItem13"); // NOI18N
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem13);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Sobre...");
        jMenu3.setName("jMenu3"); // NOI18N

        jMenuItem10.setText("Ajuda");
        jMenuItem10.setName("jMenuItem10"); // NOI18N
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem11.setText("WiC");
        jMenuItem11.setName("jMenuItem11"); // NOI18N
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneHome, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneHome, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JanelaCadastroPaciente jcp = new JanelaCadastroPaciente();
        jcp.setName("Novo Paciente");
        
        jTabbedPaneHome.add(jcp);
        jTabbedPaneHome.setSelectedComponent(jcp);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem7ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        encerrar(this);
    }//GEN-LAST:event_jMenuItem7ActionPerformed
    public void encerrar(Frame f) {

        Object[] options = {"Sim", "Não"};

        int n = JOptionPane.showOptionDialog(f,
                "Deseja encerrar o programa?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);

        if (n == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    
    private void jMenuItem6ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        this.setVisible(false);
        JanelaLogin j = new JanelaLogin();
        j.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem14ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        final JanelaCadastroMedico jcm = new JanelaCadastroMedico();
        jcm.setName("Novo Médico");
        
        jTabbedPaneHome.add(jcm);
        jTabbedPaneHome.setSelectedComponent(jcm);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        final JanelaCadastroDoenca jcd = new JanelaCadastroDoenca();
        jcd.setName("Nova Doença");

        jTabbedPaneHome.add(jcd);
        jTabbedPaneHome.setSelectedComponent(jcd);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        final JanelaCadastroSintoma jcs = new JanelaCadastroSintoma();
        jcs.setName("Novo Sintoma");

        jTabbedPaneHome.add(jcs);
        jTabbedPaneHome.setSelectedComponent(jcs);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItemPacientes1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItemPacientes1ActionPerformed
        final Pacientes ps = new Pacientes();
        ps.setName("Meus Pacientes");

        jTabbedPaneHome.add(ps);
        jTabbedPaneHome.setSelectedComponent(ps);
    }//GEN-LAST:event_jMenuItemPacientes1ActionPerformed

    private void jMenuItem11ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        try {
            String url = "http://www.wicproject.blogspot.com/";

            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
        } catch (Exception e) {
            System.out.println("ERRO AO ABRIR PÁGINA WIC");
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed


    private void jMenuItem17ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        final janelasdoprojetao.Cadastro.JanelaCadastroMedico jcm = new JanelaCadastroMedico();
        jcm.setName("Meus dados");
        jcm.jFormattedTextField1.setEditable(false);
        jcm.jFormattedTextField5.setEditable(false);
        jcm.jLabel17.setText("Meus Dados");
        jcm.jButton1.setText("Editar");
        
        Medico m = Referencias.getMedicoLogado();
        jcm.setNome(m.getNome());
        jcm.setCRM(m.getCrmNumero());
        jcm.setCRMUF(m.getCrmUF());
        jcm.setCel(m.getTelCelular());
        jcm.setTel(m.getTelResidencial());
        jcm.setCidade(m.getCidade());
        jcm.setDataNasc("" + m.getDataNasc());
        jcm.setEndComplemento(m.getEndComplemento());
        jcm.setEndereco(m.getEndereco());
        jcm.setEstado(m.getUF());
        jcm.setEstCivil(m.getEstadoCivil());
        jcm.setRG(m.getRg());
        jcm.setSexo(m.getSexo()); 
        jcm.jPanel4.setVisible(false);

        jTabbedPaneHome.add(jcm);
        jTabbedPaneHome.setSelectedComponent(jcm);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenu4ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
    
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenuItem10ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        
        try {
            String url = "https://docs.google.com/open?id=0B7_2wsoj2jkfMjRhNmY1NjAtODNjMi00NjgwLThkOTItM2M4OTliNjU0NGMx";

            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
        } catch (Exception e) {
            System.out.println("ERRO AO ABRIR MANUAL DO USUÁRIO");
        }

    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem4ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        final Doencas doe = new Doencas();
        doe.setName("Pesquisa: Doenças");
       
        jTabbedPaneHome.add(doe);
        jTabbedPaneHome.setSelectedComponent(doe);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenu2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed

    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        final Sintomas sin = new Sintomas();
        sin.setName("Pesquisa: Sintomas");

        jTabbedPaneHome.add(sin);
        jTabbedPaneHome.setSelectedComponent(sin);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
        janelasdoprojetao.Cadastro.JanelaCadastroSintoma jcs = new JanelaCadastroSintoma();
        jcs.setName("Novo Sintoma");
        
        jTabbedPaneHome.add(jcs);
        jTabbedPaneHome.setSelectedComponent(jcs);
    }//GEN-LAST:event_jMenu6ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        final Casos cas = new Casos();
        cas.setName("Pesquisa: Casos");

        jTabbedPaneHome.add(cas);
        jTabbedPaneHome.setSelectedComponent(cas);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JanelaAgendar jar = new JanelaAgendar();
        jar.setName("Nova Consulta");
        
        jTabbedPaneHome.add(jar);
        jTabbedPaneHome.setSelectedComponent(jar); 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    //<editor-fold defaultstate="collapsed" desc="Novo Paciente Cod antigo">
    /*private void novaJanelaCadastroPacientes() {
     * final JanelaCadastroPaciente jcp = new JanelaCadastroPaciente();
     * jcp.setName("Novo Paciente");
     * 
     * jcp.jPanel1.setSize(jTabbedPaneHome.getSize());
     * jcp.jScrollPane1.setSize(jTabbedPaneHome.getSize());
     * 
     * jcp.jButton1.addActionListener(new ActionListener() {
     * 
     * @Override
     * public void actionPerformed(ActionEvent e) {
     * 
     * if (Controle.Validacao.verificaRG(jcp.getRG())) {
     * if ((jcp.getNome()).equals("") == false && jcp.getRG().equals("") == false //&& jcp.getCPF() != 0
     * && jcp.getDataNasc() != null && jcp.getSexo().equals("") == false
     * && jcp.getTel() != 0 && jcp.getCel() != 0 && jcp.getEndereco().equals("") == false
     * && jcp.getEndComplemento().equals("") == false && jcp.getCidade().equals("") == false
     * && jcp.getEstado().equals("") == false && jcp.getEstadoCivil().equals("") == false
     * && jcp.getTipoSanguineo().equals("") == false) {
     * 
     * FichaMedica fm = new FichaMedica(0, jcp.getSexo(), jcp.getTipoSanguineo());
     * Paciente pac = new Paciente(0, jcp.getCPF(), jcp.getTel(), jcp.getCel(), jcp.getNome(), jcp.getRG(),
     * jcp.getEndereco(), jcp.getEndComplemento(), jcp.getCidade(), jcp.getEstado(),
     * jcp.getEstadoCivil(), jcp.getDataNasc(), fm);
     * PacienteDAO pdao = new PacienteDAO();
     * pdao.incluir(pac);
     * 
     * JOptionPane.showMessageDialog(
     * null, "Cadastro realizado com sucesso.",
     * "Confirmação", JOptionPane.PLAIN_MESSAGE);
     * } else {
     * JOptionPane.showMessageDialog(
     * null, "Favor preencher todos os campos.",
     * "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
     * }
     * } else {
     * JOptionPane.showMessageDialog(
     * null, "Favor inserir um RG válido.",
     * "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
     * }
     * }
     * });
     * 
     * 
     * jTabbedPaneHome.add(jcp);
     * jTabbedPaneHome.setSelectedComponent(jcp);
     * }*/
    //</editor-fold>
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JMenu jMenu1;
    javax.swing.JMenu jMenu6;
    javax.swing.JMenuBar jMenuBar1;
    javax.swing.JMenuItem jMenuItem1;
    javax.swing.JMenuItem jMenuItem14;
    javax.swing.JMenuItem jMenuItem15;
    javax.swing.JMenuItem jMenuItem16;
    javax.swing.JMenuItem jMenuItem3;
    public javax.swing.JTabbedPane jTabbedPaneHome;
    // End of variables declaration//GEN-END:variables
}
