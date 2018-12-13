package com.me.squad.asadomanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: AsadosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(bottom_app_bar)

        // Mock data
        val attendants = listOf<String>("Juan", "Pepe", "Carlos")
        val attendants2 = listOf<String>()
        val asadosList: ArrayList<Asado> = arrayListOf(Asado("Mi primer asado", attendants, Date(), null, null),
                Asado("Mi segundo asado", attendants, Date(), "Casa de Tito", null),
                Asado("Mi tercer asado", attendants2, Date(), "Casa de Juan", "Nota mas larga e interesante para ver como funciona el texto"))

        linearLayoutManager = LinearLayoutManager(this)
        asados_container.layoutManager = linearLayoutManager
        adapter = AsadosAdapter(asadosList, this)
        asados_container.adapter = adapter

        fab.setOnClickListener {
            val intent = Intent(this, AsadoFormActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
                bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
            }
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_nav_drawer_menu, menu)
        return true
    }
}
