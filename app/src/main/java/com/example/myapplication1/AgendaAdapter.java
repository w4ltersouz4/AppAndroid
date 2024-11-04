package com.example.myapplication1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;


public class AgendaAdapter extends ArrayAdapter<ModeloDados> {


    private Context context;
    private List<ModeloDados> listaAgendamento = null;


    public AgendaAdapter(Context context, List<ModeloDados> listaAgendamento) {
        super(context, 0, listaAgendamento);
        this.listaAgendamento = listaAgendamento;
        this.context = context;
    }


    public View getView(int position, View view, ViewGroup parent){
        ModeloDados agendamento = listaAgendamento.get(position);


        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_item_lista, null);
        }
        TextView txtItemId = (TextView) view.findViewById(R.id.txtItemId);
        TextView txtItemData = (TextView) view.findViewById(R.id.txtItemData);
        TextView txtItemHora = (TextView)  view.findViewById(R.id.txtItemHora);
        TextView txtItemMateria = (TextView) view.findViewById(R.id.txtItemMateria);
        TextView txtItemEmail = (TextView) view.findViewById(R.id.txtItemEmail);


        txtItemId.setText(String.valueOf(agendamento.getIdAgendamento()));
        txtItemData.setText(String.valueOf(agendamento.getData()));
        txtItemHora.setText(String.valueOf(agendamento.getHora()));
        txtItemMateria.setText(String.valueOf(agendamento.getMateria()));
        txtItemEmail.setText(String.valueOf(agendamento.getEmail()));

        return view;
    }


}
