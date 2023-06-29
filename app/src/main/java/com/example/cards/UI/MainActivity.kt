package com.example.cards.UI

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cards.R
import com.example.cards.adpters.JogosAdapter
import com.example.cards.repository.JogoRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addjogo.setOnClickListener(this)

    }
    override fun onResume(){
        initRecyclerView()
        super.onResume()
    }

    private fun initRecyclerView() {

        recycleJogos.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        val repo = JogoRepository(this)

        recycleJogos.adapter = JogosAdapter(repo.getJogos())
    }

    override fun onClick(v: View) {
        if(v.id ==R.id.addjogo){
            val intent = Intent(this, CadastroJogoActivity::class.java)
            startActivity(intent)
        }

    }
}