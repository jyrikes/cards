package com.example.cards.repository

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import com.example.cards.dataSource.DataBaseDefinitions
import com.example.cards.dataSource.DataBaseHelper
import com.example.cards.model.Jogo

class JogoRepository(context: Context) {
    private val dbHelper = DataBaseHelper(context)

    fun save(jogo : Jogo):Int{
        //colocar em modo escrita
        val db = dbHelper.writableDatabase
        //criar o mapa
        val valores = ContentValues()
        valores.put(DataBaseDefinitions.Jogo.Columns.NOME_DO_JOGO ,jogo.nomeJogo)
        valores.put(DataBaseDefinitions.Jogo.Columns.CONSOLE ,jogo.console)
        valores.put(DataBaseDefinitions.Jogo.Columns.NOTA ,jogo.notaJogo)
        //inserindo os valores
        val id = db.insert(DataBaseDefinitions.Jogo.TABLE_NAME, null ,valores)
        return  id.toInt()
    }
    @SuppressLint("Range")
    fun getJogos():ArrayList<Jogo>{
        //colocar o banco de dados em modo leitura
        val db = dbHelper.readableDatabase
        val cursor = db.query(
            DataBaseDefinitions.Jogo.TABLE_NAME,null,null,null,null,null,null,null

        )
        var jogos = ArrayList<Jogo>()
        if(cursor!=null){
            while(cursor.moveToNext()){
                var jogo = Jogo(
                    cursor.getInt(cursor.getColumnIndex(DataBaseDefinitions.Jogo.Columns.ID)),
                    cursor.getString(cursor.getColumnIndex(DataBaseDefinitions.Jogo.Columns.NOME_DO_JOGO)),
                    cursor.getFloat(cursor.getColumnIndex(DataBaseDefinitions.Jogo.Columns.NOTA)),
                    cursor.getString(cursor.getColumnIndex(DataBaseDefinitions.Jogo.Columns.CONSOLE))
                )
                jogos.add(jogo)
            }
        }
        return jogos
    }

}