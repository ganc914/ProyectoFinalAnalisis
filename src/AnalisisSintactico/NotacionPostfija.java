/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisSintactico;

import java.util.Scanner;

/**
 *
 * @author gusta
 */
public class NotacionPostfija {
     public static void main(String[] args) {
        System.out.println("Ingresa una expresion:");
        Scanner teclado = new Scanner(System.in);
        String op = teclado.nextLine();
        System.out.println(Infijo2PosfijoTxt(op));
//        do {
//            Character in[];
//            System.out.println("");
//            System.out.print("*** Presiona 1 para ingresar otra expresion o 2 para salir ***");
//            op = teclado.nextLine();
//        } while (op !=null);
        System.out.println("");
        System.out.println("Por: Gustavo Alfredo Navarrete Cruz");
    
    }

    /**
     * @param args the command line arguments
     */
    public static String Infijo2PosfijoTxt(String infijo) {
        Tokens p1 = Infijo2Posfijo(infijo);
        String op = "";
        while (p1.i > 0) {
            op = p1.pop() + op;
        }
        return op;
    }

    public static Tokens Infijo2Posfijo(String infijo) {
        infijo += ')'; // Agregamos al final del infijo un &#8216;)&#8217
        int size = infijo.length();
        Tokens PilaDefinitiva = new Tokens(size);
        Tokens PilaTemp = new Tokens(size);
        PilaTemp.push('('); // Agregamos a la pila temporal un &#8216;(&#8216;<br />
        for (int i = 0; i < size; i++) {
            char caracter = infijo.charAt(i);
            switch (caracter) {
                case '(':
                    PilaTemp.push(caracter);
                    break;
                case '+':
                case '-':
                case '^':
                case '*':
                case '/':
                    while (Orden(caracter) <= Orden(PilaTemp.nextPop())) {
                        PilaDefinitiva.push(PilaTemp.pop());
                    }
                    PilaTemp.push(caracter);
                    break;
                case ')':
                    while (PilaTemp.nextPop() != '(') {
                        PilaDefinitiva.push(PilaTemp.pop());
                    }
                    PilaTemp.pop();
                    break;
                default:
                    PilaDefinitiva.push(caracter);
            }
        }
        return PilaDefinitiva;
    }

    public static int Orden(char elemento) {
        int res = 0;
        switch (elemento) {
            case ')':
                res = 5;
                break;
            case '^':
                res = 4;
                break;
            case '*':
            case '/':
                res = 3;
                break;
            case '+':
            case '-':
                res = 2;
                break;
            case '(':
                res = 1;
                break;
        }
        return res;
    }

}
