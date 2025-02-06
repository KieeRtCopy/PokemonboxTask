package com.example.common.base_component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.viewbinding.ViewBinding


abstract class BaseFrameLayout<T : ViewBinding> @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
    private val isForRecyclerView: Boolean = false,
    private val inflateMethod: (LayoutInflater, ViewGroup?, Boolean) -> T
) : FrameLayout(context, attrs, defStyleAttr, defStyleRes) {

    protected val binding: T = inflateMethod(LayoutInflater.from(context), this, !isForRecyclerView)
}