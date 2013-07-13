package DAO;

import DAO.DAO;
import ProcessosBD.Conexao;
import ProcessosBD.UsuarioNovaDoenca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioNovaDoencaDAO implements DAO<UsuarioNovaDoenca>{
    private Connection conexao;
    private PreparedStatement pstmt, pstmt1, pstmt2;
    private Conexao poolMySQL;

    @Override
    public int incluir(UsuarioNovaDoenca usuNovaDoe) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "INSERT INTO `cbr`.`novoDoenca_has_usuario` (`nova_doenca_ndo_codigo` ,  `usuario_usu_codigo`, `und_ja_votou`)VALUES ('?', '?', '?')";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, usuNovaDoe.getNovaDoenca().getCodigo());
            pstmt.setInt(2, usuNovaDoe.getUsuario().getCodigo());
            pstmt.setInt(3, usuNovaDoe.getVotou());
            

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
    public int alterar(UsuarioNovaDoenca usuNovaDoe) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int excluir(UsuarioNovaDoenca usuNovaDoe) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM novoDoenca_has_usuario WHERE nova_doenca_ndo_codigo='?' AND  usuario_usu_codigo='?'";
            pstmt = conexao.prepareStatement(sql);
            
            pstmt.setInt(1, usuNovaDoe.getNovaDoenca().getCodigo());
            pstmt.setInt(2, usuNovaDoe.getUsuario().getCodigo());         
            
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
    
    public int votou(int codigoUsuario, int codigoNovaDoe){
        int votou = 0;
         try {            
            conexao = poolMySQL.connect();            
            String sql = "SELECT und_ja_votou FROM novoDoenca_has_usuario WHERE nova_doenca_ndo_codigo=? AND  usuario_usu_codigo= ?;";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, codigoNovaDoe);
            pstmt.setInt(2, codigoUsuario);

            ResultSet select = pstmt.executeQuery();
            select.first();
            UsuarioNovaDoenca usu = new UsuarioNovaDoenca();
            usu.setVotou(select.getInt("und_ja_votou"));
            votou = usu.getVotou();
            return votou;

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
        return votou;
    }
}
