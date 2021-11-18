/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisisSintactico;

/**
 *
 * @author gusta
 */
public class Tokens {
    int size;
    char[] items;
    int i;

    Tokens(int tamaño){
        this.size=tamaño;
        this.items=new char[tamaño];
        this.i=0;
    }
    public boolean push(char item){
        if (i<size){
            items[i++]=item;
            return true;
        }
        
            return false;
        
    }
    public char pop(){
        if(i<=0)
            return 0;
           return items[--i];

    }
    public char nextPop(){
        if(i<=0)
            return 0;
        return items[i-1];
    }
}
