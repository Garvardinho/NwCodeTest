package com.garvardinho.nwcode.view.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.garvardinho.nwcode.databinding.CategoryTextViewBinding
import com.garvardinho.nwcode.presenter.RecyclerViewPresenter
import javax.inject.Inject

class CategoryAdapter @Inject constructor(
    private val textViewPresenter: RecyclerViewPresenter<CategoryTextItemView>
    ) : RecyclerView.Adapter<CategoryAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(CategoryTextViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        textViewPresenter.bindView(holder.apply { pos = position })
    }

    override fun getItemCount(): Int = textViewPresenter.getCount()

    inner class ItemViewHolder(private val textView: CategoryTextViewBinding) :
    RecyclerView.ViewHolder(textView.root),
    CategoryTextItemView {
        init {
            textView.root.setOnClickListener {
                textViewPresenter.onClick(pos)
            }
        }

        override var pos: Int = -1

        override fun setText(text: String) {
            textView.categoryText.text = text
        }
    }

}
