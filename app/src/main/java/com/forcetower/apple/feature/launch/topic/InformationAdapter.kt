package com.forcetower.apple.feature.launch.topic

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.forcetower.apple.R
import com.forcetower.apple.core.model.Information
import com.forcetower.apple.core.model.Subject
import com.forcetower.apple.databinding.ItemInformationImageBinding
import com.forcetower.apple.databinding.ItemInformationTextBinding
import com.forcetower.apple.databinding.ItemInformationTitleBinding
import com.forcetower.apple.databinding.ItemInformationTopicBinding
import com.forcetower.apple.feature.shared.inflate
import java.lang.IllegalStateException

class InformationAdapter : RecyclerView.Adapter<InformationHolder>() {
    // Data holders layer
    var subject: Subject? = null
    set(value) {
        field = value
        buildMergedList(sub = value)
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
        return when (viewType) {
            R.layout.item_information_title -> InformationHolder.TitleHolder(parent.inflate(viewType))
            R.layout.item_information_image -> InformationHolder.ImageHolder(parent.inflate(viewType))
            R.layout.item_information_topic -> InformationHolder.TopicHolder(parent.inflate(viewType))
            R.layout.item_information_text  -> InformationHolder.WordsHolder(parent.inflate(viewType))
            else -> throw IllegalStateException("nothing defined for type $viewType")
        }
    }

    override fun onBindViewHolder(holder: InformationHolder, position: Int) {
        when (holder) {
            is InformationHolder.TitleHolder -> holder.binding.apply {
                subject = differ.currentList[position] as Subject
                executePendingBindings()
            }
            is InformationHolder.WordsHolder -> holder.binding.apply {
                info = differ.currentList[position] as Information
                executePendingBindings()
            }
            is InformationHolder.TopicHolder -> holder.binding.apply {
                info = differ.currentList[position] as Information
                executePendingBindings()
            }
            is InformationHolder.ImageHolder -> holder.binding.apply {
                info = differ.currentList[position] as Information
                executePendingBindings()
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = differ.currentList[position]
        return when (item) {
            is Subject -> R.layout.item_information_title
            is Information -> {
                when (item) {
                    item.text != null -> R.layout.item_information_text
                    item.image != null -> R.layout.item_information_image
                    item.subtitle != null -> R.layout.item_information_topic
                    else -> throw IllegalStateException("nothing defined for item $item")
                }
            }
            else -> throw IllegalStateException("nothing defined for item $item")
        }
    }

    // Merging function
    private fun buildMergedList(
        sub: Subject? = subject,
        infos: List<Information> = informations
    ): List<Any> {
        val list = mutableListOf<Any>()
        if (sub != null) list += sub
        list.addAll(infos)
        return list
    }
}

sealed class InformationHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    class TitleHolder(val binding: ItemInformationTitleBinding): InformationHolder(binding.root)
    class TopicHolder(val binding: ItemInformationTopicBinding): InformationHolder(binding.root)
    class WordsHolder(val binding: ItemInformationTextBinding) : InformationHolder(binding.root)
    class ImageHolder(val binding: ItemInformationImageBinding): InformationHolder(binding.root)
}

private object InformationCallback: DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return when {
            oldItem is Subject && newItem is Subject -> oldItem.id == newItem.id
            oldItem is Information && newItem is Information -> oldItem.id == newItem.id
            else -> false
        }
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return when {
            oldItem is Subject && newItem is Subject -> oldItem == newItem
            oldItem is Information && newItem is Information -> oldItem == newItem
            else -> true
        }
    }
}
