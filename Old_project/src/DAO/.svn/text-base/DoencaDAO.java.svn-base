package DAO;

import DAO.DAO;
import ProcessosBD.Conexao;
import ProcessosBD.Doenca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoencaDAO implements DAO<Doenca> {

    private Connection conexao;
    private PreparedStatement pstmt;
    private Conexao poolMySQL;
    int[] cod = null;
    String[] nome = null;
    String[] descricao = null;
    String[] causas = null;
    String[] agravamento = null;
    String[] tratamento = null;

    public DoencaDAO() {
        poolMySQL = new Conexao("localhost", "cbr", "root", "");
    }

    @Override
    public int incluir(Doenca doenca) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "INSERT INTO `cbr`.`doenca` (`doe_codigo`, `doe_nome`, `doe_descricao`, `doe_causas`, `doe_agravamento`, `doe_tratamento_base`, `doe_pendente`)VALUES (null, ?, ?, ?, ?, ?, ?)";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, doenca.getNome());
            pstmt.setString(2, doenca.getDescricao());
            pstmt.setString(3, doenca.getCausas());
            pstmt.setString(4, doenca.getAgravamento());
            pstmt.setString(5, doenca.getTratBase());
            pstmt.setInt(6, doenca.getPendente());

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
    public int alterar(Doenca doenca) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "UPDATE doenca SET `doe_nome`='?', `doe_descricao`='?', `doe_causas`='?', `doe_agravamento`='?', `doe_tratamento_base`='?', `doe_pendente`='?' WHERE `doe_codigo` = '?'";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, doenca.getNome());
            pstmt.setString(2, doenca.getDescricao());
            pstmt.setString(3, doenca.getCausas());
            pstmt.setString(4, doenca.getAgravamento());
            pstmt.setString(5, doenca.getTratBase());
            pstmt.setInt(6, doenca.getPendente());
            pstmt.setInt(7, doenca.getCodigo());

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
    public int excluir(Doenca doenca) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM doenca WHERE codigo = '?'";
            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, doenca.getCodigo());

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

    public Doenca selectCodigo(int codigo) {
        Doenca doenca = new Doenca();
        try {
            doenca.setCodigo(codigo);
            conexao = poolMySQL.connect();

            String sql = "select * FROM doenca WHERE doe_codigo = ?;";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, codigo);
            ResultSet select = pstmt.executeQuery();
            select.next();

            doenca.setNome(select.getString("doe_nome"));
            doenca.setAgravamento(select.getString("doe_agravamento"));
            doenca.setPendente((select.getInt("doe_pendente") == 1) ? 0 : 1);
            doenca.setDescricao(select.getString("doe_descricao"));
            doenca.setCausas(select.getString("doe_causas"));
            doenca.setTratamento(select.getString("doe_tratamento_base"));


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


        return doenca;
    }

    public Doenca select(Doenca doenca) {
        ResultSet rs = null;
        Doenca retorno = null;

        try {

            conexao = poolMySQL.connect();

            String sql = "SELECT doe_codigo FROM doenca WHERE "
                    + "doe_nome='" + doenca.getNome() + "' AND "
                    + "doe_descricao='" + doenca.getDescricao() + "' AND "
                    + "doe_causas='" + doenca.getCausas() + "' AND "
                    + "doe_agravamento='" + doenca.getAgravamento() + "' AND "
                    + "doe_tratamento_base='" + doenca.getTratBase() + "' AND "
                    + "doe_pendente='" + doenca.getPendente() + "'";
            pstmt = conexao.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                retorno = new Doenca(
                        rs.getInt("doe_codigo"), doenca.getNome(),
                        doenca.getDescricao(), doenca.getCausas(), doenca.getAgravamento(),
                        doenca.getTratBase(), doenca.getPendente());
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

        return retorno;
    }
    
    public ArrayList<Doenca> selectAll() {
        try {

            conexao = poolMySQL.connect();
            ArrayList<Doenca> retorno = new ArrayList<Doenca>();
            String sql = "SELECT * FROM doenca";
            pstmt = conexao.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
//            pstmt.setString(1, nomeParcial);
            while(resultSet.next()){
                Doenca doenca = new Doenca();
                doenca.setCodigo(resultSet.getInt("doe_codigo"));
                doenca.setNome(resultSet.getString("doe_nome"));
                doenca.setDescricao(resultSet.getString("doe_descricao"));
                doenca.setCausas(resultSet.getString("doe_causas"));
                doenca.setAgravamento(resultSet.getString("doe_agravamento"));
                doenca.setPendente(resultSet.getInt("doe_pendente"));
                doenca.setTratamento(resultSet.getString("doe_tratamento_base"));
                retorno.add(doenca);
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

    public ArrayList<Doenca> selectNomeParcial(String nomeParcial) {

        int i = 0;

        try {

            conexao = poolMySQL.connect();
            ArrayList<Doenca> retorno = new ArrayList<Doenca>();
            String sql = "SELECT * FROM `doenca` WHERE `doe_nome` LIKE '%" + nomeParcial + "%'";

            pstmt = conexao.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                Doenca doenca = new Doenca();
                doenca.setCodigo(resultSet.getInt("doe_codigo"));
                doenca.setNome(resultSet.getString("doe_nome"));
                doenca.setDescricao(resultSet.getString("doe_descricao"));
                doenca.setCausas(resultSet.getString("doe_causas"));
                doenca.setAgravamento(resultSet.getString("doe_agravamento"));
                doenca.setPendente(resultSet.getInt("doe_pendente"));
                doenca.setTratamento(resultSet.getString("doe_tratamento_base"));
                retorno.add(doenca);
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

    public Doenca selectPorCodigo(int codigo) {
        try {

            conexao = poolMySQL.connect();


            String sql = "select * FROM doenca WHERE doe_codigo = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, codigo);


            ResultSet select = pstmt.executeQuery();
            if (select.next()) {
                Doenca doe = new Doenca();
                doe.setCodigo(codigo);
                doe.setNome(select.getString("doe_nome"));
                doe.setDescricao(select.getString("doe_descricao"));
                doe.setCausas(select.getString("doe_causas"));
                doe.setAgravamento(select.getString("doe_agravamento"));
                doe.setTratamento(select.getString("doe_tratamento_base"));
                doe.setPendente(select.getInt("doe_pendente"));
                conexao.close();

                return doe;
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

    public Doenca selectPorNome(String nome) {
        try {

            conexao = poolMySQL.connect();


            String sql = "select * FROM doenca WHERE doe_nome = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, nome);


            ResultSet select = pstmt.executeQuery();
            if (select.next()) {
                Doenca doe = new Doenca();
                doe.setCodigo(select.getInt("doe_codigo"));
                doe.setNome(select.getString("doe_nome"));
                doe.setDescricao(select.getString("doe_descricao"));
                doe.setCausas(select.getString("doe_causas"));
                doe.setAgravamento(select.getString("doe_agravamento"));
                doe.setTratamento(select.getString("doe_tratamento_base"));
                doe.setPendente(select.getInt("doe_pendente"));
                conexao.close();

                return doe;
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

    public ArrayList<Doenca> selectPendentes() {
        ArrayList<Doenca> retorno = new ArrayList<Doenca>();
        try {            
            conexao = poolMySQL.connect();
            
            String sql = "SELECT * FROM doenca WHERE doe_pendente = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, 1);

            ResultSet select = pstmt.executeQuery();
            while (select.next()) {
                Doenca doe = new Doenca();
                doe.setCodigo(select.getInt("doe_codigo"));
                doe.setNome(select.getString("doe_nome"));
                doe.setDescricao(select.getString("doe_descricao"));
                doe.setCausas(select.getString("doe_causas"));
                doe.setAgravamento(select.getString("doe_agravamento"));
                doe.setTratamento(select.getString("doe_tratamento_base"));
                retorno.add(doe);
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
        return retorno;
    }
}
