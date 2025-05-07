package id.mario.storemarketplace.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.mario.core.util.loadDrawable
import id.mario.storemarketplace.R
import id.mario.storemarketplace.databinding.ItemSectionProfileBinding
import id.mario.storemarketplace.viewmodel.model.AccountProfileModel

class ProfileAccountAdapter : RecyclerView.Adapter<ProfileAccountAdapter.MyViewHolder>() {
    private val diffCallBack = object : DiffUtil.ItemCallback<AccountProfileModel>() {
        override fun areItemsTheSame(
            oldItem: AccountProfileModel,
            newItem: AccountProfileModel
        ): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(
            oldItem: AccountProfileModel,
            newItem: AccountProfileModel
        ): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, diffCallBack)

    inner class MyViewHolder(private val binding: ItemSectionProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: AccountProfileModel) {
            binding.apply {
                ivIcon.loadDrawable(ContextCompat.getDrawable(root.context, data.icon))
                tvTitle.text = data.textTitle
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileAccountAdapter.MyViewHolder {
        return MyViewHolder(
            ItemSectionProfileBinding.bind(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_section_profile, parent, false
                )
            )
        )
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ProfileAccountAdapter.MyViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

}