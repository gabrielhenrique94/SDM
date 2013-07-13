package DAO;

import DAO.DAO;
import ProcessosBD.Conexao;
import ProcessosBD.EspecialidadeDoenca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EspecialidadeDoencaDAO implements DAO<EspecialidadeDoenca>{
    private Connection conexao;
    private PreparedStatement pstmt;
    private Conexao poolMySQL;

    @Override
    public int incluir(EspecialidadeDoenca espDoenca) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "INSERT INTO `cbr`.`especialidade_has_doenca` (`especialidade_esp_codigo`, `doenca_doe_codigo`)VALUES ('?', '?')";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, espDoenca.getEspecialidade().getCodigo());
            pstmt.setInt(2, espDoenca.getDoenca().getCodigo());

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
    public int alterar(EspecialidadeDoenca espDoenca) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int excluir(EspecialidadeDoenca espDoenca) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM especialidade_has_doenca WHERE especialidade_esp_codigo = '?' AND doenca_doe_codigo = '?'";
            pstmt = conexao.prepareStatement(sql);
            
            pstmt.setInt(1, espDoenca.getEspecialidade().getCodigo());
            pstmt.setInt(2, espDoenca.getDoenca().getCodigo());
            
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
