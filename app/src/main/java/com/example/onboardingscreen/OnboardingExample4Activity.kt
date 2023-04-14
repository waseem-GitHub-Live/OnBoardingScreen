package com.example.onboardingscreen

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.onboardingscreen.adapter.slide_adapter
import com.example.onboardingscreen.databinding.OnboardingBinding
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class OnboardingExample4Activity : AppCompatActivity() {
    private lateinit var mViewPager: ViewPager2
    private lateinit var btnBack: TextView
    private lateinit var btnNext: TextView

    private lateinit var binding: OnboardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = OnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mViewPager = binding.viewPager2
        mViewPager.adapter = slide_adapter(this, this)
        mViewPager.offscreenPageLimit = 1
        btnBack = binding.button2
        btnNext = binding.button4
        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        dotsIndicator.attachTo(mViewPager)
        mViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == 2) {
                    btnNext.text = "Finish"
                } else {
                    btnNext.text = "Next"
                }
            }

            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
            override fun onPageScrollStateChanged(arg0: Int) {}
        })


        btnNext.setOnClickListener {
            if (getItem() > mViewPager.childCount) {
                finish()
            } else {
                mViewPager.setCurrentItem(getItem() + 1, true)
            }
        }

        btnBack.setOnClickListener {
//            Log.d("OnboardingExample4Activity", "Back button clicked. Current item:")
//            if (getItem() == 0) {
//                finish()
//            } else {
//                mViewPager.setCurrentItem(getItem() - 1, true)
//            }
            val i = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
        }
    }

    private fun getItem(): Int {
        return mViewPager.currentItem
    }
}
