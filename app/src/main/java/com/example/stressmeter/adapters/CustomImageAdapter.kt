package com.example.stressmeter.adapters

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.stressmeter.R


class CustomImageAdapter(private val context : Context) : BaseAdapter() {
    private val array0 = arrayOf(
        R.drawable.psm_mountains11, R.drawable.psm_wine3,
        R.drawable.psm_barbed_wire2, R.drawable.psm_clutter,
        R.drawable.psm_blue_drop, R.drawable.psm_to_do_list,
        R.drawable.psm_stressed_person7, R.drawable.psm_stressed_person6,
        R.drawable.psm_yoga4, R.drawable.psm_bird3,
        R.drawable.psm_stressed_person8, R.drawable.psm_exam4,
        R.drawable.psm_kettle, R.drawable.psm_lawn_chairs3,
        R.drawable.psm_to_do_list3, R.drawable.psm_work4,
    )
    private val array1 = arrayOf(
        R.drawable.psm_talking_on_phone2, R.drawable.psm_stressed_person,
        R.drawable.psm_stressed_person12, R.drawable.psm_lonely,
        R.drawable.psm_gambling4, R.drawable.psm_clutter3,
        R.drawable.psm_reading_in_bed2, R.drawable.psm_stressed_person4,
        R.drawable.psm_lake3, R.drawable.psm_cat,
        R.drawable.psm_puppy3, R.drawable.psm_neutral_person2,
        R.drawable.psm_beach3, R.drawable.psm_peaceful_person,
        R.drawable.psm_alarm_clock2, R.drawable.psm_sticky_notes2,
    )
    private val array2 = arrayOf(
        R.drawable.psm_anxious, R.drawable.psm_hiking3,
        R.drawable.psm_stressed_person3, R.drawable.psm_lonely2,
        R.drawable.psm_dog_sleeping, R.drawable.psm_running4,
        R.drawable.psm_alarm_clock, R.drawable.psm_headache,
        R.drawable.psm_baby_sleeping, R.drawable.psm_puppy,
        R.drawable.psm_stressed_cat, R.drawable.psm_angry_face,
        R.drawable.psm_bar, R.drawable.psm_running3,
        R.drawable.psm_neutral_child, R.drawable.psm_headache2,
    )
    private var chosenArray = 0

    init {
        chosenArray = (0..2).random()
        Log.d("DEBUG: Random set is ", chosenArray.toString())
    }

    override fun getCount(): Int {
        return array1.size
    }

    override fun getItem(position: Int): Any {
        return when (chosenArray) {
            0 -> array0[position]
            1 -> array1[position]
            2 -> array2[position]
            else -> -1
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View? {
        val imgView: ImageView
        if (view == null) {
            imgView = ImageView(context)
            imgView.layoutParams = AbsListView.LayoutParams(240, 240)
            imgView.scaleType = ImageView.ScaleType.CENTER_CROP
        }
        else {
            imgView = view as ImageView
        }

        when (chosenArray) {
            0 -> imgView.setImageResource(array0[position])
            1 -> imgView.setImageResource(array1[position])
            2 -> imgView.setImageResource(array2[position])
        }

        return imgView
    }

    fun changeImages(){
        chosenArray = (chosenArray + 1) % 3
        this.notifyDataSetChanged()
    }
}