package wyl.kobe.com.paging

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProvider.Factory
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = PersionAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val sourceFactory = PersionDataSourceFactory()
        val pagedListConfig = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(10)//定义第一页加载项目的数量
                .setPageSize(10)//定义从DataSource中每一次加载的项目数量
                .build()
        val pagedList = LivePagedListBuilder(sourceFactory, pagedListConfig)
                .build()
        pagedList.observe(this, Observer(adapter::submitList))
    }
}
