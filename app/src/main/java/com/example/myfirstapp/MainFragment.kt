package com.example.myfirstapp

import android.R
import android.content.Context
import android.content.SharedPreferences
//import android.content.*
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.myfirstapp.databinding.FragmentMainBinding
import com.example.stuff.Classes.CharList
import com.example.myfirstapp.MainActivity.Companion.MyCharList

class MainFragment : Fragment() {



    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.leftText.text = MyCharList.left
        //MyCharList.times = DoesStuff.playernum
        //MyCharList
        binding.rollButton.setOnClickListener {
            binding.rollText.text = MyCharList.roll
            binding.leftText.text = MyCharList.left
        }
        binding.resetButton.setOnClickListener {
            binding.rollText.text = "reset"
            MyCharList.reset()
            binding.leftText.text = MyCharList.left
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    }