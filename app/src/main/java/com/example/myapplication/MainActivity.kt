package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.ChartTouchListener
import com.github.mikephil.charting.listener.OnChartGestureListener
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.renderer.XAxisRenderer
import com.github.mikephil.charting.utils.ViewPortHandler
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val entryList1 = mutableListOf<Entry>()
        val entryList2 = mutableListOf<Entry>()
        val entryList3 = mutableListOf<Entry>()
        for (i in 0..9) {
            entryList1.add(Entry(4f, lhEntriesAny[i].toFloat()))
        }

        /*for (i in 13..18) {
            entryList2.add(Entry(i.toFloat(), 0f))
        }

        for (i in 18..25) {
            entryList3.add(Entry(i.toFloat(), 20.0f / i))
        }*/

        val dataSet1 = LineDataSet(entryList1, "Label1") // add entries to data set
        /*val dataSet2 = LineDataSet(entryList2, "Label2") // add entries to data set*/
        /*val dataSet3 = LineDataSet(entryList3, "Label3") // add entries to data set*/

        dataSet1.color = ContextCompat.getColor(this, R.color.colorPrimaryDark)
        dataSet1.valueTextColor = R.color.colorAccent
        dataSet1.mode = LineDataSet.Mode.CUBIC_BEZIER
        dataSet1.cubicIntensity = 0.1f
        dataSet1.isHighlightEnabled = false
        dataSet1.setDrawCircles(false)
        dataSet1.setDrawValues(false)

        /*dataSet2.isVisible = false*/

        /*dataSet3.color = R.color.colorPrimaryDark
        dataSet3.valueTextColor = R.color.colorAccent*/

        val lineData = LineData(dataSet1)
        lineChart.data = lineData

        lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM_INSIDE
        lineChart.xAxis.axisMinimum = 0f
        lineChart.xAxis.axisMaximum = 10f
        lineChart.invalidate()

        test.setOnClickListener {
            val chartData = lineChart.data

            for (i in 0..9) {
                entryList2.add(Entry(4.5f, lhEntriesAny[i].toFloat()))
            }

            val dataSet2 = LineDataSet(entryList2, "Label2") // add entries to data set
            /*val dataSet2 = LineDataSet(entryList2, "Label2") // add entries to data set*/
            /*val dataSet3 = LineDataSet(entryList3, "Label3") // add entries to data set*/

            dataSet2.color = ContextCompat.getColor(this, R.color.colorPrimaryDark)
            dataSet2.valueTextColor = R.color.colorAccent
            dataSet2.mode = LineDataSet.Mode.CUBIC_BEZIER
            dataSet2.cubicIntensity = 0.1f
            dataSet2.isHighlightEnabled = false
            dataSet2.setDrawCircles(false)
            dataSet2.setDrawValues(false)

            chartData.addDataSet(dataSet2)
            chartData.notifyDataChanged()
            lineChart.notifyDataSetChanged()
            lineChart.invalidate()
        }
    }

    private val lhEntriesAny: Array<Double> = arrayOf(
        1.0,
        2.0,
        3.0,
        4.0,
        5.0,
        6.0,
        7.0,
        8.0,
        9.0,
        10.0
    )

    /*private fun getLineDataSets(): List<LineDataSet> {
        val entryList = mutableListOf<Entry>()

        val lhEntries = getLHEntries()

        for (i: Int in lhEntries.indices) {
            val currentEntry = lhEntries[i]

            if (currentEntry != null) {
                entryList.add(i, Entry(i.toFloat(), currentEntry))
            } else {
                entryList.add(i, Entry(i.toFloat(), -1.0f))
            }
        }

        val dataSetList = mutableListOf<LineDataSet>()

        var tempData = LineDataSet(mutableListOf(), "")
        var lastData: Float? = null

        for (data in entryList) {
            if (data.y >= 0) {
                tempData.addEntry(data)
                tempData.color = R.color.colorAccent
                tempData.valueTextColor = R.color.colorPrimaryDark
            } else {
                tempData.addEntry(data)
                dataSetList.add(tempData)
                tempData

            }
        }

        while (data in entryList)

        return dataSetList
    }*/

/*    private val lhEntriesAny: Array<Double?> = arrayOf(
        null,
        null,
        null,
        null,
        null,
        0.0,
        1.820411016,
        0.0,
        2.861975264,
        4.32281039,
        3.92097487,
        4.007942457,
        5.429096002,
        3.970139321,
        3.889788656,
        2.914878966,
        4.940224826,
        5.466737925,
        5.812275749,
        null,
        5.967085664,
        3.418321836,
        5.260091179,
        8.364888952,
        null,
        4.7,
        4.4,
        5.7,
        5.4,
        4.2,
        null,
        6.4,
        null,
        null,
        null,
        null,
        4.6,
        4.4,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null
    )

    private fun getMPChartsData(): List<Entry?> {
        val data = mutableListOf<Entry?>()
        val lhEntries = getLHEntries()

        for (i: Int in lhEntries.indices) {
            val currentEntry = lhEntries[i]
            if (currentEntry != null) {
                data.add(i, Entry(i.toFloat(), currentEntry))
            } else {
                data.add(i, Entry(i.toFloat(), -1.0f))
            }
        }

        return data
    }

    private fun getLHEntries(): Array<Float?> {
        val lhEntries = arrayOfNulls<Float?>(lhEntriesAny.size)

        for (i: Int in lhEntries.indices) {
            lhEntries[i] = lhEntriesAny[i]?.toFloat()
        }

        return lhEntries
    }*/
}
