package br.com.curymorais.tembicibycury.detailpullrepo

import android.annotation.SuppressLint
import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.curymorais.tembicibycury.R
import br.com.curymorais.tembicibycury.data.local.GitPulls
import kotlinx.android.synthetic.main.fragment_detail_pull_repo.*
import kotlinx.android.synthetic.main.fragment_top_git_repos.*

class DetailPullRepoFragment : Fragment() {

    val TAG = DetailPullRepoFragment::class.java.simpleName
    private lateinit var adapter: DetailPullRepoFragmentAdapter
    lateinit var llm: LinearLayoutManager
    private lateinit var viewModel: DetailPullRepoViewModel
    private lateinit var viewModelFactory: DetailPullRepoViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_detail_pull_repo, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
    }

    @SuppressLint("FragmentLiveDataObserve")
    fun initComponents() {
        adapter = DetailPullRepoFragmentAdapter()
        llm = LinearLayoutManager(activity)

        var user = arguments!!.getString("user")!!
        var repo = arguments!!.getString("repo")!!

        recycler_pull_list.adapter = adapter
        recycler_pull_list.layoutManager = llm

        recycler_pull_list.addItemDecoration(DividerItemDecoration(context, HORIZONTAL))

        viewModelFactory = DetailPullRepoViewModelFactory(user, repo)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailPullRepoViewModel::class.java)
        startViewModel()
    }

    private fun startViewModel() {
        viewModel.firstPage.observe(viewLifecycleOwner, Observer { itens ->
            itens?.let {
                adapter.updateList(it as ArrayList<GitPulls>)
            }
        })
    }
}

