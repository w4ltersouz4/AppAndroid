package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class lista_agendamento extends AppCompatActivity {
    ListView lista;
    String data_consulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_agendamento);

        Intent intencao = getIntent();
        Bundle parametros = intencao.getExtras();
        data_consulta = parametros.getString("data_consulta");

        List<ModeloDados> listaAgendamento =null;

        listaAgendamento = consultaTodosAgendamentos(data_consulta);
        if (listaAgendamento!=null) {
            AgendaAdapter adaptador = new AgendaAdapter(this, listaAgendamento);

            lista = (ListView) findViewById(R.id.lista);
            lista.setAdapter(adaptador);
        }
    }

    private List<ModeloDados> consultaTodosAgendamentos(String _data) {
        List<ModeloDados> lista = new LinkedList<ModeloDados>();

        BancoController bd = new BancoController(getBaseContext());
        Cursor dados = bd.ConsultarAgendamentos(_data);

        if (dados.moveToFirst()){
            // se encontrou dados na tabela de agendamento
            do {
                ModeloDados item = new ModeloDados();
                item.setIdAgendamento(dados.getInt(0));
                item.setData(dados.getString(1));
                item.setHora(dados.getString(2));
                item.setEmail(dados.getString(3));
                item.setMateria(dados.getString(4));
                lista.add(item);
            } while (dados.moveToNext());
        }else{
            String msg = "Não há agendamentos efetuados";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            Intent telaInicio = new Intent(this, menu2.class);
            startActivity(telaInicio);
        }
        return lista;
    }
}