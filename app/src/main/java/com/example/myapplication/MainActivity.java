package com.example.myapplication;

/*

Author: ING. CARLOS OTERO RAMÍREZ

 */

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    double num1, gravedad = 9.81;

    private EditText editText1;
    private Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Peso de un Cuerpo");

        editText1 = findViewById(R.id.AM1_id2);
        button1 = findViewById(R.id.AM1_id3);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.AM1_id4);
        button2.setOnClickListener(this);
    }

    public void dialogoAlerta(String titulo, String mensaje){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(mensaje)
                .setTitle(titulo)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int posicion) {
                        dialog.cancel();
                    }
                });
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.AM1_id3:
                if(editText1.getText().toString().isEmpty()){
                    dialogoAlerta("Mensaje de Error", "El Campo de Texto esta Vacio");
                } else {
                    num1 = Double.parseDouble(editText1.getText().toString());
                    Peso objeto = new Peso();
                    objeto.setMasa(num1);
                    objeto.setGravedad(gravedad);
                    objeto.Peso();
                    dialogoAlerta("Mensaje de Información", "La masa que ingresaste es: " + num1 + "\n" + "La gravedad es una constante de 9.81" + "\n" + "El Resultado es: " + objeto.getResultado());
                }
                break;
            case R.id.AM1_id4:
                System.exit(0);
                break;
        }
    }
}