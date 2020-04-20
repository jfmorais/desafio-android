package br.com.curymorais.tembicibycury.reposPullDetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.curymorais.tembicibycury.R
import br.com.curymorais.tembicibycury.data.local.GitPulls
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_detail_pull.*

class DetailPullRepoFragmentAdapter : RecyclerView.Adapter<DetailPullRepoFragmentAdapter.ItemHolder>() {

    private var itemList : ArrayList<GitPulls> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_detail_pull,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(itemList[position])
    }

    class ItemHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer{

        fun bind(newItem: GitPulls) {
            Picasso.get().load(newItem.user.avatar_url).into(pull_img)
            pull_author_name.text = newItem.user.login
            pull_description.text = newItem.body
            pull_repo_name.text = newItem.title

        }
    }

    fun getItem(position: Int): GitPulls {
        return itemList[position]
    }

    fun removeAt(position: Int) : GitPulls {
        var itemToBeRemoved = itemList[position]
        itemList.removeAt(position)
        notifyItemRemoved(position)
        return itemToBeRemoved
    }

    fun updateList(list: ArrayList<GitPulls>){
        this.itemList.addAll(list)
        notifyDataSetChanged()
    }
}