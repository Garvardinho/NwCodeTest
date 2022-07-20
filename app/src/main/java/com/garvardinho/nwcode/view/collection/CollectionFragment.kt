package com.garvardinho.nwcode.view.collection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.garvardinho.nwcode.App
import com.garvardinho.nwcode.databinding.FragmentCollectionBinding
import com.garvardinho.nwcode.presenter.collection.CollectionPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class CollectionFragment : MvpAppCompatFragment(), CollectionView {

    private var _category: String? = null
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
            _category = it.getString(CATEGORY)
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
        binding.collectionView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.collectionView.adapter = collectionAdapter
    }

    companion object {
        private const val CATEGORY = "category"

        fun newInstance(category: String) =
            CollectionFragment().apply {
                arguments = Bundle().apply {
                    putString(CATEGORY, category)
                }
            }
    }
}