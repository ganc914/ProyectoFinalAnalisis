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
import java.util.Scanner;


public class analizador {

    public static void main(String carls[]) {
        Scanner teclado= new Scanner(System.in);
        //teclado.nextLine();
        int op;
        do {
            Character in[];
            Tokens token = new Tokens();
            token.proceso();
            in = token.read();
            token.esIdent(in);
            token.esToken(in);
            token.esDigit(in);
            System.out.println("");
            System.out.print("*** Presiona 1 para ingresar otra expresion o 2 para salir ***");
            op = teclado.nextInt();
        } while (op == 1);
        System.out.println("");
        System.out.println("Por: Gustavo ALfredo Navarrete Cruz");
    }

}
