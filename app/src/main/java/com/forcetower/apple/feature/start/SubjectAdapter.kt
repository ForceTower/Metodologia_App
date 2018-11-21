package com.forcetower.apple.feature.start

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.forcetower.apple.R
import com.forcetower.apple.databinding.ItemSubjectBinding
import com.forcetower.apple.feature.shared.inflate

class SubjectAdapter(
    private val lifecycleOwner: LifecycleOwner,
    private val listener: Any? //TODO Vai ser um viewModel
): ListAdapter<Any, SubjectHolder>(SubjectDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SubjectHolder(parent.inflate(R.layout.item_subject))
    override fun onBindViewHolder(holder: SubjectHolder, position: Int) {
        holder.binding.apply {
            //TODO Implementar o binding
        }
    }

}

class SubjectHolder(val binding: ItemSubjectBinding): RecyclerView.ViewHolder(binding.root)

private object SubjectDiff: DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any) = oldItem.hashCode() == newItem.hashCode() //TODO Trocar por id
    override fun areContentsTheSame(oldItem: Any, newItem: Any) = oldItem == newItem
}