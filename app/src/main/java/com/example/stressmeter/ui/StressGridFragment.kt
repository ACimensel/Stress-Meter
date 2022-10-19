package com.example.stressmeter.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stressmeter.R

class StressGridFragment : Fragment() {

    companion object {
        fun newInstance() = StressGridFragment()
    }

    private lateinit var viewModel: StressGridViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stress_grid, container, false)
    }







    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StressGridViewModel::class.java)
        // TODO: Use the ViewModel
    }

}