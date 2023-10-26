package net.azarquiel.nba

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.azarquiel.nba.model.Team
import net.azarquiel.recyclerviewpajaros.adapter.CustomAdapter
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: CustomAdapter
    private lateinit var rvteam: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvteam = findViewById<RecyclerView>(R.id.rvteam)
        initRV();
        getDatos();
    }

    private fun getDatos() {
        GlobalScope.launch() {
            val jsontxt = URL("http://www.ies-azarquiel.es/paco/apinba/teams").readText(Charsets.UTF_8)
            launch(Main) {
                val Team = Gson().fromJson(jsontxt, Array<Team>::class.java)
                adapter.setTeams(Team.toList())
            }
        }

    }

    private fun initRV() {
        adapter = CustomAdapter(this, R.layout.rownba)
        rvteam.adapter = adapter
        rvteam.layoutManager = LinearLayoutManager(this)
    }
}

