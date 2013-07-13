package DAO;

import DAO.DAO;
import ProcessosBD.Conexao;
import ProcessosBD.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO implements DAO<Usuario> {

    private Connection conexao;
    private PreparedStatement pstmt;
    private Conexao poolMySQL;

    public UsuarioDAO() {
        poolMySQL = new Conexao("localhost", "cbr", "root", "");
    }
    
    
    @Override
    public int incluir(Usuario usuario) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "INSERT INTO `cbr`.`usuario` (`usu_codigo` , `usu_login`, `usu_senha`, `usu_nivel`)VALUES (null, ?, ?, ?)";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setInt(3, usuario.getNivel());

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
    public int alterar(Usuario usuario) {
        int resultado = 0;

        try {

            conexao = poolMySQL.connect();

            String sql = "UPDATE usuario SET `usu_login`='?', `usu_senha`='?', `usu_nivel`='?' WHERE `usu_codigo`='?'";

            pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setInt(3, usuario.getNivel());
            pstmt.setInt(4, usuario.getCodigo());

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
    public int excluir(Usuario usuario) {
        int resultado = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "DELETE FROM usuario WHERE codigo = '?'";
            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, usuario.getCodigo());

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

    public Boolean confereUsuario(String usuario, String senha) {


        try {

            conexao = poolMySQL.connect();

            String sql = "select * from usuario where usu_login = ?  AND usu_senha =? ";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, usuario);
            pstmt.setString(2, senha);
            

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

    public Usuario selectLogin(String login) {
        try {

            conexao = poolMySQL.connect();

            String sql = "select * from usuario where usu_login = ? ";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, login);



            ResultSet resultado = pstmt.executeQuery();

            if (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setCodigo(resultado.getInt("usu_codigo"));
                usuario.setLogin(resultado.getString("usu_login"));
                usuario.setSenha(resultado.getString("usu_senha"));
                usuario.setNivel(resultado.getInt("usu_nivel"));
                return usuario;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
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
    
    public int contarModeradores(int nivel){
        try {

            conexao = poolMySQL.connect();

            String sql = " SELECT CONT(index) as numero FROM usuario where usu_nivel = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, nivel);

            ResultSet result = pstmt.executeQuery();
            int total = result.getInt("numero");            
            return total;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; //faz com que o resultado de negativo mostrando q deu erro
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

    public int selectUltimoCod()
    {
        int cod = 0;
        ResultSet rs = null;
        int i = 0;
        try {

            conexao = poolMySQL.connect();

            String sql = "select MAX(usu_codigo) from usuario";
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
