package com.example.stressmeter.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.stressmeter.R
import com.example.stressmeter.activities.ImageConfirmActivity
import com.example.stressmeter.activities.MainActivity
import com.example.stressmeter.adapters.CustomImageAdapter


class StressGridFragment : Fragment() {
    private val gridPosScores = arrayOf(6, 8, 14, 16, 5, 7, 13, 15, 2, 4, 10, 12, 1, 3, 9, 11)
    private lateinit var adapter: CustomImageAdapter
    private lateinit var imageChoiceResult: ActivityResultLauncher<Intent>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_stress_grid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageGrid = view.findViewById<GridView>(R.id.grid_stress)
        adapter = CustomImageAdapter(requireActivity())
        imageGrid.adapter = adapter
        imageGrid.setOnItemClickListener { _, _, position, _ ->
            (activity as MainActivity).stopVibration()

            val intent = Intent(requireActivity(), ImageConfirmActivity::class.java)
            intent.putExtra("Score", gridPosScores[position])
            intent.putExtra("Image", imageGrid.getItemAtPosition(position) as Int)
            imageChoiceResult.launch(intent)
        }

        val button = view.findViewById<Button>(R.id.button_more_images)
        button.setOnClickListener{
            (activity as MainActivity).stopVibration()

            adapter.changeImages()
        }

        imageChoiceResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if(result.resultCode == Activity.RESULT_OK) {
                requireActivity().finish()
            }
        }
    }
}