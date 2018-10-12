package br.com.danielideriba.persistencia

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import br.com.danielideriba.persistencia.dao.BancoDeDados
import br.com.danielideriba.persistencia.model.Game

class ListaGameViewModel(application: Application): AndroidViewModel(application) {
    lateinit var games: LiveData<List<Game>>
    private val bd: BancoDeDados =
            BancoDeDados.getDatabase(application.applicationContext)!!
    init{
        carregarDados()
    }
    private fun carregarDados() {
        games = bd.gameDAO().lerGames()
    }
}
