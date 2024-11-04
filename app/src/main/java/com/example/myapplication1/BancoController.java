package com.example.myapplication1;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;


    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }

    //--------------------------------------------------------------------------------------------------
// inclusão de dados
    //inclusão de dados na tabela de Usuarios
    public String insereDadosUsuario(String txtNome, String txtEmail, String txtSenha) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();


        valores = new ContentValues();
        valores.put("nome", txtNome);
        valores.put("email", txtEmail);
        valores.put("senha", txtSenha);


        resultado = db.insert("usuarios", null, valores);
        db.close();


        if (resultado == -1)
            return "Erro ao inserir os dados do usuário!";
        else
            return "Dados Cadastrados com sucesso!";
    }


    //inclusão de dados na tabela de Pedidos
    //método para gravar os dados na tabela de agendamento
    public String insereDadosAgendamento(String _data, String _hora, String _email, String _materia) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();


        valores = new ContentValues();
        valores.put("data", _data);
        valores.put("hora", _hora);
        valores.put("email", _email);
        valores.put("materia", _materia);


        resultado = db.insert("agendamento", null, valores);
        db.close();


        if (resultado == -1)
            return "Erro ao inserir os dados do agendamento!";
        else
            return "Agendamento efetuado com sucesso!";
    }


//---------------------------------------------------------------------------------------------
// Consulta da Dados

    // consulta meus dados
    public Cursor consultaUsuario(String email) {
        Cursor cursor;
        //SELECT idUser, nome, cpf, email, senha FROM usuarios WHERE email = 'digitado'
        String[] campos = {"idUser", "nome", "email", "senha"};
        String where = "email = '" + email + "'";
        db = banco.getReadableDatabase();
        cursor = db.query("usuarios", campos, where, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }


    public Cursor consultaParaAgendar(String _data, String _hora) {
        Cursor cursor;
        //SELECT idAgendamento, data, hora, email FROM agendamento WHERE data = 'digitado' and hora = 'digitado'
        String[] campos = {"idAgendamento", "data", "hora"};
        String where = "data = '" + _data + "' and hora = '" + _hora + "'";
        db = banco.getReadableDatabase();
        cursor = db.query("agendamento", campos, where, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor ConsultarAgendamentos(String _data) {
        Cursor cursor;
        //SELECT idAgendamento, data, hora, email FROM agendamento
        String[] campos = {"idAgendamento", "data", "hora", "email","materia" };
        String filtro = "data = '" + _data + "'";
        db = banco.getReadableDatabase();
        cursor = db.query("agendamento", campos, filtro, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    // consulta dados para login / senha
    public Cursor carregaDadosPeloEmailSenha(String email,String senha){
        Cursor cursor;
        //SELECT idUser, nome, cpf, email, senha FROM usuarios WHERE email = 'digitado' and senha = 'digitada'
        String[] campos = { "idUser", "nome", "email", "senha" };
        String where = "email = '" + email + "' and senha = '" + senha + "' ";
        db = banco.getReadableDatabase();
        cursor = db.query("usuarios", campos, where, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    // consulta dados para login / senha



}

























