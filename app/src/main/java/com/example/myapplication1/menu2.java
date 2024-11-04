package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class menu2 extends AppCompatActivity implements View.OnClickListener {
    TextView txtMENUser;
    ImageButton btMENAgendamentos, btMENAgendar;
    String _email="", _nome = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu2);

        Intent intencao = getIntent();
        Bundle parametros = intencao.getExtras();
        _nome = parametros.getString("nome");
        _email = parametros.getString("email");


        txtMENUser = (TextView) findViewById(R.id.txtMENUser);
        btMENAgendamentos = (ImageButton) findViewById(R.id.btMENAgendamentos);
        btMENAgendar = (ImageButton) findViewById(R.id.btMENAgendar);


        txtMENUser.setText("Seja bem-vindo: " + _nome);
        btMENAgendamentos.setOnClickListener(this);
        btMENAgendar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btMENAgendamentos){
            Intent tela = new Intent(this, SelecionaData.class);

            Bundle parametros = new Bundle();
            parametros.putString("nome",_nome);
            parametros.putString("email",_email);
            tela.putExtras(parametros);

            startActivity(tela);
        }
        if (view.getId()==R.id.btMENAgendar){
            Intent tela = new Intent(this, Agendamento.class);

            Bundle parametros = new Bundle();
            parametros.putString("nome",_nome);
            parametros.putString("email",_email);
            tela.putExtras(parametros);

            startActivity(tela);
        }


    }
}