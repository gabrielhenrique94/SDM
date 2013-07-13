package DAO;

import ProcessosBD.Conexao;
import ProcessosBD.Consultorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultorioDAO implements DAO<Consultorio>{
    private Connection conexao;
    private PreparedStatement pstmt;
    private Conexao poolMySQL;
    
    @Override
    public int incluir(Consultorio consultorio) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "INSERT INTO `cbr`.`consultorio` (`con_codigo` , `con_identificacao`, `con_endereco`, `con_end_complemento`, `con_cidade`, `con_uf`, `con_telefone`)VALUES ('', '?', '?', '?', '?', '?', '?')";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, consultorio.getIdentificacao());
            pstmt.setString(2, consultorio.getEndereco());
            pstmt.setString(3, consultorio.getEndComplemento());
            pstmt.setString(4, consultorio.getCidade());
            pstmt.setString(5, consultorio.getUf());
            pstmt.setInt(6, consultorio.getTelefone());

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
    public int alterar(Consultorio consultorio) {
              int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "UPDATE consultorio SET `con_identificacao`='?', `con_endereco`='?', `con_end_complemento`='?', `con_cidade`='?', `con_uf`='?', `con_telefone`='?' WHERE `con_codigo`='?'";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, consultorio.getIdentificacao());
            pstmt.setString(2, consultorio.getEndereco());
            pstmt.setString(3, consultorio.getEndComplemento());
            pstmt.setString(4, consultorio.getCidade());
            pstmt.setString(5, consultorio.getUf());
            pstmt.setInt(6, consultorio.getTelefone());
            pstmt.setInt(7, consultorio.getCodigo());

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
    public int excluir(Consultorio consultorio) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM consultorio WHERE codigo = '?'";
            pstmt = conexao.prepareStatement(sql);
            
            pstmt.setInt(1, consultorio.getCodigo());
            
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
    
    public String[] select()
    {
        String[] pego = null;
        ResultSet rs = null;
        int resultado = 0;
        int i = 0;
        try {

            conexao = poolMySQL.connect();
 
            String sql = "select con_identificacao from consultorio ";
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
    
    public Consultorio selecionador(String nome)
    {
        String[] pego = null;
        ResultSet rs = null;
        Consultorio resultado ;
        int i = 0;
        try {

            conexao = poolMySQL.connect();
 
            String sql = "select * from consultorio WHERE con_identificacao = '?'";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, nome);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                resultado = new Consultorio(0, i, nome, nome, nome, nome, sql);
                pego[i] = rs.getString(1);
                i++;
            }            
            
 //           resultado = pstmt.executeUpdate();
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
        
   //
        return null;
    }
} 
