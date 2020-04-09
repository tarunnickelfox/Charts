package com.example.myapplication

import android.graphics.Canvas
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.renderer.XAxisRenderer
import com.github.mikephil.charting.utils.MPPointF
import com.github.mikephil.charting.utils.Transformer
import com.github.mikephil.charting.utils.ViewPortHandler

class CustomXAxisRenderer(
    private val viewPortHandler: ViewPortHandler,
    private val xAxis: XAxis, private val trans: Transformer
) : XAxisRenderer(viewPortHandler, xAxis, trans) {
    override fun drawLabels(c: Canvas?, pos: Float, anchor: MPPointF?) {
        super.drawLabels(c, pos, anchor)
    }
}