package wyl.kobe.com.paging

import android.arch.paging.ItemKeyedDataSource
import android.util.Log

class PersionDataSource : ItemKeyedDataSource<String, Persion>() {

    private var startPostion: Int = 0

    //初始数据
    override fun loadInitial(params: LoadInitialParams<String>, callback: LoadInitialCallback<Persion>) {
        val list = loadData(startPostion, params.requestedLoadSize)
        callback.onResult(list)
        startPostion += params.requestedLoadSize
    }

    //加载的数据
    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<Persion>) {
        val list = loadData(startPostion, params.requestedLoadSize)
        callback.onResult(list)
        startPostion += params.requestedLoadSize
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<Persion>) {
        Log.e("wyl", "开始准备加载数据")
    }

    override fun getKey(item: Persion): String {
        return item.id
    }

    private fun loadData(startPostion: Int, limit: Int): ArrayList<Persion> {
        val list = ArrayList<Persion>()
        for (i in 0..limit) {
            val persion = Persion(startPostion.toString(), "Persion${startPostion + i}")
            list.add(persion)
        }
        return list
    }

}