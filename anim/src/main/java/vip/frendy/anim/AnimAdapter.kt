package vip.frendy.anim

import android.animation.Animator
import android.support.v7.widget.RecyclerView
import android.view.animation.LinearInterpolator
import vip.frendy.anim.animation.BaseAnimation
import vip.frendy.anim.animation.SlideInBottomAnimation

/**
 * Created by frendy on 2017/7/12.
 */
abstract class AnimAdapter<T: RecyclerView.ViewHolder>: RecyclerView.Adapter<T>() {

    private var mEnableAnimation: Boolean = true
    private var mLastPosition = -1
    private var mDuration = 300
    private val mInterpolator = LinearInterpolator()
    private var mAnimation: BaseAnimation = SlideInBottomAnimation()

    override fun onViewAttachedToWindow(holder: T?) {
        super.onViewAttachedToWindow(holder)
        addAnimation(holder)
    }

    fun setAnimation(anim: BaseAnimation) {
        mAnimation = anim
    }

    private fun addAnimation(holder: T?) {
        if (mEnableAnimation && holder != null) {
            if (holder.layoutPosition > mLastPosition) {
                for (anim in mAnimation.getAnimators(holder.itemView)) {
                    startAnim(anim, holder.layoutPosition)
                }
                mLastPosition = holder.layoutPosition
            }
        }
    }

    protected fun startAnim(anim: Animator, index: Int) {
        anim.setDuration(mDuration.toLong()).start()
        anim.interpolator = mInterpolator
    }
}