package DAO;

import DAO.DAO;
import ProcessosBD.Conexao;
import ProcessosBD.Especialidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EspecialidadeDAO implements DAO<Especialidade>{
    private Connection conexao;
    private PreparedStatement pstmt;
    private Conexao poolMySQL;
    
    @Override
    public int incluir(Especialidade especialidade) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "INSERT INTO `cbr`.`especialidade` (`tra_codigo` , `esp_nome`, `esp_area`)VALUES ('', '?', '?')";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, especialidade.getNome());
            pstmt.setString(2, especialidade.getArea());            

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
    public int alterar(Especialidade especialidade) {
              int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "UPDATE especialidade SET `esp_nome`='?', `esp_area`='?' WHERE `esp_codigo`='?'";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, especialidade.getNome());
            pstmt.setString(2, especialidade.getArea());
            pstmt.setInt(3, especialidade.getCodigo());

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
    public int excluir(Especialidade especialidade) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM especialidade WHERE codigo = '?'";
            pstmt = conexao.prepareStatement(sql);
            
            pstmt.setInt(1, especialidade.getCodigo());
            
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
    
    public String[] selecionador(String texto)
    {
        String[] pego = null;
        ResultSet rs = null;
        int resultado = 0;
        int i = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "select esp_nome from especialidade where esp_nome Like '%" + texto + "%'";
            pstmt = conexao.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                pego[i] = rs.getString(1);
                i++;
            }            
            
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
        
        return pego;
    }
    
    public String[] select()
    {
        String[] pego = null;
        ResultSet rs = null;
        int resultado = 0;
        int i = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "select esp_nome from especialidade";
            pstmt = conexao.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                pego[i] = rs.getString(1);
                i++;
            }            
            
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
        
        return pego;
    }
    
}
