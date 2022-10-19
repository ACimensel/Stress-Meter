package com.example.stressmeter.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.stressmeter.adapters.CustomImageAdapter
import com.example.stressmeter.R

class StressGridFragment : Fragment() {
    private lateinit var adapter: CustomImageAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_stress_grid, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageGrid = view.findViewById<GridView>(R.id.grid_stress)
        adapter = CustomImageAdapter(requireActivity())
        imageGrid.adapter = adapter
        imageGrid.setOnItemClickListener { adapterView, view, position, id ->
            Log.d("DEBUG:", position.toString())
            Log.d("DEBUG:", id.toString())
        }

        val button = view.findViewById<Button>(R.id.button_more_images)
        button.setOnClickListener{
            adapter.changeImages()
        }
    }
}