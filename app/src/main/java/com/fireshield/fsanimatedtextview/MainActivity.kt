package com.fireshield.fsanimatedtextview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.fireshield.animatedtextview.FSAnimatedTV
import java.util.*

class MainActivity : AppCompatActivity() {

  private var num: Int = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val rnd = Random()

    findViewById<FSAnimatedTV>(R.id.tv_coment).setOnClickListener({
      findViewById<FSAnimatedTV>(R.id.tv_coment).increment(rnd.nextInt(20) - 10)
    })
    findViewById<FSAnimatedTV>(R.id.tv_retweet).setOnClickListener({
      findViewById<FSAnimatedTV>(R.id.tv_retweet).increment(rnd.nextInt(20) - 10)
    })
    findViewById<FSAnimatedTV>(R.id.tv_like).setOnClickListener({
      findViewById<FSAnimatedTV>(R.id.tv_like).increment(rnd.nextInt(20) - 10)
    })


  }
}
