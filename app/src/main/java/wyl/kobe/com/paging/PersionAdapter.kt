package wyl.kobe.com.paging

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

class PersionAdapter : PagedListAdapter<Persion, PersionAdapter.PersionViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PersionViewHolder(parent)

    override fun onBindViewHolder(holder: PersionViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Persion>() {
            override fun areItemsTheSame(oldItem: Persion?, newItem: Persion?): Boolean {
                return oldItem!!.id == newItem!!.id
            }

            override fun areContentsTheSame(oldItem: Persion?, newItem: Persion?) = oldItem!!.name == newItem!!.name
        }
    }

    class PersionViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            TextView(parent.context).apply {
                width = 500
                textSize = 16F
            }) {
        private var persion: Persion? = null

        fun bindData(persion: Persion?) {
            this.persion = persion
            (itemView as? TextView)?.text = persion?.name
        }
    }


}