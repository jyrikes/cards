package com.example.cards.dataSource

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null,
    DATABASE_VERSION) {
    override fun onCreate(p0: SQLiteDatabase?) {
        if (p0 != null) {
            p0.execSQL(CREATE_TABLE_JOGO)
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
    companion object{
        private const val  DATABASE_NAME = "jogo.db"
        private const val  DATABASE_VERSION = 1
        private const val CREATE_TABLE_JOGO = "CREATE TABLE ${DataBaseDefinitions.Jogo.TABLE_NAME}(" +
                "${DataBaseDefinitions.Jogo.Columns.ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "${DataBaseDefinitions.Jogo.Columns.NOME_DO_JOGO} TEXT," +
                "${DataBaseDefinitions.Jogo.Columns.CONSOLE} TEXT," +
                "${DataBaseDefinitions.Jogo.Columns.NOTA} REAL);"
    }

}