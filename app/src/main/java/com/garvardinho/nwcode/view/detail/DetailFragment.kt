package com.garvardinho.nwcode.view.detail

import android.app.AlertDialog
import android.app.WallpaperManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.toBitmap
import com.garvardinho.nwcode.App
import com.garvardinho.nwcode.R
import com.garvardinho.nwcode.databinding.FragmentDetailBinding
import com.garvardinho.nwcode.model.retrofit.PhotoDTO
import com.garvardinho.nwcode.presenter.detail.DetailPresenter
import com.garvardinho.nwcode.utils.FragmentInitializer
import com.garvardinho.nwcode.utils.KEY_PARAM
import com.squareup.picasso.RequestCreator
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class DetailFragment : MvpAppCompatFragment(), DetailView {
    private var _photo: PhotoDTO? = null
    private val bigPhoto get() = _photo!!
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val presenter by moxyPresenter {
        DetailPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            _photo = it.getParcelable(KEY_PARAM)
            setPhotoUrl()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.setAsWallpaperButton.setOnClickListener {
            WallpaperManager.getInstance(requireContext()).setBitmap(binding.detailImage.drawable.toBitmap())
            setDoneMessage()
        }
        return binding.root
    }

    private fun setDoneMessage() {
        AlertDialog.Builder(requireContext())
            .setTitle("Wallpaper")
            .setMessage("Done!")
            .setCancelable(true)
            .setPositiveButton("Got it!") { dialog, _ ->
                dialog.cancel()
            }.show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setContentVisible(false)
    }

    override fun showPhoto(picasso: RequestCreator) {
        picasso
            .placeholder(AppCompatResources.getDrawable(
                requireContext(),
                R.drawable.ic_photo_film)!!)
            .into(binding.detailImage)
        setContentVisible(true)
    }

    override fun setContentVisible(visibility: Boolean) {
        binding.apply {
            if (visibility) {
                loadingIndicator.visibility = View.INVISIBLE
                detailImage.visibility = View.VISIBLE
            } else {
                loadingIndicator.visibility = View.VISIBLE
                detailImage.visibility = View.INVISIBLE
            }
        }
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

    companion object : FragmentInitializer<PhotoDTO>
}