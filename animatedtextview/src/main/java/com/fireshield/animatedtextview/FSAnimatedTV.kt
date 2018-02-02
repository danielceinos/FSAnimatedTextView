package com.fireshield.animatedtextview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.animation.*
import android.widget.FrameLayout
import android.widget.TextView


/**
 * Created by Daniel S on 02/02/2018.
 */
class FSAnimatedTV(context: Context?, attrs: AttributeSet?) : FrameLayout(context, attrs) {

  enum class DIRECTION { UPWARDS, DOWNWARDS }

  private var value: Int = 0
  private var outAnim: Animation
  private var inAnim: Animation
  val duration: Long
  var outInterpolator: Interpolator = AccelerateDecelerateInterpolator()
  var inInterpolator: Interpolator = AccelerateDecelerateInterpolator()

  private fun initialize(context: Context) {
    inflate(context, R.layout.animated_tv, this)
  }

  init {
    initialize(context!!)
    outAnim = AnimationUtils.loadAnimation(this.context, R.anim.trans_out_up)
    inAnim = AnimationUtils.loadAnimation(this.context, R.anim.trans_in_up)

    val ta = context.obtainStyledAttributes(attrs, R.styleable.FSAnimatedTV, 0, 0)
    val dimension = ta.getDimension(R.styleable.FSAnimatedTV_textSize, 40F)
    val color = ta.getColor(R.styleable.FSAnimatedTV_textColor, Color.BLACK)
    duration = ta.getInt(R.styleable.FSAnimatedTV_duration, 300).toLong()

    val text = findViewById<TextView>(R.id.fs_number)
    text.textSize = dimension
    text.setTextColor(color)

    ta.recycle()
  }

  fun setNum(num: Int) {
    if (num > value) {
      animate(num.toString(), DIRECTION.UPWARDS)
    } else {
      animate(num.toString(), DIRECTION.DOWNWARDS)
    }
    value = num
  }

  fun setText(newText: String) {
    animate(newText, DIRECTION.UPWARDS)
  }

  private fun animate(newText: String, direction: DIRECTION) {
    outAnim.cancel()
    inAnim.cancel()

    when (direction) {
      FSAnimatedTV.DIRECTION.UPWARDS -> {
        outAnim = AnimationUtils.loadAnimation(this.context, R.anim.trans_out_up)
        inAnim = AnimationUtils.loadAnimation(this.context, R.anim.trans_in_up)
      }
      FSAnimatedTV.DIRECTION.DOWNWARDS -> {
        outAnim = AnimationUtils.loadAnimation(this.context, R.anim.trans_out_down)
        inAnim = AnimationUtils.loadAnimation(this.context, R.anim.trans_in_down)
      }
    }
    outAnim.duration = duration
    inAnim.duration = duration
    outAnim.interpolator = outInterpolator
    inAnim.interpolator = inInterpolator

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