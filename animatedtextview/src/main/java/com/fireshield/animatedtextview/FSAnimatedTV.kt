package com.fireshield.animatedtextview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
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
    val ta = context.obtainStyledAttributes(attrs, R.styleable.FSAnimatedTV, 0, 0)
    val dimension = ta.getDimension(R.styleable.FSAnimatedTV_textSize,40F)
    val color = ta.getColor(R.styleable.FSAnimatedTV_textColor, Color.BLACK)

    val text = findViewById<TextView>(R.id.fs_number)
    text.textSize = dimension
    text.setTextColor(color)

    ta.recycle()
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

  fun setText(newText: String) {
    outAnim.cancel()
    inAnim.cancel()

    outAnim = AnimationUtils.loadAnimation(this.context, R.anim.trans_out)
    inAnim = AnimationUtils.loadAnimation(this.context, R.anim.trans_in)

    outAnim.interpolator = AccelerateDecelerateInterpolator()
    inAnim.interpolator = AccelerateDecelerateInterpolator()

    val text = findViewById<TextView>(R.id.fs_number)
    outAnim.setAnimationListener(object : Animation.AnimationListener {
      override fun onAnimationStart(arg0: Animation) {}
      override fun onAnimationRepeat(arg0: Animation) {}
      override fun onAnimationEnd(arg0: Animation) {
        text.text = newText
        text.startAnimation(inAnim)
      }
    })
    text.startAnimation(outAnim)
  }
}