package com.example.cards.dataSource

import com.example.cards.model.Jogo

class DataSource {
    companion object{
        fun getJogos() :ArrayList<Jogo>{
            var jogos = ArrayList<Jogo>()
            jogos.add(Jogo(100,"Residente Evil", 5.0f , "PS4"))
            jogos.add(Jogo(200,"Guitar Hero", 4.0f , "PS2"))

            return jogos
        }
    }
}