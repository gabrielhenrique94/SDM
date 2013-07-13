package DAO;

import DAO.DAO;
import ProcessosBD.Conexao;
import ProcessosBD.Tratamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TratamentoDAO implements DAO<Tratamento>{
    private Connection conexao;
    private PreparedStatement pstmt;
    private Conexao poolMySQL;
    
    @Override
    public int incluir(Tratamento tratamento) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "INSERT INTO `cbr`.`tratamento` (`tra_codigo` , `tra_receituario`, `tra_observacoes`)VALUES ('', '?', '?')";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, tratamento.getReceituario());
            pstmt.setString(2, tratamento.getObservacoes());            

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
    public int alterar(Tratamento tratamento) {
              int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "UPDATE tratamento SET `tra_receituario`='?', `tra_observacoes`='?' WHERE `tra_codigo`='?'";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, tratamento.getReceituario());
            pstmt.setString(2, tratamento.getObservacoes());
            pstmt.setInt(3, tratamento.getCodigo());

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
    public int excluir(Tratamento tratamento) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM tratamento WHERE codigo = '?'";
            pstmt = conexao.prepareStatement(sql);
            
            pstmt.setInt(1, tratamento.getCodigo());
            
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