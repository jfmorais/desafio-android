package br.com.curymorais.tembicibycury

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.curymorais.tembicibycury.topgitrepos.TopGitReposFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_layout_constraint)
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            TopGitReposFragment()
        ).commit()
    }

}