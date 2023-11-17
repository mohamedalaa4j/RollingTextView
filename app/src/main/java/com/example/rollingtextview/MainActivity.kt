package com.example.rollingtextview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rollingtextview.databinding.ActivityMainBinding
import com.yy.mobile.rollingtextview.CharOrder
import com.yy.mobile.rollingtextview.strategy.Direction
import com.yy.mobile.rollingtextview.strategy.Strategy

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivAdd.setOnClickListener {
            number++
            setRollingTextViewValue(number.toString())
        }

        binding.ivMinus.setOnClickListener {
            if (number > 0) {
                number--
                setRollingTextViewValue(number.toString())
            }
        }
    }

    private fun setRollingTextViewValue(number: String) {
        binding.tv.apply {
            animationDuration = 150
            charStrategy = Strategy.CarryBitAnimation(Direction.SCROLL_DOWN)
            addCharOrder(CharOrder.Number)
            setText(number)
        }
    }
}