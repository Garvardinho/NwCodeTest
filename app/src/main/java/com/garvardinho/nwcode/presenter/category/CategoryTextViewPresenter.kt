package com.garvardinho.nwcode.presenter.category

import com.garvardinho.nwcode.model.retrofit.CollectionDTO
import com.garvardinho.nwcode.presenter.RecyclerViewPresenter
import com.garvardinho.nwcode.view.category.CategoryTextItemView

class CategoryTextViewPresenter(private val presenter: CategoryPresenter) : RecyclerViewPresenter<CategoryTextItemView> {

    private val categories = mutableListOf<CollectionDTO>()

    override fun bindView(view: CategoryTextItemView) {
        view.setText(categories[view.pos].title.orEmpty())
    }

    override fun getCount(): Int = categories.size

    override fun onClick(pos: Int) {
        presenter.onCategoryClick(categories[pos])
    }

    fun addCategories(categories: List<CollectionDTO>) {
        this.categories.addAll(categories)
    }
}
