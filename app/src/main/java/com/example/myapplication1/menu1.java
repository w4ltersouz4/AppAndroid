package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;


public class menu1 extends AppCompatActivity implements View.OnClickListener {
    Button btIniciar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu1);


        btIniciar = (Button) findViewById(R.id.btIniciar);
        btIniciar.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btIniciar) {
            // clicou no botão acessar
            Intent telaInicio = new Intent(this, login.class);
            startActivity(telaInicio);


        }
    }
}

