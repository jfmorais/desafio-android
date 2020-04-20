package br.com.curymorais.tembicibycury.topJavaRepos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import br.com.curymorais.tembicibycury.R
import br.com.curymorais.tembicibycury.data.local.GitRepo
import br.com.curymorais.tembicibycury.reposPullDetail.DetailPullRepoFragment
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_repo.*


class TopGitReposFragmentAdapter() : RecyclerView.Adapter<TopGitReposFragmentAdapter.ItemHolder>() {


    private var itemList : ArrayList<GitRepo> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_repo,
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

    fun getItem(position: Int): GitRepo {
        return itemList[position]
    }

    fun removeAt(position: Int) : GitRepo {
        var itemToBeRemoved = itemList[position]
        itemList.removeAt(position)
        notifyItemRemoved(position)
        return itemToBeRemoved
    }

    fun updateList(list: ArrayList<GitRepo>){
        this.itemList.addAll(list)
        notifyDataSetChanged()
    }

    class ItemHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer, View.OnClickListener{

        init {
            containerView.setOnClickListener(this)
        }

        fun bind(newItem: GitRepo) {
            Picasso.get().load(newItem.owner.avatar_url).into(item_profile_img)
            item_repo_name.text = newItem.name //depois esse esse
            item_stars.text = newItem?.stargazers_count.toString()
            item_author_name.text = newItem.owner.login //primeiro esse
            item_description.text = newItem.description
            item_forks.text = "Forks: " + newItem.forks
        }

        override fun onClick(v: View?) {

            val bundle = Bundle()
            bundle.putString("user",item_author_name.text.toString())
            bundle.putString("repo",item_repo_name.text.toString())

            val activity = v!!.context as AppCompatActivity
            val myFragment: Fragment = DetailPullRepoFragment()
            myFragment.arguments = bundle
            activity.supportFragmentManager.beginTransaction().replace(R.id.fragment_container, myFragment).addToBackStack(null).commit()

        }
    }
}