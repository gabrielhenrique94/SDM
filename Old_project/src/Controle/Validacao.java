/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import ProcessosBD.Doenca;
import DAO.DoencaDAO;
import ProcessosBD.NovaDoenca;
import DAO.NovaDoencaDAO;
import ProcessosBD.NovoSintoma;
import DAO.NovoSintomaDAO;
import ProcessosBD.Sintoma;
import DAO.SintomaDAO;
import ProcessosBD.Usuario;
import DAO.UsuarioDAO;
import ProcessosBD.UsuarioNovaDoenca;
import DAO.UsuarioNovaDoencaDAO;
import DAO.UsuarioNovoSinDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author Gabriel
 */

public class Validacao {
    public final static char[] caracteres = {'!','@','#','$','%','¢','¬','¨','&','*','(',')','-','_','+','=','§','{','[','}',']','/','?','°','<','>',';','.',',','º','º','ª'};
    

    public boolean verificaIdade(String dia, String mes, String ano) {
        boolean retorno = true;

        System.out.println("Data é formada por " + dia + " " + mes + " " + ano);

        try {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setLenient(false);
            gc.set(GregorianCalendar.YEAR, Integer.parseInt(ano));
            gc.set(GregorianCalendar.MONTH, Integer.parseInt(mes) - 1);
            gc.set(GregorianCalendar.DATE, Integer.parseInt(dia));

            Date dt = gc.getTime();
            System.out.println("Deu o getTime();");

        } catch (Exception ex) {
            System.out.println(ex);
            retorno = true;
        }

        return retorno;
    }

    public int calculoIdade(String dia, String mes, String ano) {

        int idade = 0;
        int diaN = Integer.parseInt(dia);
        int mesN = Integer.parseInt(mes);
        int anoN = Integer.parseInt(ano);

        DateFormat dat = DateFormat.getDateInstance(DateFormat.LONG, new Locale("pt", "BR"));
        dat.format(new Date());

        int diaH = dat.getCalendar().getTime().getDate();
        int mesH = dat.getCalendar().getTime().getMonth();
        int anoH = dat.getCalendar().getTime().getYear() + 1900;

        if (mesN > mesH && diaN > diaH) {
            idade = (anoH - anoN) - 1;
        } else {
            idade = anoH - anoN;
        }

        return idade;
    }

 
    public boolean verificaSobrenome(String sobrenome) {
        boolean retorno = true;

        for (int i = 0; i < caracteres.length; i++) {
            if (i < 10) {
                if (sobrenome.indexOf(String.valueOf(i)) >= 0) {
                    retorno = false;
                }
            }
            if (sobrenome.indexOf(caracteres[i]) >= 0) {
                retorno = false;
            }
        }

        return retorno;
    }

    public boolean verificaTelefone(String telefone) {
        try {
            Integer.parseInt(telefone);
        } catch (NumberFormatException ex) {

            return false;
        }
        return true;
    }

    public boolean verificaCelular(String celular) {

        try {
            Integer.parseInt(celular);
        } catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }

    public boolean verificaLoginTamanho(String login) {
        if (login.length() < 10) {
            return false;
        } else {
            return true;
        }
    }

    public boolean verificaLoginValido(String login) {
        // login existente
        return true;
    }

    public boolean verificaCpf(String cpfNum) {

        int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        if ((cpfNum == null) || (cpfNum.length() != 11)) {
            return false;
        }

        Integer digito1 = calcularDigito(cpfNum.substring(0, 9), pesoCPF);
        Integer digito2 = calcularDigito(cpfNum.substring(0, 9) + digito1, pesoCPF);

        boolean valido = cpfNum.equals(cpfNum.substring(0, 9) + digito1.toString() + digito2.toString());

        
        return valido;

        
    }

    private int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    public static boolean verificaRG(String rg) {

        boolean retorno = true;
        int resto;

        rg = rg.trim().replace("-", "").replace(".", "");

        if (rg.contains(new String(caracteres))) {
            retorno = false;
        } else {
            if (rg.length() == 9) {

                rg = rg.toUpperCase();

                if (rg.substring(8).equals("X") || rg.substring(8).equals("x")) {

                    System.out.println("Achou o X!");

                    rg = rg.replace("X", "");
                    try {
                        resto = Integer.parseInt(rg);
                    } catch (Exception e) {
                        retorno = false;
                    }
                } else {
                    try {
                        resto = Integer.parseInt(rg);
                    } catch (Exception e) {
                        retorno = false;
                    }
                }

              
            } else {
                retorno = false;
            }
        }

        return retorno;
    }
    
    public static int VotaDoenca(int ctrl, Doenca doenca, Usuario usuario){
        
        int codUsu = usuario.getCodigo();
        UsuarioDAO usu = new UsuarioDAO();
        int total = usu.contarModeradores(2);//pegar qntdd de moderadores(nivel 2)
        
        NovaDoencaDAO novaDoenca = new NovaDoencaDAO();
        NovaDoenca nova = novaDoenca.selectCodigo(doenca);
        int codNova = nova.getCodigo();
        int votoFavor = nova.getVotoFavor();//pega qntdd de votos a favor
        int votoContra = nova.getVotoContra();
        String nomeDoenca = nova.getDoenca().getNome();
        
        UsuarioNovaDoencaDAO undDAO = new UsuarioNovaDoencaDAO();
        int votou = undDAO.votou(codNova, codUsu);
         
        if(votou==1){
            if(ctrl==1){//voto a favor, calcular %
                if(votoFavor/total >= 0.3){
                    votoFavor = votoFavor + 1;
                    nova.setVotoFavor(votoFavor);
                    novaDoenca.alterar(nova);
                    DoencaDAO doe = new DoencaDAO();
                    doenca.setPendente(1);
                    doe.alterar(doenca);
                    novaDoenca.excluir(nova);
                    //remover o item da lista
                }else{
                    votoFavor = votoFavor + 1;
                    nova.setVotoFavor(votoFavor);
                    novaDoenca.alterar(nova);
                }
            }else{//voto contra, calcular %
                if(votoContra/total >= 0.3){
                    votoContra = votoContra + 1;
                    nova.setVotoContra(votoContra);
                    novaDoenca.alterar(nova);
                    DoencaDAO doe = new DoencaDAO();
                    doe.excluir(doenca);
                    novaDoenca.excluir(nova);
                    DoencaDAO dao = new DoencaDAO();
                    ArrayList<Doenca> lista =  dao.selectPendentes();
                    //PricipalAbas.atualizaListaDoenca( lista);
                    //remover o item da lista
                }else{
                    votoContra = votoContra + 1;
                    nova.setVotoContra(votoContra);
                    novaDoenca.alterar(nova);
                }
            }
        }else{
            // mostrar janela falando que o usuario ja votou
        }
        return ctrl;
    }
    
    public static int VotaSintoma(int ctrl, Sintoma sintoma, Usuario usuario){
        
        int codUsu = usuario.getCodigo();
        UsuarioDAO usu = new UsuarioDAO();
        int total = usu.contarModeradores(2);//pegar qntdd de moderadores(nivel 2)
        
        NovoSintomaDAO novoSintoma = new NovoSintomaDAO();
        NovoSintoma novo = novoSintoma.selectCodigo(sintoma);
        int codSint = novo.getCodigo();
        int votoFavor = novo.getVotoFavor();//pega qntdd de votos a favor
        int votoContra = novo.getVotoContra();
        String nomeSintoma = novo.getSintoma().getNome();
        
        UsuarioNovoSinDAO unsDAO = new UsuarioNovoSinDAO();
        int votou = unsDAO.votou(codSint, codUsu);
        
        if(votou==1){      
            if(ctrl==1){//voto a favor, calcular %
                if(votoFavor/total >= 0.3){
                    votoFavor = votoFavor + 1;
                    novo.setVotoFavor(votoFavor);
                    novoSintoma.alterar(novo);
                    SintomaDAO sin = new SintomaDAO();
                    sintoma.setPendente(1);
                    sin.alterar(sintoma);
                    novoSintoma.excluir(novo);
                    //remover o item da lista
                }else{
                    votoFavor = votoFavor + 1;
                    novo.setVotoFavor(votoFavor);
                    novoSintoma.alterar(novo);
                }
            }else{//voto contra, calcular %
                if(votoContra/total >= 0.3){
                    votoContra = votoContra + 1;
                    novo.setVotoContra(votoContra);
                    novoSintoma.alterar(novo);
                    SintomaDAO sin = new SintomaDAO();
                    sin.excluir(sintoma);
                    novoSintoma.excluir(novo);
                    //remover o item da lista
                }else{
                    votoContra = votoContra + 1;
                    novo.setVotoContra(votoContra);
                    novoSintoma.alterar(novo);
                }
            }
        }else{
            // mostrar janela falando que o usuario ja votou
        }
        return ctrl;
    }
    
//    public static Date converteData(String mydata) {  
//       Date data = null;  
//       try {  
//          DateFormat dtOutput = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
//          data = dtOutput.parse(mydata);  
//       }catch (ParseException e) {  
//          e.printStackTrace();  
//       }  
//       return data;  
//
//    }
}
