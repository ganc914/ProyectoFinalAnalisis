/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ALexico;

import java.io.File;

/**
 *
 * @author GusGus
 */
public class Principal {
    public static void main(String[] args) {
        String ruta = "D:/EstructuradeDatos/gitRepository/ProyectoFinalAnalisis/src/ALexico/Lexer.flex";
        generarLexer(ruta);
    }
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
}
