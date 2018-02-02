package com.fireshield.animatedtextview

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView


/**
 * Created by Daniel S on 02/02/2018.
 */
class FSAnimatedTV(context: Context?, attrs: AttributeSet?) : FrameLayout(context, attrs) {

  var value: Int = 0

  fun initialize(context: Context) {
    inflate(context, R.layout.animated_tv, this)
  }

  init {
    initialize(context!!)
  }

  fun setNum(num: Int) {
    val yTrans: Float
    if (num < value)
      yTrans = findViewById<View>(R.id.fs_number).height.toFloat()
    else
      yTrans = (-findViewById<View>(R.id.fs_number).height).toFloat()

    value = num
    val text = findViewById<TextView>(R.id.fs_number)

    text.animate()
        .translationY(yTrans)
        .alpha(0F)
        .setDuration(200)
        .setListener(object : AnimatorListenerAdapter() {
          override fun onAnimationEnd(animation: Animator) {
            super.onAnimationEnd(animation)
            text.text = num.toString()
            text.y = -yTrans
            text.animate()
                .translationY(0F)
                .alpha(1F)
                .setDuration(200)
                .setListener(object : AnimatorListenerAdapter() {
                  override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    text.visibility = View.VISIBLE
                  }
                })
          }
        })
  }
}