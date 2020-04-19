package com.curymorais.gittopreposbycury.topgitrepos

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.curymorais.gittopreposbycury.R
import com.curymorais.gittopreposbycury.util.OnLoadMoreListener
import com.curymorais.gittopreposbycury.util.RecyclerViewLoadMoreScroll
import kotlinx.android.synthetic.main.fragment_top_git_repos.*
import kotlinx.android.synthetic.main.list_top_git_repos.*

class TopGitReposFragment : Fragment(){

    val TAG = TopGitReposFragment::class.java.simpleName
    private lateinit var adapter: TopGitReposFragmentAdapter
    lateinit var llm : LinearLayoutManager
    private lateinit var viewModel: TopGitReposViewModel


    private lateinit var scrollListener: RecyclerViewLoadMoreScroll
    var page : Long = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_top_git_repos, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initComponents()
    }

    @SuppressLint("FragmentLiveDataObserve")
    fun initComponents() {
        adapter = TopGitReposFragmentAdapter()
        llm = LinearLayoutManager(activity)
        button_fab.setOnClickListener{loadMoreData()}

        recycler_item_list.adapter = adapter
        recycler_item_list.layoutManager = llm

        scrollListener = RecyclerViewLoadMoreScroll(llm)
        scrollListener.setOnLoadMoreListener(object :
            OnLoadMoreListener {
            override fun onLoadMore() {
                loadMoreData()
            }
        })
        recycler_item_list.addOnScrollListener(scrollListener)

        viewModel =  ViewModelProvider(this).get(TopGitReposViewModel::class.java)
        startViewModel()
    }

    private fun startViewModel() {

        viewModel.firstPage.observe(viewLifecycleOwner, Observer { itens ->
            itens?.let {
                adapter.updateList(it.items)
            }
        })

        viewModel.repos.observe(viewLifecycleOwner,Observer { itens ->
            adapter.updateList(itens.items)
            scrollListener.setLoaded()
        })
    }

    private fun loadMoreData() {
        page += 1
        viewModel.getMoreRepos(page)
    }


}

