package DAO.Relacoes;

import DAO.DAO;
import DAO.DAO;
import ProcessosBD.Conexao;
import ProcessosBD.TratamentoCaso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TratamentoCasoDAO implements DAO<TratamentoCaso>{
    private Connection conexao;
    private PreparedStatement pstmt;
    private Conexao poolMySQL;

    @Override
    public int incluir(TratamentoCaso tratCaso) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "INSERT INTO `cbr`.`tratamento_has_caso` (`tratamento_tra_codigo`, `caso_cas_codigo`)VALUES ('?', '?')";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, tratCaso.getTratamento().getCodigo());
            pstmt.setInt(2, tratCaso.getCaso().getCodigo());

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
    public int alterar(TratamentoCaso tratCaso) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "UPDATE tratamento_has_caso SET `tratamento_tra_codigo`='?', `caso_cas_codigo`='?' WHERE `tratamento_tra_codigo` = '?' AND `caso_cas_codigo`='?'";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, tratCaso.getTratamento().getCodigo());
            pstmt.setInt(2, tratCaso.getCaso().getCodigo());
           
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
    public int excluir(TratamentoCaso tratCaso) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM tratamento_has_caso WHERE tratamento_tra_codigo = '?' AND caso_cas_codigo = '?'";
            pstmt = conexao.prepareStatement(sql);
            
            pstmt.setInt(1, tratCaso.getTratamento().getCodigo());
            pstmt.setInt(2, tratCaso.getCaso().getCodigo());
            
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
