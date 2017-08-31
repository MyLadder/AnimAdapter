package vip.frendy.anim.animation

import android.animation.Animator
import android.view.View

/**
 * Created by frendy on 2017/7/12.
 */
interface BaseAnimation {

    fun getAnimators(view: View): Array<Animator>
}