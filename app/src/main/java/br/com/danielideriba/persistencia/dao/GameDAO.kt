package br.com.danielideriba.persistencia.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import br.com.danielideriba.persistencia.model.Game

@Dao
interface GameDAO {
    @Insert
    fun inserir(game: Game)
    @Query("SELECT * FROM Game")
    fun lerGames(): LiveData<List<Game>>
    @Query("SELECT * FROM Game WHERE id = :id")
    fun buscarPor(id: Int): Game
    @Update
    fun atualizar(game: Game)
    @Delete
    fun apagar(game: Game)
}
