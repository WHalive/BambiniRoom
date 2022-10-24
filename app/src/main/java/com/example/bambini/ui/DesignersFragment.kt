package com.example.bambinifashion.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bambini.databinding.FragmentDesignersBinding

class DesignersFragment : Fragment() {

    private lateinit var binding: FragmentDesignersBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDesignersBinding.inflate(inflater, container, false)

        return binding.root
    }
}