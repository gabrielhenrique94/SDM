/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.DAO;
import ProcessosBD.Conexao;
import ProcessosBD.MedicoLocalDeAtendimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Glaupe e Iris
 */
public class MedicoLocalDeAtendimentoDAO implements DAO<MedicoLocalDeAtendimento>{

    private Connection conexao;
    private PreparedStatement pstmt;
    private Conexao poolMySQL;

    @Override
    public int incluir(MedicoLocalDeAtendimento medicolocaldeatend) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "INSERT INTO `cbr`.`medico_has_consultorio` (`ehm_codigo`, `medico_med_codigo` ,  `consultorio_con_codigo`)VALUES ('', '?', '?')";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, medicolocaldeatend.getCodigo_medico());
            pstmt.setInt(2, medicolocaldeatend.getCodigo_consultorio());
            

            resultado = pstmt.executeUpdate();

            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException se) {
                System.out.print("Erro Statement SQLException que ocorreu: \n" + se);
            }

            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException se) {
                System.out.print("Erro Connection SQLException que ocorreu: \n" + se);
            }

        }

        return resultado;
    }

    @Override
    public int alterar(MedicoLocalDeAtendimento objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int excluir(MedicoLocalDeAtendimento objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
