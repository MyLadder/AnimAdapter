package vip.frendy.demo

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import vip.frendy.anim.animation.ScaleInAnimation
import vip.frendy.demo.adapter.ListAdpater

class MainActivity : Activity() {

    private val MOCK_DATA = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(i in 0..20) MOCK_DATA.add("Test ${i}")

        val mLayoutManager = LinearLayoutManager(this)
        list.layoutManager = mLayoutManager
        list.setOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val visibleItemCount = mLayoutManager.getChildCount()
                val totalItemCount = mLayoutManager.getItemCount()
                val pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition()

                if (visibleItemCount + pastVisiblesItems >= totalItemCount - 2) {
                    loadMore()
                }
            }
        })

        list.adapter = ListAdpater(MOCK_DATA, {
            toast(it)
        })

//        (list.adapter as ListAdpater).setAnimation(SlideInRightAnimation())
//        (list.adapter as ListAdpater).setAnimation(SlideInLeftAnimation())
//        (list.adapter as ListAdpater).setAnimation(SlideInBottomAnimation())
//        (list.adapter as ListAdpater).setAnimation(AlphaInAnimation())
        (list.adapter as ListAdpater).setAnimation(ScaleInAnimation())
    }

    private fun loadMore() {
        for(i in 0..20) MOCK_DATA.add("More ${i}")

        list?.adapter?.notifyDataSetChanged()
    }
}
