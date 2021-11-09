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
public class tipos {

    private int cont;
    private String tipo;
    private String diff;

    public tipos(int cont, String tipo, String diff) {
        setCont(cont);
        setTipo(tipo);
        setDiff(diff);
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }

    public int getCont() {
        return cont;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDiff() {
        return diff;
    }

    public void verTipos() {
        System.out.println("Los " + getTipo() + " son: ---> " + " [" + getDiff() + "]");
    }
}
