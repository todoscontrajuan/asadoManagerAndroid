package com.me.squad.asadomanager

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: AsadosAdapter
    private val auth = FirebaseAuth.getInstance()!!
    private val RC_SIGN_IN = 123

    private val authListener: FirebaseAuth.AuthStateListener = FirebaseAuth.AuthStateListener {
        if (it.currentUser != null) {
            setupUI()
            getAsados()
        } else {
            // user is signed out
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setIsSmartLockEnabled(false)
                            .setAvailableProviders(Arrays.asList(AuthUI.IdpConfig.GoogleBuilder().build()))
                            .build(),
                    RC_SIGN_IN
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

    override fun onResume() {
        super.onResume()
        auth.addAuthStateListener(authListener)
    }

    override fun onPause() {
        super.onPause()
        auth.removeAuthStateListener(authListener)
    }

    private fun getAsados() {
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
    }

    private fun setupUI() {
        main_title.visibility = View.VISIBLE
        fab.setOnClickListener {
            val intent = Intent(this, AsadoFormActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode ==  RC_SIGN_IN){
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, getString(R.string.welcome_toast), Toast.LENGTH_LONG).show()
            } else if (resultCode == Activity.RESULT_CANCELED) {
                finish()
            }
        }
    }
}
