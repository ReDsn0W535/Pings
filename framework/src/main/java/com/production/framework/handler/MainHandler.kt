package com.production.framework.handler

import android.os.Handler
import android.os.Looper
import kotlin.math.max

object MainHandler {

    private val handler = Handler(Looper.getMainLooper())

    @JvmStatic
    @JvmOverloads
    fun runOnUiThread(action: Runnable, delay: Long = 0) {
        if (delay <= 0 && Thread.currentThread() == handler.looper.thread) {
            action.run()
        } else {
            handler.postDelayed(action, max(0, delay))
        }
    }

    fun runOnUiThread(action: () -> Unit, delay: Long = 0) {
        runOnUiThread(Runnable { action() }, delay)
    }

    @JvmStatic
    fun cancel(action: Runnable) {
        handler.removeCallbacks(action)
    }
}