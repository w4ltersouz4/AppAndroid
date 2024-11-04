package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class SelecionaData extends AppCompatActivity implements View.OnClickListener {
    Button btCONPesquisar;
    DatePicker txtCONData;
    String _email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleciona_data);

        Intent intencao = getIntent();
        Bundle parametros = intencao.getExtras();
        _email = parametros.getString("email");

        btCONPesquisar = (Button) findViewById(R.id.btCONPesquisar);
        txtCONData = (DatePicker) findViewById(R.id.txtCONData);

        btCONPesquisar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int mes = txtCONData.getMonth() + 1;
        String data = txtCONData.getDayOfMonth() + "/" + mes + "/" + txtCONData.getYear();
        Intent tela = new Intent(this, lista_agendamento.class);

        Bundle parametros = new Bundle();
        parametros.putString("data_consulta",data);
        tela.putExtras(parametros);

        startActivity(tela);

        Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
    }
}