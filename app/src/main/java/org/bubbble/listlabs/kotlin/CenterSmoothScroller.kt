package org.bubbble.listlabs.kotlin

import android.content.Context
import androidx.recyclerview.widget.LinearSmoothScroller

/**
 * @author Andrew
 * @date 2021/02/07 17:26
 */
open class CenterSmoothScroller constructor(
    context: Context?
) : LinearSmoothScroller(context) {

    override fun calculateDtToFit(
        viewStart: Int,
        viewEnd: Int,
        boxStart: Int,
        boxEnd: Int,
        snapPreference: Int
    ): Int {
        return boxStart + (boxEnd - boxStart) / 2 - (viewStart + (viewEnd - viewStart) / 2)
    }
}