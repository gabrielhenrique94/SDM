package DAO;

import DAO.Relacoes.SintomaPesoDAO;
import ProcessosBD.Caso;
import ProcessosBD.Conexao;
import ProcessosBD.Doenca;
import ProcessosBD.Medico;
import ProcessosBD.Sintoma;
import ProcessosBD.SintomaPeso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CasoDAO implements DAO<Caso> {

    private Connection conexao;
    private PreparedStatement pstmt;
    private Conexao poolMySQL;

    public CasoDAO() {
        poolMySQL = new Conexao("localhost", "cbr", "root", "");
    }

    @Override
    public int incluir(Caso caso) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "INSERT INTO `cbr`.`caso` (`cas_codigo` ,`cas_medicacoes_frequentes` ,`cas_idade_atual` ,`cas_altura` ,`cas_peso`,`cas_data` ,`medico_med_codigo` ,`doenca_doe_codigo`,)VALUES (NULL, ?, ?, ?, ?, CURRENT_DATE, ?, ?)";


            pstmt = conexao.prepareStatement(sql);
            

            pstmt.setString(1, caso.getMedicacoes());
            pstmt.setInt(2, caso.getIdade());
            pstmt.setFloat(3, caso.getAltura());
            pstmt.setFloat(4, caso.getPeso());
            pstmt.setInt(5, caso.getMedico().getCodigo());
            pstmt.setInt(6, caso.getDoenca().getCodigo());
            GregorianCalendar calendario = new GregorianCalendar();
     
            java.sql.Date sqlDate = new java.sql.Date( calendario.getTime().getTime() );
     
            pstmt.setDate( 7, sqlDate );

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
    public int alterar(Caso caso) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "UPDATE caso SET `cas_medicacoes_frequentes`='?' ,`cas_idade_atual`='?', `cas_altura`='?',`cas_peso`='?',`medico_med_codigo`='?',`doenca_doe_codigo`='?' ,`tratamento_tra_codigo`='?' WHERE `cas_codigo` = '?'";


            pstmt = conexao.prepareStatement(sql);


            pstmt.setString(1, caso.getMedicacoes());
            pstmt.setInt(2, caso.getIdade());
            pstmt.setFloat(3, caso.getAltura());
            pstmt.setFloat(4, caso.getPeso());
            pstmt.setInt(5, caso.getMedico().getCodigo());
            pstmt.setInt(6, caso.getDoenca().getCodigo());
            pstmt.setInt(7, caso.getCodigo());

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
    public int excluir(Caso caso) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM caso WHERE codigo = '?'";
            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, caso.getCodigo());

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

    public Caso selectPorCodigo(int codigo) {
        try {

            conexao = poolMySQL.connect();


            String sql = "select * FROM caso WHERE cas_codigo = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, codigo);


            ResultSet select = pstmt.executeQuery();
            if (select.next()) {
                Caso caso = new Caso();
                caso.setCodigo(codigo);
                caso.setMedicacoes(select.getString("cas_medicacoes_frequentes"));
                caso.setIdade(select.getInt("cas_idade_atual"));
                caso.setAltura(select.getFloat("cas_altura"));
                caso.setPeso(select.getFloat("cas_peso"));
                caso.setDoenca(new Doenca());
                caso.getDoenca().setCodigo(select.getInt("doenca_doe_codigo"));
                caso.setMedico(new Medico());
                caso.getMedico().setCodigo(select.getInt("medico_med_codigo"));
                conexao.close();
                SintomaDAO daoSintoma = new SintomaDAO();
                ArrayList<Sintoma> listaSintomas = daoSintoma.selectCaso(caso);
                Iterator i = listaSintomas.iterator();
                SintomaPesoDAO daoSintomaPeso = new SintomaPesoDAO();
                ArrayList<SintomaPeso> sintomas = new ArrayList<SintomaPeso>();
                while (i.hasNext()) {
                    Sintoma sintoma = (Sintoma) i.next();
                    SintomaPeso sintomaPeso = daoSintomaPeso.selectSintomaDoenca(sintoma, caso.getDoenca());
                    sintomas.add(sintomaPeso);
                }
                caso.setSintomas(sintomas);


                return caso;
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

    public Caso select(Caso caso) {
        try {

            conexao = poolMySQL.connect();


            String sql = "select * FROM caso WHERE cas_idade_atual = ? AND cas_altura = ? AND cas_peso = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, caso.getIdade());
            pstmt.setFloat(2, caso.getAltura());
            pstmt.setFloat(3, caso.getPeso());

            ResultSet select = pstmt.executeQuery();
            if (select.next()) {
                caso.setCodigo(select.getInt("cas_codigo"));
                caso.setMedicacoes(select.getString("cas_medicacoes_frequentes"));
                caso.setIdade(select.getInt("cas_idade_atual"));
                caso.setAltura(select.getFloat("cas_altura"));
                caso.setPeso(select.getFloat("cas_peso"));
                caso.setDoenca(new Doenca());
                caso.getDoenca().setCodigo(select.getInt("doenca_doe_codigo"));
                caso.setMedico(new Medico());
                caso.getMedico().setCodigo(select.getInt("medico_med_codigo"));

                SintomaDAO daoSintoma = new SintomaDAO();
                ArrayList<Sintoma> listaSintomas = daoSintoma.selectCaso(caso);
                Iterator i = listaSintomas.iterator();
                SintomaPesoDAO daoSintomaPeso = new SintomaPesoDAO();
                ArrayList<SintomaPeso> sintomas = new ArrayList<SintomaPeso>();
                while (i.hasNext()) {
                    Sintoma sintomaSelect = (Sintoma) i.next();
                    SintomaPeso sintomaPeso = daoSintomaPeso.selectSintomaDoenca(sintomaSelect, caso.getDoenca());
                    sintomas.add(sintomaPeso);
                }
                caso.setSintomas(sintomas);
                return caso;
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

    public ArrayList<Caso> selectSintoma(Sintoma sintoma) {
        try {
            conexao = poolMySQL.connect();

            String sql = "SELECT `cas_codigo`, `cas_medicacoes_frequentes`, `cas_idade_atual`, `cas_altura`, `cas_peso`, `cas_data`, `medico_med_codigo`, `doenca_doe_codigo` FROM `caso`,`sintoma_has_caso` WHERE `caso_cas_codigo`=`cas_codigo` AND `sintoma_sin_codigo` = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, sintoma.getCodigo());
            ResultSet select = pstmt.executeQuery();
            ArrayList<Caso> retorno = new ArrayList<Caso>();
            while (select.next()) {

                Caso caso = new Caso();
                caso.setCodigo(select.getInt("cas_codigo"));
                caso.setMedicacoes(select.getString("cas_medicacoes_frequentes"));
                caso.setIdade(select.getInt("cas_idade_atual"));
                caso.setAltura(select.getFloat("cas_altura"));
                caso.setPeso(select.getFloat("cas_peso"));
                caso.setDoenca(new Doenca());
                caso.getDoenca().setCodigo(select.getInt("doenca_doe_codigo"));
                caso.setMedico(new Medico());
                caso.getMedico().setCodigo(select.getInt("medico_med_codigo"));

                SintomaDAO daoSintoma = new SintomaDAO();
                ArrayList<Sintoma> listaSintomas = daoSintoma.selectCaso(caso);
                Iterator i = listaSintomas.iterator();
                SintomaPesoDAO daoSintomaPeso = new SintomaPesoDAO();
                ArrayList<SintomaPeso> sintomas = new ArrayList<SintomaPeso>();
                while (i.hasNext()) {
                    Sintoma sintomaSelect = (Sintoma) i.next();
                    SintomaPeso sintomaPeso = daoSintomaPeso.selectSintomaDoenca(sintomaSelect, caso.getDoenca());
                    sintomas.add(sintomaPeso);
                }
                caso.setSintomas(sintomas);
                retorno.add(caso);
            }
            return retorno;
        } catch (SQLException ex) {
            Logger.getLogger(CasoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public ArrayList<Caso> selectDoencaParcial(String doencaParcial) {
        try {

            conexao = poolMySQL.connect();
            doencaParcial = doencaParcial.toUpperCase();
            String sql = "SELECT * FROM caso WHERE doenca_doe_codigo LIKE '%" + doencaParcial + "%'";
            pstmt = conexao.prepareStatement(sql);
            ResultSet select = pstmt.executeQuery();
            ArrayList<Caso> retorno = new ArrayList<Caso>();
            while (select.next()) {
                Caso caso = new Caso();
                caso.setCodigo(select.getInt("cas_codigo"));
                caso.setMedicacoes(select.getString("cas_medicacoes_frequentes"));
                caso.setIdade(select.getInt("cas_idade_atual"));
                caso.setAltura(select.getFloat("cas_altura"));
                caso.setPeso(select.getFloat("cas_peso"));
                caso.setDoenca(new Doenca());
                caso.getDoenca().setCodigo(select.getInt("doenca_doe_codigo"));
                caso.setMedico(new Medico());
                caso.getMedico().setCodigo(select.getInt("medico_med_codigo"));
                retorno.add(caso);
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

        public ArrayList<Caso> selectporDoenca(int doenca) {
        try {

            conexao = poolMySQL.connect();
            String sql = "SELECT * FROM caso WHERE doenca_doe_codigo = '" + doenca + "'";
            pstmt = conexao.prepareStatement(sql);
            ResultSet select = pstmt.executeQuery();
            ArrayList<Caso> retorno = new ArrayList<Caso>();
            while (select.next()) {
                Caso caso = new Caso();
                caso.setCodigo(select.getInt("cas_codigo"));
                caso.setMedicacoes(select.getString("cas_medicacoes_frequentes"));
                caso.setIdade(select.getInt("cas_idade_atual"));
                caso.setAltura(select.getFloat("cas_altura"));
                caso.setPeso(select.getFloat("cas_peso"));
                caso.setDoenca(new Doenca());
                caso.getDoenca().setCodigo(select.getInt("doenca_doe_codigo"));
                caso.setMedico(new Medico());
                caso.getMedico().setCodigo(select.getInt("medico_med_codigo"));
                retorno.add(caso);
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
