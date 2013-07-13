/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

/**
 *
 * @author Gabriel
 */
public class MetodosUteis {
    //metodo achado na internet , com pequenas adaptações
    //fonte: http://robertwgil.wordpress.com/2008/12/26/truncate-doublefloat-com-java/

    public static String truncaDouble(double num, int numLength) {
        String stringDouble = String.valueOf(num);
        int iPoint = stringDouble.indexOf(".");
        if (numLength <= 0) {
            numLength = -1;
        }
        int iMore = stringDouble.length() - (iPoint + numLength + 1);
        if (iMore < 0) {
            for (int i = 0; i < (-iMore); i++) {
                stringDouble = stringDouble + "0";
            }
        } else {
            stringDouble = stringDouble.substring(0, iPoint + numLength + 1);
        }
        return stringDouble;
    }

    public static String truncaFloat(float num, int numLenght) {
        double numero = (double) num;
        return truncaDouble(numero, numLenght);
    }
}
