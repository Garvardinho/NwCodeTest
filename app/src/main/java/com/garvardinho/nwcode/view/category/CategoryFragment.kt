package com.garvardinho.nwcode.view.category

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.garvardinho.nwcode.App
import com.garvardinho.nwcode.databinding.FragmentCategoryBinding
import com.garvardinho.nwcode.presenter.category.CategoryPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class CategoryFragment : MvpAppCompatFragment(), CategoryView {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!
    private val presenter by moxyPresenter {
        CategoryPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    private val categoryAdapter by lazy {
        CategoryAdapter(presenter.textViewPresenter).apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setContentVisible(false)
    }

    override fun setContentVisible(visibility: Boolean) {
        binding.apply {
            if (visibility) {
                loadingIndicator.visibility = View.INVISIBLE
                categoriesView.visibility = View.VISIBLE
                categories.visibility = View.VISIBLE
            } else {
                loadingIndicator.visibility = View.VISIBLE
                categoriesView.visibility = View.INVISIBLE
                categories.visibility = View.INVISIBLE
            }
        }
    }

    override fun showCategories() {
        binding.categoriesView.adapter = categoryAdapter
        setContentVisible(true)
    }

    override fun showError(message: String) {
        AlertDialog.Builder(requireContext())
            .setTitle("Error")
            .setMessage(message)
            .setCancelable(true)
            .setPositiveButton("Got it!") { dialog, _ ->
                dialog.cancel()
            }.show()
    }
}