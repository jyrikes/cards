package com.example.cards.model

data class Jogo(
    var id : Int,
    var nomeJogo : String,
    var notaJogo : Float,
    var console : String

) {
    constructor(nomeJogo: String, notaJogo: Float, console: String) : this(0, nomeJogo, notaJogo, console)
}