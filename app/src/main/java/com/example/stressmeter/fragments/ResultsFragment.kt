package com.example.stressmeter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.stressmeter.R
import lecho.lib.hellocharts.model.AxisValue
import lecho.lib.hellocharts.model.PointValue
import java.io.*


class ResultsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_results, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val file = File(requireActivity().getExternalFilesDir(null), "StressLevels.csv")
        if (!file.exists()) {
            file.createNewFile()
        }
        else{
            val buffReader = file.bufferedReader()

            buffReader.forEachLine {
                println("value = $it")
            }


        }


    }



}