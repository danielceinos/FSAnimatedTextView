package com.fireshield.animatedtextview

import android.content.Context
import android.util.AttributeSet
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.Interpolator
import android.widget.FrameLayout
import android.widget.TextView


/**
 * Created by Daniel S on 02/02/2018.
 */
class FSAnimatedTV(context: Context?, attrs: AttributeSet?) : FrameLayout(context, attrs) {

  var value: Int = 0
  var outAnim: Animation
  var inAnim: Animation

  fun initialize(context: Context) {
    inflate(context, R.layout.animated_tv, this)
  }

  init {
    initialize(context!!)
    outAnim = AnimationUtils.loadAnimation(this.context, R.anim.trans_out)
    inAnim = AnimationUtils.loadAnimation(this.context, R.anim.trans_in)
  }

  fun setNum(num: Int) {
    outAnim.cancel()
    inAnim.cancel()

    if (num > value) {
      outAnim = AnimationUtils.loadAnimation(this.context, R.anim.trans_out)
      inAnim = AnimationUtils.loadAnimation(this.context, R.anim.trans_in)
    } else {
      outAnim = AnimationUtils.loadAnimation(this.context, R.anim.trans_out_inv)
      inAnim = AnimationUtils.loadAnimation(this.context, R.anim.trans_in_inv)
    }

    outAnim.interpolator = AccelerateDecelerateInterpolator()
    inAnim.interpolator = AccelerateDecelerateInterpolator()

    value = num
    val text = findViewById<TextView>(R.id.fs_number)
    outAnim.setAnimationListener(object : Animation.AnimationListener {
      override fun onAnimationStart(arg0: Animation) {}
      override fun onAnimationRepeat(arg0: Animation) {}
      override fun onAnimationEnd(arg0: Animation) {
        text.text = num.toString()
        text.startAnimation(inAnim)
      }
    })
    text.startAnimation(outAnim)
  }
}