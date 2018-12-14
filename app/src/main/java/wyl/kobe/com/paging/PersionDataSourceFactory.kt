package wyl.kobe.com.paging

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource


class PersionDataSourceFactory : DataSource.Factory<String, Persion>() {
    val persionLiveData = MutableLiveData<PersionDataSource>()
    override fun create(): DataSource<String, Persion> {
        val dataSource = PersionDataSource()
        persionLiveData.postValue(dataSource)
        return dataSource
    }

}