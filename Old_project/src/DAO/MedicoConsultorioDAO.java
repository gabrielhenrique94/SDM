package DAO;

import DAO.DAO;
import ProcessosBD.Conexao;
import ProcessosBD.Consultorio;
import ProcessosBD.MedicoConsultorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicoConsultorioDAO implements DAO<MedicoConsultorio>{

    private Connection conexao;
    private PreparedStatement pstmt, pstmt1, pstmt2;
    private Conexao poolMySQL;

    @Override
    public int incluir(MedicoConsultorio medConsultorio) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "INSERT INTO `cbr`.`medico_has_consultorio` (`medico_med_codigo` ,  `consultorio_con_codigo`)VALUES ('?', '?')";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, medConsultorio.getMedico().getCodigo());
            pstmt.setInt(2, medConsultorio.getConsultorio().getCodigo());
            

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
    public int alterar(MedicoConsultorio medConsultorio) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int excluir(MedicoConsultorio medConsultorio) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM medico_has consultorio WHERE medico_med_codigo = '?' AND consultorio_con_codigo = '?'";
            pstmt = conexao.prepareStatement(sql);
            
            pstmt.setInt(1, medConsultorio.getMedico().getCodigo());
            pstmt.setInt(2, medConsultorio.getConsultorio().getCodigo());            
            
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
    
    public Consultorio selecionador (String nomeMedico){
        Consultorio consultorio = new Consultorio();
        try {            
            conexao = poolMySQL.connect();            
            String sql = "SELECT med_codigo FROM medico WHERE med_nome = ?;";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, nomeMedico);

            ResultSet select = pstmt.executeQuery();
            select.first();
            
            int medCodigo = (select.getInt("med_codigo"));
            
            String sql1 = "SELECT consultorio_con_codigo FROM medico_has_consultorio WHERE medico_med_codigo = ?;";
            pstmt1 = conexao.prepareStatement(sql1);
            pstmt1.setInt(1, medCodigo);

            ResultSet select2 = pstmt1.executeQuery();
            select2.first();
            
            int conCodigo = (select2.getInt("consultorio_con_codigo"));
            
            String sql2 = "SELECT * FROM consultorio WHERE con_codigo = ?;";
            pstmt2 = conexao.prepareStatement(sql2);
            pstmt2.setInt(1, conCodigo);

            ResultSet select1 = pstmt2.executeQuery();
            select1.first();                        
                       
            consultorio.setCodigo(select1.getInt(conCodigo));
            consultorio.setIdentificacao(select1.getString("con_identificacao"));
            consultorio.setEndereco(select1.getString("con_endereco"));
            consultorio.setEndComplemento(select1.getString("con_end_complemento"));
            consultorio.setCidade(select1.getString("con_cidade"));
            consultorio.setUf(select1.getString("con_uf"));
            consultorio.setTelefone(select1.getInt("con_telefone"));
                        
            return consultorio;

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
        return consultorio;
    }
}
