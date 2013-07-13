    package DAO;

import DAO.DAO;
import ProcessosBD.Caso;
import ProcessosBD.Conexao;
import ProcessosBD.Doenca;
import ProcessosBD.Sintoma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SintomaDAO implements DAO<Sintoma> {

    private Connection conexao;
    private PreparedStatement pstmt;
    private Conexao poolMySQL;

    public SintomaDAO() {
        poolMySQL = new Conexao("localhost", "cbr", "root", "");
    }

    @Override
    public int incluir(Sintoma sintoma) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "INSERT INTO `cbr`.`sintoma` (`sin_codigo`, `sin_nome`, `sin_descricao`, `sin_tipo`, `sin_pendente`)VALUES (null, ?, ?, ?, ?)";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, sintoma.getNome());
            pstmt.setString(2, sintoma.getDescricao());
            pstmt.setString(3, sintoma.getTipo());
            pstmt.setInt(4, sintoma.getPendente());

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
    public int alterar(Sintoma sintoma) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "UPDATE sintoma SET `sin_nome`, `sin_descricao`, `sin_tipo`, `sin_pendente` WHERE `sin_codigo` = '?'";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, sintoma.getNome());
            pstmt.setString(2, sintoma.getDescricao());
            pstmt.setString(3, sintoma.getTipo());
            pstmt.setInt(4, sintoma.getPendente());
            pstmt.setInt(5, sintoma.getCodigo());

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
    public int excluir(Sintoma sintoma) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM sintoma WHERE codigo = '?'";
            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, sintoma.getCodigo());

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

    public ArrayList<Sintoma> selectNomeParcial(String nomeParcial) {
        try {

            conexao = poolMySQL.connect();
            nomeParcial = nomeParcial.toUpperCase();
            String sql = "SELECT * FROM sintoma WHERE sin_nome LIKE '%" + nomeParcial + "%'";
            pstmt = conexao.prepareStatement(sql);
            ResultSet select = pstmt.executeQuery();
            ArrayList<Sintoma> retorno = new ArrayList<Sintoma>();
            while (select.next()) {
                Sintoma sintoma = new Sintoma();
                sintoma.setCodigo(select.getInt("sin_codigo"));
                sintoma.setDescricao(select.getString("sin_descricao"));
                sintoma.setNome(select.getString("sin_nome"));
                sintoma.setTipo(select.getString("sin_tipo"));
                sintoma.setPendente((select.getInt("sin_pendente") == 1)? 0:1);
                retorno.add(sintoma);
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
    
    public ArrayList<Sintoma> selectAll() {
        try {

            conexao = poolMySQL.connect();
            String sql = "SELECT * FROM sintoma";
            pstmt = conexao.prepareStatement(sql);
            ResultSet select = pstmt.executeQuery();
            ArrayList<Sintoma> retorno = new ArrayList<Sintoma>();
            while (select.next()) {
                Sintoma sintoma = new Sintoma();
                sintoma.setCodigo(select.getInt("sin_codigo"));
                sintoma.setDescricao(select.getString("sin_descricao"));
                sintoma.setNome(select.getString("sin_nome"));
                sintoma.setTipo(select.getString("sin_tipo"));
                sintoma.setPendente((select.getInt("sin_pendente") == 1)? 0:1);
                retorno.add(sintoma);
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
    
     public ArrayList<Sintoma> selectDoenca(Doenca doenca) {
        try {

            conexao = poolMySQL.connect();
            
            String sql = "SELECT `sin_codigo`, `sin_nome`, `sin_descricao`, `sin_tipo`, `sin_pendente` ,`sintoma_sin_codigo`, `doenca_doe_codigo`, `sdo_peso_clinico` FROM `sintoma`, `sintoma_has_doenca` WHERE `sintoma_sin_codigo` = `sin_codigo` AND `doenca_doe_codigo` = ? ORDER BY `sdo_peso_clinico` DESC";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, doenca.getCodigo());
            ResultSet select = pstmt.executeQuery();
            ArrayList<Sintoma> retorno = new ArrayList<Sintoma>();
            while (select.next()) {
                Sintoma sintoma = new Sintoma();
                sintoma.setCodigo(select.getInt("sin_codigo"));
                sintoma.setDescricao(select.getString("sin_descricao"));
                sintoma.setNome(select.getString("sin_nome"));
                sintoma.setTipo(select.getString("sin_tipo"));
                sintoma.setPendente((select.getInt("sin_pendente") == 1)? 0:1);
                retorno.add(sintoma);
            }
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

    public ArrayList<Sintoma> selectVarios(int limite) {
        try {

            conexao = poolMySQL.connect();
            
            String sql = "SELECT *FROM `sintoma` LIMIT 0 , ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, limite);
            ResultSet select = pstmt.executeQuery();
            ArrayList<Sintoma> retorno = new ArrayList<Sintoma>();
            while (select.next()) {
                Sintoma sintoma = new Sintoma();
                sintoma.setCodigo(select.getInt("sin_codigo"));
                sintoma.setDescricao(select.getString("sin_descricao"));
                sintoma.setNome(select.getString("sin_nome"));
                sintoma.setTipo(select.getString("sin_tipo"));
                sintoma.setPendente((select.getInt("sin_pendente") == 1)? 0:1);
                retorno.add(sintoma);
            }
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

    public ArrayList<Sintoma> selectCaso(Caso caso) {
        ArrayList<Sintoma> retorno = new ArrayList<Sintoma>();
        try {

            conexao = poolMySQL.connect();

            String sql = "SELECT `sintoma`.`sin_codigo`,`sintoma`.`sin_nome`,`sintoma`.`sin_descricao`,`sintoma`.`sin_tipo`,`sintoma`.`sin_pendente` FROM `sintoma`,`sintoma_has_caso` WHERE `sintoma`.`sin_codigo` =  `sintoma_has_caso`.`sintoma_sin_codigo` AND `caso_cas_codigo` = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, caso.getCodigo());

            ResultSet select = pstmt.executeQuery();
            while (select.next()) {
                Sintoma sintoma = new Sintoma();
                sintoma.setCodigo(select.getInt("sin_codigo"));
                sintoma.setDescricao(select.getString("sin_descricao"));
                sintoma.setNome(select.getString("sin_nome"));
                sintoma.setTipo(select.getString("sin_tipo"));
                sintoma.setPendente((select.getInt("sin_pendente") == 1)? 0:1);
                retorno.add(sintoma);
            }
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

    public Sintoma selectCodigo(int codigo) {
        try {

            conexao = poolMySQL.connect();

            String sql = "select * FROM sintoma WHERE sin_codigo = ? AND sin_pendente = 0;";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, codigo);


            ResultSet select = pstmt.executeQuery();
            select.first();
            Sintoma sintoma = new Sintoma();
            sintoma.setCodigo(codigo);
            sintoma.setDescricao(select.getString("sin_descricao"));
            sintoma.setNome(select.getString("sin_nome"));
            sintoma.setTipo(select.getString("sin_tipo"));
            sintoma.setPendente((select.getInt("sin_pendente") == 1)?0:1);

            return sintoma;

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
    
    public Sintoma selectNome(String nome) {
        try {

            conexao = poolMySQL.connect();

            String sql = "select * FROM sintoma WHERE sin_nome = ?;";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, nome);


            ResultSet select = pstmt.executeQuery();
            select.first();
            Sintoma sintoma = new Sintoma();
            sintoma.setCodigo(select.getInt("sin_codigo"));
            sintoma.setDescricao(select.getString("sin_descricao"));
            sintoma.setNome(select.getString("sin_nome"));
            sintoma.setTipo(select.getString("sin_tipo"));
            sintoma.setPendente((select.getInt("sin_pendente") == 1)?0:1);

            return sintoma;

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
    public ArrayList<Sintoma> selectPendentes() {
        ArrayList<Sintoma> retorno = new ArrayList<Sintoma>();
        try {

            conexao = poolMySQL.connect();

            String sql = "select * FROM sintoma WHERE sin_pendente = 0;";
            pstmt = conexao.prepareStatement(sql);
            

            ResultSet select = pstmt.executeQuery();
            while (select.next()) {
                Sintoma sintoma = new Sintoma();
                sintoma.setCodigo(select.getInt("sin_codigo"));
                sintoma.setDescricao(select.getString("sin_descricao"));
                sintoma.setNome(select.getString("sin_nome"));
                sintoma.setTipo(select.getString("sin_tipo"));
                sintoma.setPendente((select.getInt("sin_pendente") == 1)? 0:1);
                retorno.add(sintoma);
            }
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
}
