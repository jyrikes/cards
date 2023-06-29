package com.example.cards.dataSource

class DataBaseDefinitions {
    object Jogo {
         const val TABLE_NAME = "tb1_jogo"
         object Columns{
             const val ID = "id"
             const val NOME_DO_JOGO = "nomeJogo"
             const val NOTA = "notaJogo"
             const val CONSOLE = "console"
         }
    }
}