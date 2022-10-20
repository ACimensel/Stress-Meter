package com.example.stressmeter.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.stressmeter.R
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
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
            fillChart(file)
            fillTable(file)
        }
    }

    private fun fillChart(file: File) {
        val points = ArrayList<Entry>()
        var instance = 0f
        file.bufferedReader().forEachLine {
            val stressLevels = it.split(",").toTypedArray()
            points.add(Entry(instance, stressLevels[1].toFloat()))
            instance++
        }

        val vl = LineDataSet(points, "Stress Levels")
        vl.setDrawValues(false)
        vl.setDrawFilled(true)
        vl.lineWidth = 3f
        vl.fillColor = Color.GRAY

        val lineChart = requireActivity().findViewById<com.github.mikephil.charting.charts.LineChart>(R.id.lineChart)
        lineChart.data = LineData(vl)
        lineChart.setTouchEnabled(true)
        lineChart.setPinchZoom(true)
        lineChart.description.text = ""
        lineChart.setNoDataText("No stress level results yet!")
    }

    private fun fillTable(file: File){
        file.bufferedReader().forEachLine {
            val stressLevels = it.split(",").toTypedArray()

            val row = TableRow(requireActivity())
            row.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)

            val tv0 = TextView(requireActivity())
            tv0.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f)
            tv0.text = stressLevels[0]
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