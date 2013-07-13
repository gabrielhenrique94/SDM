package DAO.Relacoes;

import DAO.DAO;
import DAO.DAO;
import ProcessosBD.Caso;
import ProcessosBD.Conexao;
import ProcessosBD.Sintoma;
import ProcessosBD.SintomaCaso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SintomaCasoDAO implements DAO<SintomaCaso>{
    private Connection conexao;
    private PreparedStatement pstmt;
    private Conexao poolMySQL;

    public SintomaCasoDAO() {
        poolMySQL = new Conexao("localhost", "cbr", "root", "");
    }
    
     
    @Override
    public int incluir(SintomaCaso sintCaso) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "INSERT INTO `sintoma_has_caso`(`sintoma_sin_codigo`, `caso_cas_codigo`) VALUES (?,?)";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, sintCaso.getSintoma().getCodigo());
            pstmt.setInt(2, sintCaso.getCaso().getCodigo());

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
    public int alterar(SintomaCaso sintCaso) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int excluir(SintomaCaso sintCaso) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM sintoma_has_caso WHERE sintoma_sin_codigo = ? AND caso_cas_codigo = ?";
            pstmt = conexao.prepareStatement(sql);
            
            pstmt.setInt(1, sintCaso.getSintoma().getCodigo());
            pstmt.setInt(2, sintCaso.getCaso().getCodigo());
            
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
    public static void main(String[] args){
        Caso caso = new Caso();
        caso.setCodigo(40);
        Sintoma sintoma = new Sintoma();
        sintoma.setCodigo(110);
        SintomaCaso sintomaCaso = new SintomaCaso(sintoma, caso);
        SintomaCasoDAO dao = new SintomaCasoDAO();
        dao.incluir(sintomaCaso);
    }
}
