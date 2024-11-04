package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity implements View.OnClickListener {
    EditText txtLOGEmail, txtLOGSenha;
    Button btLOGAcessar, btLOGCadastro;
    String nome="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        txtLOGEmail = (EditText) findViewById(R.id.txtLOGEmail);
        txtLOGSenha = (EditText) findViewById(R.id.txtLOGSenha);
        btLOGAcessar = (Button) findViewById(R.id.btLOGAcessar);
        btLOGCadastro = (Button) findViewById(R.id.btLOGCadastro);

        btLOGAcessar.setOnClickListener(this);
        btLOGCadastro.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btLOGAcessar){
            // clicou no botão acessar
            if (validaDados()) {  // se digitou os dados e os dados são válidos//
                Intent tela = new Intent(this, menu2.class);
                startActivity(tela);
                Bundle parametros = new Bundle();
                parametros.putString("email",txtLOGEmail.getText().toString());
                parametros.putString("nome",nome);
                tela.putExtras(parametros);
                startActivity(tela);
            }
        }
        if (view.getId() == R.id.btLOGCadastro){
            // clicou no botão Cadastre_se
            Intent telaCadastro = new Intent(this,cadastro.class);
            startActivity(telaCadastro);
        }
    }
    public boolean validaDados() {
        boolean retorno = true;
        String msg= "";
        if (txtLOGEmail.getText().length() == 0 ){
            msg = "O campo E-mail não foi preenchido, por favor digite o seu E-mail";
            Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
            retorno = false;
        }else{
            if (txtLOGSenha.getText().length() == 0) {
                msg = "O campo SENHA não foi preenchido, por favor digite a Senha";
                Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
                retorno = false;
            }else{
                BancoController bd = new BancoController(getBaseContext());

                Cursor dados = bd.carregaDadosPeloEmailSenha(txtLOGEmail.getText().toString() , txtLOGSenha.getText().toString()) ;

                if(dados.moveToFirst()){
                    nome = dados.getString(1);
                    msg = "Email / Senha encontrado";
                }else{
                    msg= "O E-mail ou a Senha digitada não foram encontrados, por favor cadastre-se!";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                    retorno = false;
                }
            }
        }
        return retorno;
    }
}
