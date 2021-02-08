package org.bubbble.listlabs.java;

import android.content.Context;

import androidx.recyclerview.widget.LinearSmoothScroller;

/**
 * @author Andrew
 * @date 2021/02/08 12:13
 */
public class CenterSmoothScroller extends LinearSmoothScroller {

    public CenterSmoothScroller(Context context) {
        super(context);
    }

    @Override
    public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
        return boxStart + (boxEnd - boxStart) / 2 - (viewStart + (viewEnd - viewStart) / 2);
    }
}
