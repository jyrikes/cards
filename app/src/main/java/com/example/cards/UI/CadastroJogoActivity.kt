package com.example.cards.UI

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cards.R
import com.example.cards.model.Jogo
import com.example.cards.repository.JogoRepository
import kotlinx.android.synthetic.main.activity_cadastro_jogo.*

class CadastroJogoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_jogo)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(androidx.core.R.menu.example_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            androidx.core.R.id.item1 -> {

                var id = salvarJogo()
                Toast.makeText(this,"Salvo !!${id}", Toast.LENGTH_SHORT).show()
            }
        }

        return true
    }

    private fun salvarJogo() : Int {
        //criar um objeto jogo
        val jogo = Jogo(
            nomeJogo = editTextNomedoJogo.text.toString(),
            notaJogo = ratingBarJogo.rating,
            console = spinerConsole.selectedItem.toString(),
        )
        val rep = JogoRepository(this)
        val id = rep.save(jogo)

        return id
    }
}