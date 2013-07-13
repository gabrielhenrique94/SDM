package DAO;

import DAO.DAO;
import ProcessosBD.Conexao;
import ProcessosBD.FichaMedica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FichaMedicaDAO implements DAO<FichaMedica>{
    private Connection conexao;
    private PreparedStatement pstmt;
    private Conexao poolMySQL;

    public FichaMedicaDAO() {
        poolMySQL = new Conexao("localhost", "cbr", "root", "");
    }
    
    @Override
    public int incluir(FichaMedica fichaMedica) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "INSERT INTO `ficha_medica` (`fic_codigo` , `fic_sexo`, `fic_tipo_sanguineo`)VALUES (NULL, ?, ?)";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, fichaMedica.getSexo());
            pstmt.setString(2, fichaMedica.getTipoSang());            

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
    public int alterar(FichaMedica fichaMedica) {
              int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "UPDATE ficha_medica SET `fic_sexo`='?', `fic_tipo_sanguineo`='?' WHERE `fic_codigo`='?'";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, fichaMedica.getSexo());
            pstmt.setString(2, fichaMedica.getTipoSang());
            pstmt.setInt(3, fichaMedica.getCodigo());

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
    public int excluir(FichaMedica fichaMedica) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM ficha_medica WHERE codigo = '?'";
            pstmt = conexao.prepareStatement(sql);
            
            pstmt.setInt(1, fichaMedica.getCodigo());
            
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

            String sql = "select fic_codigo from ficha_medica where fic_codigo Like '%" + texto + "%'";
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
    
    public String[] select(int codPac)
    {
        int codFicha = 0;
        String[] pego = null;
        ResultSet rs = null, rs2 = null;
        int resultado = 0;
        int i = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "select ficha_medica_fic_codigo from paciente where pac_codigo=" + codPac;
            pstmt = conexao.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                codFicha = rs.getInt(1);
            } 
            
            rs.close();
            
            String sql2 = "select fic_sexo, fic_tipo_sanguineo from ficha_medica where fic_codigo=" + codFicha;
            pstmt = conexao.prepareStatement(sql2);
            rs2 = pstmt.executeQuery();
            
            while(rs2.next()){
                pego[i] = rs2.getString(1) + ";" + rs2.getString(2);
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

       public int selectUltimoCod()
    {
        int cod = 0;
        ResultSet rs = null;
        int i = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "select MAX(fic_codigo) from ficha_medica";
            pstmt = conexao.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                cod = rs.getInt(1);
            }

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

        return cod;
    }

}
