package br.com.danielideriba.persistencia

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences = getSharedPreferences("myprefs", Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("MANTER_LOGADO", false)){
            startActivity(Intent(this, ListaActivity::class.java))
            finish()
        }

        cbManter.setOnClickListener({
            val editor = sharedPreferences.edit()
            editor.putBoolean("MANTER_LOGADO", true)
            editor.putString("USUARIO", etNome.text.toString())
            editor.apply()
            startActivity(Intent(this, ListaActivity::class.java))
            finish()
        })
    }
}
