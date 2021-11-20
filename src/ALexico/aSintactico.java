/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ALexico;

//import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author GusGus
 */
public class aSintactico {

    /**
     * @param args the command line arguments
     */
     public static String Infijo2PosfijoTxt(String infijo){
		Pila3 p1 = Infijo2Posfijo(infijo);
		String text = "";
		while (p1.i > 0)
			text = p1.pop() + text;
		return text;
	}
   public static Pila3 Infijo2Posfijo(String infijo) {
		infijo +=')'; // Agregamos al final del infijo un &#8216;)&#8217
		int tamaño = infijo.length();
		Pila3 PilaDefinitiva = new Pila3(tamaño);
		Pila3 PilaTemp = new Pila3(tamaño);
		PilaTemp.push('('); // Agregamos a la pila temporal un &#8216;(&#8216;<br />
		for (int i = 0; i < tamaño; i++) {
			char caracter = infijo.charAt(i);
			switch (caracter) {
			case '(':
				PilaTemp.push(caracter);
				break;
			case '+':case '-':case '^':case '*':case '/':
				while (Jerarquia(caracter) <= Jerarquia(PilaTemp.nextPop()))
					PilaDefinitiva.push(PilaTemp.pop());
				PilaTemp.push(caracter);
				break;
			case ')':
				while (PilaTemp.nextPop() != '(')
					PilaDefinitiva.push(PilaTemp.pop());
				PilaTemp.pop();
				break;
			default:
				PilaDefinitiva.push(caracter);
			}
		}
		return PilaDefinitiva;
	}
   public static int Jerarquia(char elemento) {
		int res = 0;
		switch (elemento) {
		case ')':
			res = 5; break;
		case '^':
			res = 4; break;
		case '*': case '/':
			res = 3; break;
		case '+': case '-':
			res = 2; break;
		case '(':
			res = 1; break;
		}
		return res;
	}
   
   public static void main(String[] args){
       System.out.println("Dame la notacion en infijo");
       Scanner leer = new Scanner(System.in);
                String text=leer.nextLine();
		System.out.println("Posfijo : "+ Infijo2PosfijoTxt(text));
   }
}
