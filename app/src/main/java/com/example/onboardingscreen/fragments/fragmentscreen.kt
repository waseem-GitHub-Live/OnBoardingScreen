package com.example.onboardingscreen.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.onboardingscreen.R
import com.example.onboardingscreen.databinding.ExampleFragmentBinding

class fragmentscreen : Fragment() {

    private lateinit var description: String
    private var imageResource = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            description = requireArguments().getString(ARG_PARAM2)!!
            imageResource = requireArguments().getInt(ARG_PARAM3)
        }

    }


    private var _binding: ExampleFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Set the style to remove the title bar
        val activity = requireActivity()
        activity.setTheme(com.google.android.material.R.style.ThemeOverlay_MaterialComponents_ActionBar)

        _binding = ExampleFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.imageView5.setBackgroundResource(imageResource)
        binding.textView4.text = description

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

        private const val ARG_PARAM2 = "param2"
        private const val ARG_PARAM3 = "param3"
        fun newInstance(
            description: String?,
            imageResource: Int
        ): fragmentscreen {
            val fragment = fragmentscreen()
            val args = Bundle()
            args.putString(ARG_PARAM2, description)
            args.putInt(ARG_PARAM3, imageResource)
            fragment.arguments = args
            return fragment
        }
    }
}