package kr.ac.hallym.prac08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import kr.ac.hallym.prac08.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main5)

        val binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        toggle = ActionBarDrawerToggle(this, binding.drawer,R.string.drawer_opened, R.string.drawer_closed)
        toggle.syncState()

        binding.mainDrawerView.setNavigationItemSelectedListener {
            Log.d("kkang", "navigation item is clicked: ${it.title}")
            true
        }

        binding.extFab.setOnClickListener {
            when(binding.extFab.isExtended){
                true -> binding.extFab.shrink()
                false -> binding.extFab.extend()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val menuItem = menu?.findItem(R.id.menu_search)
        val searchView = menuItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                //키보드의 검색 버튼을 클릭한 순간의 이벤트
                Log.d("kkang", "$query will be searched...")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //검색어 변경 이벤트
                return true
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.itemId) {
        R.id.menu_help -> {
            Log.d("kkang", "help is clicked...")
            true
        }
        R.id.menu_setting -> {
            Log.d("kkang", "setting is clicked...")
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}