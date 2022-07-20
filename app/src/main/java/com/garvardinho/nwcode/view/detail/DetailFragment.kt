package com.garvardinho.nwcode.view.detail

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import com.garvardinho.nwcode.R
import com.garvardinho.nwcode.databinding.FragmentDetailBinding
import com.garvardinho.nwcode.model.retrofit.PhotoDTO
import com.garvardinho.nwcode.presenter.detail.DetailPresenter
import com.squareup.picasso.RequestCreator
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class DetailFragment : MvpAppCompatFragment(), DetailView {
    private var _photo: PhotoDTO? = null
    private val bigPhoto get() = _photo!!
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val presenter by moxyPresenter { DetailPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            _photo = it.getParcelable(DETAIL)
            setPhotoUrl()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun showPhoto(picasso: RequestCreator) {
        picasso
            .placeholder(AppCompatResources.getDrawable(
                requireContext(),
                R.drawable.ic_photo_film)!!)
            .into(binding.detailImage)
    }

    override fun setPhotoUrl() {
        presenter.loadBigPhoto(bigPhoto)
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
        private const val DETAIL = "detail"

        fun newInstance(photo: PhotoDTO) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(DETAIL, photo)
                }
            }
    }
}