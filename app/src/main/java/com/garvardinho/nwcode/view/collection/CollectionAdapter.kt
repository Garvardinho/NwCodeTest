package com.garvardinho.nwcode.view.collection

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.garvardinho.nwcode.R
import com.garvardinho.nwcode.databinding.CollectionImageViewBinding
import com.garvardinho.nwcode.model.retrofit.PhotoDTO
import com.garvardinho.nwcode.presenter.RecyclerViewPresenter
import com.squareup.picasso.Picasso
import javax.inject.Inject

class CollectionAdapter @Inject constructor(
    private val imageViewPresenter: RecyclerViewPresenter<CollectionImageView>,
) : RecyclerView.Adapter<CollectionAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(CollectionImageViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        imageViewPresenter.bindView(holder.apply { pos = position })
    }

    override fun getItemCount(): Int = imageViewPresenter.getCount()

    inner class ItemViewHolder(private val imageView: CollectionImageViewBinding) :
        RecyclerView.ViewHolder(imageView.root),
        CollectionImageView {
        init {
            imageView.root.setOnClickListener {
                imageViewPresenter.onClick(pos)
            }
        }

        override var pos: Int = -1

        override fun setImage(image: PhotoDTO) {
            Picasso
                .get()
                .load(image.urls?.small)
                .placeholder(AppCompatResources.getDrawable(
                    imageView.root.context,
                    R.drawable.ic_photo_film)!!)
                .into(imageView.root)

            imageView.root.aspectRatio = image.height?.toDouble()!! / image.width?.toDouble()!!
        }
    }

}