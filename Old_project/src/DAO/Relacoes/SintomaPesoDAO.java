package DAO.Relacoes;

import DAO.DAO;
import DAO.DAO;
import ProcessosBD.Conexao;
import ProcessosBD.Doenca;
import ProcessosBD.Sintoma;
import ProcessosBD.SintomaPeso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SintomaPesoDAO implements DAO<SintomaPeso> {

    private Connection conexao;
    private PreparedStatement pstmt;
    private Conexao poolMySQL;

    public SintomaPesoDAO() {
        poolMySQL = new Conexao("localhost", "cbr", "root", "");
    }

    @Override
    public int incluir(SintomaPeso sintomaPeso) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "INSERT INTO `cbr`.`sintoma_has_doenca` (`sintoma_sin_codigo` , `doenca_doe_codigo`, `sdo_peso_clinico` )VALUES (?, ?, ?)";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, sintomaPeso.getCodigoSintoma().getCodigo());
            pstmt.setInt(2, sintomaPeso.getCodigoDoenca().getCodigo());
            pstmt.setFloat(3, sintomaPeso.getPesoClinico());

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
    public int alterar(SintomaPeso sintomaPeso) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "UPDATE sintoma_has_doenca SET `sdo_peso_clinico`= ? WHERE `sintoma_sin_codigo`= ? and `doenca_doe_codigo`= ? ";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setFloat(1, sintomaPeso.getPesoClinico());
            pstmt.setInt(2, sintomaPeso.getCodigoSintoma().getCodigo());
            pstmt.setInt(3, sintomaPeso.getCodigoDoenca().getCodigo());

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
    public int excluir(SintomaPeso sintomaPeso) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM sintoma_has_doenca WHERE doenca_doe_codigo= ? and sintoma_sin_codigo= ?";
            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, sintomaPeso.getCodigoDoenca().getCodigo());
            pstmt.setInt(2, sintomaPeso.getCodigoSintoma().getCodigo());

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

    public SintomaPeso selectSintomaDoenca(Sintoma sintoma, Doenca doenca) {
        try {
            conexao = poolMySQL.connect();
            String sql = "SELECT * FROM `sintoma_has_doenca` where `sintoma_sin_codigo` = ? AND `doenca_doe_codigo`= ?;";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, sintoma.getCodigo());

            pstmt.setInt(2, doenca.getCodigo());
            ResultSet select = pstmt.executeQuery();
            if (select.next()) {
                SintomaPeso sintomaPeso = new SintomaPeso(sintoma, doenca, 0.0F);
                sintomaPeso.setPesoClinico(select.getFloat("sdo_peso_clinico"));
                return sintomaPeso;
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
        return null;
    }

    public Boolean existeSintoma(SintomaPeso sintoma) {
        try {
            conexao = poolMySQL.connect();
            String sql = "SELECT * FROM `sintoma_has_doenca` where `sintoma_sin_codigo` = ? AND `doenca_doe_codigo`= ?;";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, sintoma.getSintoma().getCodigo());
            pstmt.setInt(2, sintoma.getDoenca().getCodigo());
            ResultSet select = pstmt.executeQuery();
            if (select.next()) {
                return true;
            } else {
                return false;
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
        return false;
    }
    
}
