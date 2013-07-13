package DAO;

import ProcessosBD.Agenda;
import ProcessosBD.Conexao;
import ProcessosBD.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AgendaDAO implements DAO<Agenda> {

    private Connection conexao;
    private PreparedStatement pstmt;
    private Conexao poolMySQL;

    public AgendaDAO() {
        poolMySQL = new Conexao("localhost", "cbr", "root", "");
    }

    @Override
    public int incluir(Agenda agenda) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "INSERT INTO `cbr`.`agenda` (`age_codigo`, `age_data`, `age_queixa`, `paciente_pac_codigo`, `medico_med_codigo`)VALUES (null, ?, ?, ?, ?)";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setDate(1, agenda.getData());
            pstmt.setString(2, agenda.getQueixa());
            pstmt.setInt(3, agenda.getPaciente().getCodigo());
            pstmt.setInt(4, agenda.getMedico().getCodigo());

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
    public int alterar(Agenda agenda) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "UPDATE agenda SET `age_data`='?', `age_queixa`='?', "
                    + "`paciente_pac_codigo`='?', `medico_med_codigo`='?' WHERE `pac_codigo`='?'";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setDate(1, agenda.getData());
            pstmt.setString(2, agenda.getQueixa());
            pstmt.setInt(3, agenda.getPaciente().getCodigo());
            pstmt.setInt(4, agenda.getMedico().getCodigo());
            pstmt.setInt(5, agenda.getCodigo());

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
    public int excluir(Agenda agenda) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM paciente WHERE codigo = '?'";
            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, agenda.getCodigo());

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

    public ArrayList<Agenda> selectPorMedico(Medico medico) {
        ResultSet rs = null;
        try {
            

            String sql = "SELECT age_codigo, age_data, medico_med_codigo, paciente_pac_codigo FROM agenda WHERE medico_med_codigo= ? ORDER BY age_data";
            
            conexao = poolMySQL.connect();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, medico.getCodigo());
            rs = pstmt.executeQuery();
            PacienteDAO pacienteDAO = new PacienteDAO();

            ArrayList<Agenda> retorno = new ArrayList<Agenda>();
            while (rs.next()) {
                Agenda agenda = new Agenda();
                agenda.setCodigo(rs.getInt("age_codigo"));
                agenda.setData(rs.getDate("age_data"));
                agenda.setPaciente(pacienteDAO.selectCodigo(rs.getInt("paciente_pac_codigo")));
                agenda.setMedico(medico);
                retorno.add(agenda);
            }

            conexao.close();
            return retorno;
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

    public int relacaoMedicoPacicente(int codMed, int codPac) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "INSERT INTO `cbr`.`agenda` (`age_codigo`, `age_data`, `age_queixa`, `paciente_pac_codigo`, `medico_med_codigo`)VALUES (null, null, null, ?, ?)";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, codPac);
            pstmt.setInt(2, codMed);

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
