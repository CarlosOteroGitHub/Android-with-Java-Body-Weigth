package com.example.myapplication;

public class Peso {

    private double masa, gravedad, res;

    public void setMasa (double valor1){
        masa=valor1;
    }

    public void setGravedad (double valor2){
        gravedad=valor2;
    }

    public void Peso (){
        res=masa*gravedad;
    }

    public double getResultado(){
        return res;
    }
}