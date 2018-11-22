package com.forcetower.apple.feature.launch.topic

import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.forcetower.apple.core.model.Information

class InformationAdapter : RecyclerView.Adapter<InformationHolder>() {
    // Data holders layer
    var title: String = "Sem titulo"
    set(value) {
        field = value
        differ.submitList(buildMergedList(header = value))
    }

    var subtitle: String = "Nada a declarar"
        set(value) {
            field = value
            differ.submitList(buildMergedList(legend = value))
        }

    var informations: List<Information> = emptyList()
    set(value) {
        field = value
        differ.submitList(buildMergedList(infos = value))
    }

    private val differ = AsyncListDiffer<Any>(this, InformationCallback)

    // Adapter Methods
    override fun getItemCount() = differ.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformationHolder {
        //TODO("Criar especifico")
        return InformationHolder.Unamed(parent)
    }

    override fun onBindViewHolder(holder: InformationHolder, position: Int) {
        //TODO("Binding especifico")
    }

    override fun getItemViewType(position: Int): Int {
        //TODO("Retornar tipos especificos")
        return 0
    }

    // Merging function
    private fun buildMergedList(
        header: String = title,
        legend: String = subtitle,
        infos: List<Information> = informations
    ): List<Any> {
        val list = mutableListOf<Any>()
        return list
    }
}

sealed class InformationHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    //TODO Criar as classes filhas
    class Unamed(itemView: View): InformationHolder(itemView)
}

private object InformationCallback: DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return false
    }
}
