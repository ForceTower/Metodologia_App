package com.forcetower.apple.feature.launch.subject

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.forcetower.apple.R
import com.forcetower.apple.core.model.Subject
import com.forcetower.apple.databinding.ItemSubjectBinding
import com.forcetower.apple.feature.shared.inflate

class SubjectAdapter(
    private val lifecycleOwner: LifecycleOwner,
    private val listener: SubjectActions
): ListAdapter<Subject, SubjectHolder>(SubjectDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SubjectHolder(parent.inflate(R.layout.item_subject))
    override fun onBindViewHolder(holder: SubjectHolder, position: Int) {
        holder.binding.apply {
            subject = getItem(position)
            actions = listener
            setLifecycleOwner(lifecycleOwner)
            executePendingBindings()
        }
    }

}

class SubjectHolder(val binding: ItemSubjectBinding): RecyclerView.ViewHolder(binding.root)

private object SubjectDiff: DiffUtil.ItemCallback<Subject>() {
    override fun areItemsTheSame(oldItem: Subject, newItem: Subject) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Subject, newItem: Subject) = oldItem == newItem
}