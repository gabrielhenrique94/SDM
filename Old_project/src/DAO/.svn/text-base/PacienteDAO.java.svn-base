package DAO;

import DAO.DAO;
import ProcessosBD.Conexao;
import ProcessosBD.Medico;
import ProcessosBD.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PacienteDAO implements DAO<Paciente> {

    private Connection conexao;
    private PreparedStatement pstmt;
    private Conexao poolMySQL;

    public PacienteDAO() {
        poolMySQL = new Conexao("localhost", "cbr", "root", "");
    }

    @Override
    public int incluir(Paciente paciente) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sqll = "INSERT INTO `cbr`.`paciente` (`pac_codigo` , `pac_nome`, `pac_rg`, `pac_cpf`, `pac_data_nascimento`, `pac_endereco`, `pac_end_complemento`, `pac_cidade`, `pac_uf`, `pac_estado_civil`, `pac_tel_residencial`, `pac_tel_celular`,`ficha_medica_fic_codigo`)VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
            pstmt = conexao.prepareStatement(sqll);

            java.sql.Date data = new java.sql.Date(paciente.getDataNasc().getTime());
            pstmt.setString(1, paciente.getNome());
            pstmt.setString(2, paciente.getRg());
            pstmt.setLong(3, paciente.getCpf());
            pstmt.setDate(4, data);
            pstmt.setString(5, paciente.getEndereco());
            pstmt.setString(6, paciente.getEndComplemento());
            pstmt.setString(7, paciente.getCidade());
            pstmt.setString(8, paciente.getUf());
            pstmt.setString(9, paciente.getEstadoCivil());
            pstmt.setInt(10, paciente.getTelResidencial());
            pstmt.setInt(11, paciente.getTelCelular());
            FichaMedicaDAO fm = new FichaMedicaDAO();
            int fmCod = fm.selectUltimoCod();
            pstmt.setInt(12, fmCod);

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
    public int alterar(Paciente paciente) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "UPDATE paciente SET `pac_nome`='?', `pac_rg`='?', `pac_cpf`='?', `pac_data_nascimento`='?', `pac_endereco`='?', `pac_end_complemento`='?', `pac_cidade`='?', `pac_uf`='?', `pac_estado_civil`='?', `pac_tel_residencial`='?', `pac_tel_celular`='?', `ficha_medica_fic_codigo`='?' WHERE `pac_codigo`='?'";

            pstmt = conexao.prepareStatement(sql);

            java.sql.Date data = java.sql.Date.valueOf(paciente.getDataNasc().toString());
            
            pstmt.setString(1, paciente.getNome());
            pstmt.setString(2, paciente.getRg());
            pstmt.setLong(3, paciente.getCpf());
            pstmt.setDate(4, data);
            pstmt.setString(5, paciente.getEndereco());
            pstmt.setString(6, paciente.getEndComplemento());
            pstmt.setString(7, paciente.getCidade());
            pstmt.setString(8, paciente.getUf());
            pstmt.setString(9, paciente.getEstadoCivil());
            pstmt.setInt(10, paciente.getTelResidencial());
            pstmt.setInt(11, paciente.getTelCelular());
            pstmt.setInt(12, paciente.getFichaMedica().getCodigo());
            pstmt.setInt(13, paciente.getCodigo());

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
    public int excluir(Paciente paciente) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM paciente WHERE codigo = ?";
            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, paciente.getCodigo());

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

    public ArrayList<Paciente> selectMedicoNomeParcial(Medico medico, String nomeParcial) {
        try {

            conexao = poolMySQL.connect();

            String sql = "SELECT `pac_codigo`, `pac_nome`, `pac_rg`, `pac_cpf`, `pac_data_nascimento`, `pac_endereco`, `pac_end_complemento`, `pac_cidade`, `pac_uf`, `pac_estado_civil`, `pac_tel_residencial`, `pac_tel_celular`, `ficha_medica_fic_codigo` FROM `paciente`,`agenda`WHERE `paciente_pac_codigo` = `pac_codigo` AND `pac_nome` LIKE '%" + nomeParcial + "%' AND `medico_med_codigo` = ?  ";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, medico.getCodigo());
            ResultSet resultSet = pstmt.executeQuery();
            ArrayList<Paciente> retorno = new ArrayList<Paciente>();
            while (resultSet.next()) {
                Paciente paciente = new Paciente();
                paciente.setCodigo(resultSet.getInt("pac_codigo"));
                paciente.setNome(resultSet.getString("pac_nome"));
                paciente.setRg(resultSet.getString("pac_RG"));
                paciente.setCpf(resultSet.getInt("pac_cpf"));
                paciente.setCidade(resultSet.getString("pac_cidade"));
                paciente.setDataNasc(resultSet.getDate("pac_data_nascimento"));
                paciente.setEndereco(resultSet.getString("pac_endereco"));
                paciente.setEndComplemento(resultSet.getString("pac_end_complemento"));
                paciente.setUf(resultSet.getString("pac_uf"));
                paciente.setEstadoCivil(resultSet.getString("pac_estado_civil"));
                paciente.setTelCelular(resultSet.getInt("pac_tel_celular"));
                paciente.setTelResidencial(resultSet.getInt("pac_tel_residencial"));
                retorno.add(paciente);
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

    public Paciente selectNome(String nome) {

        try {

            conexao = poolMySQL.connect();

            String sql = "SELECT * FROM `paciente`WHERE  `pac_nome`= ? ; ";

            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, nome);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                Paciente paciente = new Paciente();
                paciente.setCodigo(resultSet.getInt("pac_codigo"));
                paciente.setNome(resultSet.getString("pac_nome"));
                paciente.setRg(resultSet.getString("pac_rg"));
                paciente.setCpf(resultSet.getInt("pac_cpf"));
                paciente.setCidade(resultSet.getString("pac_cidade"));
                paciente.setDataNasc(resultSet.getDate("pac_data_nascimento"));
                paciente.setEndereco(resultSet.getString("pac_endereco"));
                paciente.setEndComplemento(resultSet.getString("pac_end_complemento"));
                paciente.setUf(resultSet.getString("pac_uf"));
                paciente.setEstadoCivil(resultSet.getString("pac_estado_civil"));
                paciente.setTelCelular(resultSet.getInt("pac_tel_celular"));
                paciente.setTelResidencial(resultSet.getInt("pac_tel_residencial"));
                return paciente;
            }
            return null;




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

    public Paciente selectRG(String rg) {
        try {

            conexao = poolMySQL.connect();

            String sql = "SELECT `pac_codigo`, `pac_nome`, `pac_rg`, `pac_cpf`, `pac_data_nascimento`, `pac_endereco`, `pac_end_complemento`, `pac_cidade`, `pac_uf`, `pac_estado_civil`, `pac_tel_residencial`, `pac_tel_celular`, `ficha_medica_fic_codigo` FROM `paciente` WHERE `pac_rg` = '?' ";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, rg);
            ResultSet resultSet = pstmt.executeQuery();
            Paciente paciente = new Paciente();
            while (resultSet.next()) {
                paciente.setCodigo(resultSet.getInt("pac_codigo"));
                paciente.setNome(resultSet.getString("pac_nome"));
                paciente.setRg(resultSet.getString("pac_rg"));
                paciente.setCpf(resultSet.getInt("pac_cpf"));
                paciente.setCidade(resultSet.getString("pac_cidade"));
                paciente.setDataNasc(resultSet.getDate("pac_data_nascimento"));
                paciente.setEndereco(resultSet.getString("pac_endereco"));
                paciente.setEndComplemento(resultSet.getString("pac_end_complemento"));
                paciente.setUf(resultSet.getString("pac_uf"));
                paciente.setEstadoCivil(resultSet.getString("pac_estado_civil"));
                paciente.setTelCelular(resultSet.getInt("pac_tel_celular"));
                paciente.setTelResidencial(resultSet.getInt("pac_tel_residencial"));
            }
            return paciente;




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

    public Paciente selectCodigo(int codigo) {
       
        try {

            conexao = poolMySQL.connect();

            String sql = "SELECT * FROM `paciente`WHERE  `pac_codigo`= ? ; ";

            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, codigo);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                Paciente paciente = new Paciente();
                paciente.setCodigo(resultSet.getInt("pac_codigo"));
                paciente.setNome(resultSet.getString("pac_nome"));
                paciente.setRg(resultSet.getString("pac_rg"));
                paciente.setCpf(resultSet.getLong("pac_cpf"));
                paciente.setCidade(resultSet.getString("pac_cidade"));
                paciente.setDataNasc(resultSet.getDate("pac_data_nascimento"));
                paciente.setEndereco(resultSet.getString("pac_endereco"));
                paciente.setEndComplemento(resultSet.getString("pac_end_complemento"));
                paciente.setUf(resultSet.getString("pac_uf"));
                paciente.setEstadoCivil(resultSet.getString("pac_estado_civil"));
                paciente.setTelCelular(resultSet.getInt("pac_tel_celular"));
                paciente.setTelResidencial(resultSet.getInt("pac_tel_residencial"));
                return paciente;
            }
            return null;




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

    public int selectUltimoCod()
    {
        int cod = 0;
        ResultSet rs = null;
        int i = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "select MAX(pac_codigo) from paciente";
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
