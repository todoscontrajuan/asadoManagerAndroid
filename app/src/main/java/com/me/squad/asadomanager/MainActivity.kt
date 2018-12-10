package com.me.squad.asadomanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: AsadosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val asadosList: ArrayList<Asado> = arrayListOf(Asado("Mi primer asado", 22, "22/07/09"),
                Asado("Mi segundo asado", 20, "22/07/09"),
                Asado("Mi segundo asado", 20, "22/07/09"),
                Asado("Mi segundo asado", 20, "22/07/09"),
                Asado("Mi segundo asado", 20, "22/07/09"),
                Asado("Mi segundo asado", 20, "22/07/09"),
                Asado("Mi segundo asado", 20, "22/07/09"),
                Asado("Mi segundo asado", 20, "22/07/09"),
                Asado("Mi tercer asado", 3, "22/07/09"))

        linearLayoutManager = LinearLayoutManager(this)
        asados_container.layoutManager = linearLayoutManager
        adapter = AsadosAdapter(asadosList)
        asados_container.adapter = adapter

        setSupportActionBar(bottom_app_bar)
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
