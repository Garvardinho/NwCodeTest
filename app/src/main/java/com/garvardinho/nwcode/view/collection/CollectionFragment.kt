package com.garvardinho.nwcode.view.collection

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.garvardinho.nwcode.App
import com.garvardinho.nwcode.databinding.FragmentCollectionBinding
import com.garvardinho.nwcode.model.retrofit.CollectionDTO
import com.garvardinho.nwcode.presenter.collection.CollectionPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class CollectionFragment : MvpAppCompatFragment(), CollectionView {

    private var _category: CollectionDTO? = null
    private val category get() = _category!!
    private var _binding: FragmentCollectionBinding? = null
    private val binding get() = _binding!!
    private val presenter by moxyPresenter {
        CollectionPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }
    private val collectionAdapter by lazy {
        CollectionAdapter(presenter.imageViewPresenter).apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            _category = it.getParcelable(CATEGORY)
            setCollectionCategory()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCollectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setCollectionCategory() {
        presenter.loadUrls(category)
    }

    override fun showPhotos() {
        binding.collectionView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.collectionView.adapter = collectionAdapter
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

    companion object {
        private const val CATEGORY = "category"

        fun newInstance(category: CollectionDTO) =
            CollectionFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(CATEGORY, category)
                }
            }
    }
}