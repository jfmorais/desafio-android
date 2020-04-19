package br.com.curymorais.tembicibycury

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.curymorais.tembicibycury.data.local.GitRepoOwner
import br.com.curymorais.tembicibycury.topgitrepos.TopGitReposFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.io.File

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_layout_constraint)
        collection()
        initComponents()
        setComponentListeners()
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            TopGitReposFragment()
        ).commit()


    }

    fun initComponents() {

    }

    fun setComponentListeners() {

    }

//    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
//        return false
//    }
//
//    private fun loadFragment(fragment : Fragment?) : Boolean{
//        if (fragment != null){
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, fragment)
//                .commit()
//            return  true
//        }
//        return false
//    }

    fun getGreet(name: String) = "Hello $name"

    fun collection() {
        val x = arrayOf(String)
        val y = arrayListOf<String>()
        val z = listOf(String)


        val ze = mapOf<Int, String>() //imutavel

        val xe = mutableMapOf<Int, String>() //mutavel
        xe[1] = "test"

        var gitrepo1 = GitRepoOwner("wewe", "wewew")
        var gitrepo2 = GitRepoOwner("wewe", "wewew")
        var gitrepo3 = gitrepo1.copy()
        var gitrepo4 = gitrepo1


        if (gitrepo1 == gitrepo2) {
            Log.i("CURY_R", "igual")
        } else {
            Log.i("CURY_R", "nao igual")
        }


    }

    fun main() {
        print("wqeq")
    }

//    var xxx : (String) -> print()
}