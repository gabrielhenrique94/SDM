package DAO;

import DAO.DAO;
import ProcessosBD.Conexao;
import ProcessosBD.EspecialidadeMedico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EspecialidadeMedicoDAO implements DAO<EspecialidadeMedico>{
    private Connection conexao;
    private PreparedStatement pstmt;
    private Conexao poolMySQL;

    @Override
    public int incluir(EspecialidadeMedico espMedico) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "INSERT INTO `cbr`.`especialidade_has_medico` (`especialidade_esp_codigo`, `medico_med_codigo`)VALUES ('?', '?')";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, espMedico.getEspecialidade().getCodigo());
            pstmt.setInt(2, espMedico.getMedico().getCodigo());

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
    public int alterar(EspecialidadeMedico espMedico) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int excluir(EspecialidadeMedico espMedico) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM especialidade_has_medico WHERE especialidade_esp_codigo = '?' AND medico_med_codigo = '?'";
            pstmt = conexao.prepareStatement(sql);
            
            pstmt.setInt(1, espMedico.getEspecialidade().getCodigo());
            pstmt.setInt(2, espMedico.getMedico().getCodigo());
            
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
}
