package com.example.stressmeter.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.stressmeter.R
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
            fillTable(file)
        }


    }

    private fun fillTable(file: File){
        file.bufferedReader().forEachLine {
            val stressLevels = it.split(",").toTypedArray()

            val row = TableRow(requireActivity())
            row.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)

            val tv0 = TextView(requireActivity())
            tv0.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f)
            tv0.text = stressLevels[0]
            tv0.setBackgroundColor(Color.LTGRAY)
            row.addView(tv0)

            val tv1 = TextView(requireActivity())
            tv1.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f)
            tv1.text = stressLevels[1]
            row.addView(tv1)

            val table = requireActivity().findViewById<TableLayout>(R.id.table_csv_results)
            table.addView(row)
        }
    }

}