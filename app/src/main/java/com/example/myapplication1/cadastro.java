package com.example.myapplication1;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class cadastro extends AppCompatActivity implements View.OnClickListener {
    EditText txtCADNome, txtCADEmail, txtCADSenha;
    Button btCADGravar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);


        txtCADNome = (EditText) findViewById(R.id.txtCADNome);
        txtCADEmail = (EditText) findViewById(R.id.txtCADEmail);
        txtCADSenha = (EditText) findViewById(R.id.txtCADSenha);
        btCADGravar = (Button) findViewById(R.id.btCADGravar);


        btCADGravar.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (validaDados()==true){
            // gravardados
            SalvarDados();
        }
    }
    public boolean validaDados() {
        boolean retorno = true;
        String msg = "";
        if (txtCADNome.getText().length()==0){
            msg = "O campo NOME deve ser preenchido";
            Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
            retorno = false;
        }


        if (txtCADEmail.getText().length()==0){
            msg = "O campo EMAIL deve ser preenchido";
            Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (txtCADSenha.getText().length()==0){
            msg = "O campo de SENHA deve estar preenchido";
            Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
            retorno = false;
        }

        return retorno;
    }


    public void SalvarDados() {
        String msg = "";
        String nome = txtCADNome.getText().toString();
        String email = txtCADEmail.getText().toString();
        String senha = txtCADSenha.getText().toString();


        BancoController bd = new BancoController(getBaseContext());
        String resultado;


        resultado = bd.insereDadosUsuario(nome, email, senha);


        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        limpar();
    }
    public void limpar(){
        txtCADNome.setText("");
        txtCADEmail.setText("");
        txtCADSenha.setText("");

    }
}
