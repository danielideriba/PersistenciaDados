package br.com.danielideriba.persistencia

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import br.com.danielideriba.persistencia.R.id.fab
import br.com.danielideriba.persistencia.R.id.toolbar
import br.com.danielideriba.persistencia.model.Game
import android.arch.lifecycle.Observer

import kotlinx.android.synthetic.main.activity_lista.*
import kotlinx.android.synthetic.main.content_lista.*

class ListaActivity : AppCompatActivity() {

    private var adapter: GameAdapter? = null
    private var games: List<Game> = listOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            val dialog = NovoGameDialog()
            dialog.show(fragmentManager, "CriarJogo")
        }
        mostrarDados();
        rvGames.layoutManager = LinearLayoutManager(this)
        adapter = GameAdapter(games!!)
        rvGames.adapter = adapter
    }
    private fun mostrarDados() {
                ViewModelProviders.of(this)
                        .get(ListaGameViewModel::class.java)
                        .games
                        .observe(this, Observer<List<Game>> { games ->
                            adapter?.setList(games!!)
                            rvGames.adapter.notifyDataSetChanged()
                        })
    }

}
