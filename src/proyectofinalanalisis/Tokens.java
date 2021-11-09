/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalanalisis;

/**
 *
 * @author gusta
 */
import java.io.BufferedReader;
//import java.io.IOException;
import java.io.InputStreamReader;

public class Tokens {

    // Tokens
    public Character tokens[]
            = {
                '+', '-', '*', '/', '(', ')','^'};

    public Character au = 'z';

    public void proceso() {

        System.out.print("                 CESBA          \n");
        System.out.print("Ingresa una operacion y presiona Enter \n");
        System.out.println();
    }

    public Character[] read() {
        String res = "";
        int longitud = 0;
        Character ch[];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Introduce la Expresion: ");
            do {
                res += in.readLine();
            } while (!res.endsWith(""));
        } catch (Exception ex) {
            System.out.println("Error " + ex);
        }
        longitud = res.length();
        ch = new Character[longitud];
        for (int i = 0; i < longitud; i++) {
            ch[i] = res.charAt(i);
        }
        return ch;
    }

    // Digitos
    public void esDigit(Character ch[]) {
        int cont = 0;
        String cualesSon = "";
        for (int i = 0; i < ch.length; i++) {
            if (au.isDigit(ch[i])) {
                cont++;
                cualesSon += ch[i].toString() + "|";
            }
        }
        tipos out = new tipos(cont, "Numeros", cualesSon);
        out.verTipos();
    }

//comprobamos
    public void esToken(Character ch[]) {
        int ope = 0;
        String cualesSon = "";
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < tokens.length; j++) {
                if (ch[i].equals(tokens[j])) {
                    ope++;
                    cualesSon += ch[i].toString() + "|";
                }
            }
        }
        tipos out = new tipos(ope, "Signos", cualesSon);
        out.verTipos();
    }

    // verificamos 
    public void esIdent(Character ch[]) {
        int Id = 0;
        String cualesSon = "";
        for (int i = 0; i < ch.length; i++) {
            if (au.isJavaIdentifierStart(ch[i])) {
                Id++;
                cualesSon += ch[i].toString() + "|";
            }
        }
        tipos out = new tipos(Id, "Identificadores", cualesSon);
        out.verTipos();
    }

}
