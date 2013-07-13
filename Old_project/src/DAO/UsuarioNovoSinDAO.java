
package DAO;

import DAO.DAO;
import ProcessosBD.Conexao;
import ProcessosBD.UsuarioNovoSin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioNovoSinDAO implements DAO<UsuarioNovoSin>{
    private Connection conexao;
    private PreparedStatement pstmt, pstmt1, pstmt2;
    private Conexao poolMySQL;

    @Override
    public int incluir(UsuarioNovoSin usuNovoSin) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "INSERT INTO `cbr`.`novoSintoma_has_usuario` (`novo_sintoma_nsi_codigo` ,  `usuario_usu_codigo`, `uns_ja_votou`)VALUES ('?', '?', '?')";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, usuNovoSin.getNovoSintoma().getCodigo());
            pstmt.setInt(2, usuNovoSin.getUsuario().getCodigo());
            pstmt.setInt(3, usuNovoSin.getVotou());
            

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
    public int alterar(UsuarioNovoSin usuNovoSin) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int excluir(UsuarioNovoSin usuNovoSin) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM novoSintoma_has_usuario WHERE novo_sintoma_nsi_codigo='?' AND  usuario_usu_codigo='?'";
            pstmt = conexao.prepareStatement(sql);
            
            pstmt.setInt(1, usuNovoSin.getNovoSintoma().getCodigo());
            pstmt.setInt(2, usuNovoSin.getUsuario().getCodigo());         
            
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
    
    public int votou(int codigoUsuario, int codigoNovoSint){
        int votou = 0;
         try {            
            conexao = poolMySQL.connect();            
            String sql = "SELECT uns_ja_votou FROM novoSintoma_has_usuario WHERE novo_sintoma_nsi_codigo=? AND  usuario_usu_codigo= ?;";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, codigoNovoSint);
            pstmt.setInt(2, codigoUsuario);

            ResultSet select = pstmt.executeQuery();
            select.first();
            UsuarioNovoSin usu = new UsuarioNovoSin();
            usu.setVotou(select.getInt("uns_ja_votou"));
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
