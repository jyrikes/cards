package com.example.cards.adpters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cards.R
import com.example.cards.model.Jogo
import kotlinx.android.synthetic.main.layout_lista_jogos.view.*


class JogosAdapter(var listaJogos: ArrayList<Jogo>):RecyclerView.Adapter<JogosAdapter.JogoViewHolder>(){
    class JogoViewHolder (intemView: View) : RecyclerView.ViewHolder(intemView){
        fun bind(jogo: Jogo){

            itemView.textNomeDoJogo.text = jogo.nomeJogo
            itemView.textConsole.text = jogo.console
            itemView.notaJogo.rating = jogo.notaJogo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JogoViewHolder {
        val intemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_lista_jogos,parent,false)
        return  JogoViewHolder(intemView)
    }

    override fun onBindViewHolder(holder: JogoViewHolder, position: Int) {
        val jogo = listaJogos[position]
        holder.bind(jogo)
    }

    override fun getItemCount(): Int {
        return listaJogos.size
    }
}