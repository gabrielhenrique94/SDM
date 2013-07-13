package DAO;

import DAO.DAO;
import ProcessosBD.Conexao;
import ProcessosBD.NovoSintoma;
import ProcessosBD.Sintoma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class NovoSintomaDAO implements DAO<NovoSintoma> {    
    private Connection conexao;
    private PreparedStatement pstmt;
    private Conexao poolMySQL;

    public NovoSintomaDAO() {
        poolMySQL = new Conexao("localhost", "cbr", "root", "");
    }

   @Override
    public int incluir(NovoSintoma novoSintoma) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();
            
            String sql = "INSERT INTO `cbr`.`novo_sintoma` (`nsi_codigo` , `nsi_tema`, `nsi_doenca`, `nsi_comentario`, `nsi_data`, `nsi_votos_favor`, `nsi_votos_contra`, `sintoma_sin_codigo`)VALUES (null, ?, ?, ?, CURRENT_DATE, ?, ?, ?)";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, novoSintoma.getTema());
            pstmt.setString(2, novoSintoma.getDoenca());
            pstmt.setString(3, novoSintoma.getComentario());
//            pstmt.setDate(4, novoSintoma.getDataPedido());
            pstmt.setInt(4, novoSintoma.getVotoFavor());
            pstmt.setInt(5, novoSintoma.getVotoContra());
            pstmt.setInt(6, novoSintoma.getSintoma().getCodigo());
            // isso deve ser cadastrado no bd junto com o sintoma de codigo igual ao campo novoSintoma.getSintoma().getCodigo()
                        
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
    public int alterar(NovoSintoma novoSintoma) {
              int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "UPDATE `novo_sintoma` SET `nsi_tema`='?', `nsi_doenca`='?', `nsi_comentario`='?', `nsi_data`='?', `nsi_voto_favor`='?', `nsi_voto_contra`='?', `sintoma_sin_codigo`='?' WHERE `nsi_codigo`='?'";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, novoSintoma.getTema());
            pstmt.setString(2, novoSintoma.getDoenca());
            pstmt.setString(3, novoSintoma.getComentario());
            pstmt.setDate(4, novoSintoma.getDataPedido());
            pstmt.setInt(5, novoSintoma.getVotoFavor());
            pstmt.setInt(6, novoSintoma.getVotoContra());
            pstmt.setInt(7, novoSintoma.getSintoma().getCodigo());
            pstmt.setInt(8, novoSintoma.getCodigo());

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
    public int excluir(NovoSintoma novoSintoma) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM `novo_sintoma` WHERE `nsi_codigo` = '?'";
            pstmt = conexao.prepareStatement(sql);
            
            pstmt.setInt(1, novoSintoma.getCodigo());
            
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
    
    public NovoSintoma selectCodigo(Sintoma sintoma) {
        try {            
            conexao = poolMySQL.connect();
                       
            String sql = "SELECT * FROM novo_sintoma WHERE sintoma_sin_codigo = ? ";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, sintoma.getCodigo());

            ResultSet select = pstmt.executeQuery();
            select.first();
                        
            NovoSintoma novoSintoma = new NovoSintoma();                        
            novoSintoma.setCodigo(select.getInt("nsi_codigo"));
            novoSintoma.setDoenca(select.getString("nsi_doenca"));
            novoSintoma.setComentario(select.getString("nsi_comentario"));
            novoSintoma.setDataPedido(select.getDate("nsi_data"));
            novoSintoma.setVotoFavor(select.getInt("nsi_voto_favor"));
            novoSintoma.setVotoContra(select.getInt("nsi_voto_contra"));
            novoSintoma.setSintoma(sintoma);
            novoSintoma.setVotoFavor(select.getInt("nsi_voto_favor"));
            
            return novoSintoma;            

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
        return null;
    }
}
