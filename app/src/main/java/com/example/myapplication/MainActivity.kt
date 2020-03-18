package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lineChart.setPinchZoom(false)

        val dataSet = LineDataSet(getMPChartsData(), "Label"); // add entries to dataset
        dataSet.color = R.color.colorAccent
        dataSet.valueTextColor = R.color.colorPrimary

        val lineData = LineData(dataSet)
        lineChart.setData(lineData)
        lineChart.invalidate()
    }

    val lhEntriesAny: Array<Double?> = arrayOf(0.0,1.820411016,0.0,2.861975264,4.32281039,3.92097487,4.007942457,5.429096002,3.970139321,3.889788656,2.914878966,4.940224826,5.466737925,5.812275749,null,5.967085664,3.418321836,5.260091179,8.364888952,null,4.7,4.4,5.7,5.4,4.2,null,6.4,null,null,null,null,4.6,4.4,null,null,null,null,null,null,null,null,null,null)

    fun getMPChartsData(): List<Entry?> {
        val data = mutableListOf<Entry?>()
        val lhEntries = getLHEntries()

        for (i: Int in lhEntries.indices) {
            val currentEntry = lhEntries[i]
            if (currentEntry != null) {
                data.add(i, Entry(i.toFloat(), currentEntry))
            } else {
                data.add(i, Entry(i.toFloat(), 0.0f))
            }
        }

        return data
    }

    fun getLHEntries(): Array<Float?> {
        val lhEntries = arrayOfNulls<Float?>(lhEntriesAny.size)

        for (i: Int in lhEntries.indices) {
            lhEntries[i] = lhEntriesAny.get(i)?.toFloat()
        }

        return lhEntries
    }

}
