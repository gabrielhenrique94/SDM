package DAO;

import DAO.DAO;
import ProcessosBD.Conexao;
import ProcessosBD.Doenca;
import ProcessosBD.NovaDoenca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class NovaDoencaDAO implements DAO<NovaDoenca>{
    private Connection conexao;
    private PreparedStatement pstmt;
    private Conexao poolMySQL;
    int[] cod = null;
    String[] sintomas = null;
    String[] comentário = null;
    String[] data = null;
    int[] votosContra = null;
    int[] votosFavor = null;
    

    public NovaDoencaDAO() {
        poolMySQL = new Conexao("localhost", "cbr", "root", "");
    }
    
   @Override
    public int incluir(NovaDoenca novaDoenca) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();
            
            String sql = "INSERT INTO `cbr`.`nova_doenca` (`ndo_codigo` , `ndo_tema`, `ndo_sintomas`, `ndo_comentario`, `ndo_data`, `ndo_votos_favor`, `ndo_votos_contra`, `doenca_doe_codigo`)VALUES (null, ?, ?, ?, CURRENT_DATE, ?, ?, ?)";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, novaDoenca.getTema());
            pstmt.setString(2, (novaDoenca.getSintomas()));
            pstmt.setString(3, novaDoenca.getComentario());
//            pstmt.setDate(4, novaDoenca.getDataPedido());
            pstmt.setInt(4, novaDoenca.getVotoFavor());
            pstmt.setInt(5, novaDoenca.getVotoContra());
            pstmt.setInt(6, novaDoenca.getDoenca().getCodigo());
                        
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
    public int alterar(NovaDoenca novaDoenca) {
              int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "UPDATE `nova_doenca` SET `ndo_tema`='?', `ndo_sintomas`='?', `ndo_comentario`='?', `ndo_data`='?', `ndo_voto_favor`='?', `ndo_voto_contra`='?', `doenca_doe_codigo`='?' WHERE `ndo_codigo`='?'";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, novaDoenca.getTema());
            pstmt.setString(2, novaDoenca.getSintomas());
            pstmt.setString(3, novaDoenca.getComentario());
            pstmt.setDate(4, novaDoenca.getDataPedido());
            pstmt.setInt(5, novaDoenca.getVotoFavor());
            pstmt.setInt(6, novaDoenca.getVotoContra());
            pstmt.setInt(7, novaDoenca.getDoenca().getCodigo());
            pstmt.setInt(8, novaDoenca.getCodigo());

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
    public int excluir(NovaDoenca novaDoenca) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM `nova_doenca` WHERE `ndo_codigo` = '?'";
            pstmt = conexao.prepareStatement(sql);
            
            pstmt.setInt(1, novaDoenca.getCodigo());
            
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
        
    public NovaDoenca selectCodigo(Doenca doenca) {
        try {            
            conexao = poolMySQL.connect();
                       
            String sql = "SELECT * FROM nova_doenca WHERE doenca_doe_codigo = ? ";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, doenca.getCodigo());

            ResultSet select = pstmt.executeQuery();
            select.first();
                        
            NovaDoenca novaDoenca = new NovaDoenca();                        
            novaDoenca.setCodigo(select.getInt("ndo_codigo"));
            novaDoenca.setSintomas(select.getString("ndo_sintomas"));
            novaDoenca.setComentario(select.getString("ndo_comentario"));
            novaDoenca.setDataPedido(select.getDate("ndo_data"));
            novaDoenca.setVotoFavor(select.getInt("ndo_voto_favor"));
            novaDoenca.setVotoContra(select.getInt("ndo_voto_contra"));
            novaDoenca.setDoenca(doenca);
            novaDoenca.setVotoFavor(select.getInt("ndo_voto_favor"));
                        
            return novaDoenca;            

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
    
    public void select() {
        try {            
            conexao = poolMySQL.connect();
                       
            String sql = "SELECT * FROM nova_doenca WHERE pendente = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, 0);
            int i = 0;
            
            ResultSet select = pstmt.executeQuery();
            while(select.next()){                        
                cod[i] = (select.getInt("ndo_codigo"));
                sintomas[i] = (select.getString("ndo_sintomas"));
                comentário[i] = (select.getString("ndo_comentario"));
                data[i] = (select.getDate("ndo_data")).toString();
                votosFavor[i] = (select.getInt("ndo_voto_favor"));
                votosContra[i] = (select.getInt("ndo_voto_contra"));
                
            }
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
    }
    
}