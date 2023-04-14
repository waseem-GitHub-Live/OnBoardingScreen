package com.example.onboardingscreen.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.onboardingscreen.R
import com.example.onboardingscreen.fragments.fragmentscreen

class slide_adapter(
    fragmentActivity: FragmentActivity,
    private val context: Context
) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> fragmentscreen.newInstance(
                context.resources.getString(R.string.title_onboarding_1),
                R.drawable.mobilep
            )
            1 -> fragmentscreen.newInstance(
                context.resources.getString(R.string.title_onboarding_2),
                R.drawable.secondpage
            )
            else -> fragmentscreen.newInstance(
                context.resources.getString(R.string.title_onboarding_3),
                R.drawable.thirdpage
            )
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}