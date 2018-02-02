package com.fireshield.fsanimatedtextview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.fireshield.animatedtextview.FSAnimatedTV
import java.util.*

class MainActivity : AppCompatActivity() {

  private var num: Int = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    findViewById<Button>(R.id.b_more).setOnClickListener { findViewById<FSAnimatedTV>(R.id.tv_number).setNum(++num) }
    findViewById<Button>(R.id.b_less).setOnClickListener { findViewById<FSAnimatedTV>(R.id.tv_number).setNum(--num) }
    findViewById<Button>(R.id.b_more10).setOnClickListener {
      num += 10
      findViewById<FSAnimatedTV>(R.id.tv_number).setNum(num)
    }
    findViewById<Button>(R.id.b_less10).setOnClickListener {
      num -= 10
      findViewById<FSAnimatedTV>(R.id.tv_number).setNum(num)
    }

    findViewById<Button>(R.id.b_random_text).setOnClickListener {
      findViewById<FSAnimatedTV>(R.id.tv_number).setText(UUID.randomUUID().toString().substring(0,6))
    }
  }
}
