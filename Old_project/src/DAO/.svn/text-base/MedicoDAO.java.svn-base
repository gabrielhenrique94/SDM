package DAO;

import DAO.DAO;
import ProcessosBD.Conexao;
import ProcessosBD.Medico;
import ProcessosBD.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicoDAO implements DAO<Medico> {

    private Connection conexao;
    private PreparedStatement pstmt;
    private Conexao poolMySQL;

    public MedicoDAO() {
        poolMySQL = new Conexao("localhost", "cbr", "root", "");
    }

    @Override
    public int incluir(Medico medico) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "INSERT INTO `cbr`.`medico` (`med_codigo` , `med_nome`, `med_rg`, `med_crm_numero`, `med_crm_uf`, `med_data_nascimento`, `med_endereco`, `med_end_complemento`, `med_cidade`, `med_UF`, `med_estado_civil`, `med_sexo`, `med_tel_residencial`, `med_tel_celular`, `usuario_usu_codigo`)VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, medico.getNome());
            pstmt.setString(2, medico.getRg());
            pstmt.setInt(3, medico.getCrmNumero());
            pstmt.setString(4, medico.getCrmUF());
            pstmt.setString(5, medico.getDataNasc());
            pstmt.setString(6, medico.getEndereco());
            pstmt.setString(7, medico.getEndComplemento());
            pstmt.setString(8, medico.getCidade());
            pstmt.setString(9, medico.getUF());
            pstmt.setString(10, medico.getEstadoCivil());
            pstmt.setString(11, medico.getSexo());
            pstmt.setInt(12, medico.getTelResidencial());
            pstmt.setInt(13, medico.getTelCelular());
            UsuarioDAO usuDAO = new UsuarioDAO();
            pstmt.setInt(14, usuDAO.selectUltimoCod());

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
    public int alterar(Medico medico) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "UPDATE medico SET `med_nome`='?', `med_rg`='?', `med_crm_numero`='?', `med_crm_uf`='?', `med_data_nascimento`='?', `med_endereco`='?', `med_end_complemento`='?', `med_cidade`='?', `med_UF`='?', `med_estado_civil`='?', `med_sexo`='?', `med_tel_residencial`='?', `med_tel_celular`='?', `usuario_usu_codigo`='?' WHERE `med_codigo`='?'";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, medico.getNome());
            pstmt.setString(2, medico.getRg());
            pstmt.setInt(3, medico.getCrmNumero());
            pstmt.setString(4, medico.getCrmUF());
            pstmt.setString(5, medico.getDataNasc());
            pstmt.setString(6, medico.getEndereco());
            pstmt.setString(7, medico.getEndComplemento());
            pstmt.setString(8, medico.getCidade());
            pstmt.setString(9, medico.getUF());
            pstmt.setString(10, medico.getEstadoCivil());
            pstmt.setString(11, medico.getSexo());
            pstmt.setInt(12, medico.getTelResidencial());
            pstmt.setInt(13, medico.getTelCelular());
            pstmt.setInt(14, medico.getUsuario().getCodigo());
            pstmt.setInt(15, medico.getCodigo());

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
    public int excluir(Medico medico) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM medico WHERE codigo = '?'";
            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, medico.getCodigo());

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

    public String[] selectNomeParcial(String texto) {
        String[] pego = null;
        ResultSet rs = null;
        int resultado = 0;
        int i = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "select med_nome from medico where med_nome Like '%" + texto + "%'";
            pstmt = conexao.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                pego[i] = rs.getString(1);
                i++;
            }

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

        return pego;
    }

    public Boolean confereUsuario(String usuario, String senha, String CRM) {


        try {

            conexao = poolMySQL.connect();

            String sql = "select * from usuario where usu_login ='?' AND usu_senha ='?' AND usu_crm_numero = '?'";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, usuario);
            pstmt.setString(2, senha);
            pstmt.setString(3, CRM);

            ResultSet resultado = pstmt.executeQuery();

            if (resultado.next()) {
                return true;
            } else {
                return false;
            }




        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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

    public Medico selectUsuario(Usuario usuario) {

        try {

            conexao = poolMySQL.connect();

            String sql = "select * from medico where usuario_usu_codigo = ? ";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, usuario.getCodigo());

            ResultSet resultado = pstmt.executeQuery();
            if (resultado.next()) {
                Medico medico = new Medico();
                medico.setCodigo(resultado.getInt("med_codigo"));
                medico.setNome(resultado.getString("med_nome"));
                medico.setRg(resultado.getString("med_rg"));
                medico.setCrmNumero(resultado.getInt("med_crm_numero"));
                medico.setCrmUF(resultado.getString("med_crm_uf"));
                medico.setEndereco(resultado.getString("med_endereco"));
                medico.setEndComplemento(resultado.getString("med_end_complemento"));
                medico.setCidade(resultado.getString("med_cidade"));
                medico.setUF(resultado.getString("med_uf"));
                medico.setEstadoCivil(resultado.getString("med_estado_civil"));
                medico.setSexo(resultado.getString("med_sexo"));
                medico.setTelCelular(resultado.getInt("med_tel_celular"));
                medico.setTelResidencial(resultado.getInt("med_tel_residencial"));
                medico.setUsuario(usuario);
                return medico;
            } else {
                return null;
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
}
