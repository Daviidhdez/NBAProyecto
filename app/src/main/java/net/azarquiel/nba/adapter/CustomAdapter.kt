package net.azarquiel.recyclerviewpajaros.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import net.azarquiel.nba.R
import net.azarquiel.nba.model.Team


/**
 * Created by pacopulido on 9/10/18.
 */
class CustomAdapter(val context: Context,
                    val layout: Int
                    ) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var dataList: List<Team> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewlayout = layoutInflater.inflate(layout, parent, false)
        return ViewHolder(viewlayout, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    internal fun setTeams(teams: List<Team>) {
        this.dataList = teams
        notifyDataSetChanged()
    }


    class ViewHolder(viewlayout: View, val context: Context) : RecyclerView.ViewHolder(viewlayout) {
        fun bind(teams: Team){
            // itemview es el item de diseño
            // al que hay que poner los datos del objeto dataItem
            val ivrownba = itemView.findViewById(R.id.ivrownba) as ImageView
            val tvrowname = itemView.findViewById(R.id.tvrowname) as TextView
            val tvrowconference = itemView.findViewById(R.id.tvrowconference) as TextView
            val tvrowrecord = itemView.findViewById(R.id.tvrowrecord) as TextView

            tvrowname.text = teams.name
            tvrowconference.text = "${teams.conference}"
            tvrowrecord.text = "${teams.record}"

            // foto de internet a traves de Picasso
            Picasso.get().load("${teams.teamLogoUrl}").into(ivrownba)

            itemView.tag = teams

        }

    }
}