package com.example.ghiblifilms_ca

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ghiblifilms_ca.data.GhibliEntity
import com.example.ghiblifilms_ca.databinding.ListItemBinding

class FilmListAdapter(private val filmsList: List<GhibliEntity>,
    private val listener: ListItemListener) :

    RecyclerView.Adapter<FilmListAdapter.ViewHolder>() {

    val selectedFilm = arrayListOf<GhibliEntity>()

    inner class ViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
                val binding = ListItemBinding.bind(itemView)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = filmsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val film = filmsList[position]
        with(holder.binding) {
            filmName.text = film.title
            root.setOnClickListener {
                listener.onItemClick(film)
            }
        }
    }

    interface ListItemListener {
        fun onItemClick(film: GhibliEntity)
    }
}