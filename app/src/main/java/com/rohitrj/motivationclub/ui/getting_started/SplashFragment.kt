package com.rohitrj.motivationclub.ui.getting_started

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.rohitrj.motivationclub.R

/**
 * A simple [Fragment] subclass.
 */
private var handler: Handler? = null
private var runnable: Runnable? = null
private const val TAG = "SplashFragment"
private var isSuccess: Boolean = false

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i(TAG, "onActivityCreated:")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG, "onViewCreated:")
        handler = Handler()
        runnable = Runnable{
            Navigation.findNavController(view).navigate(R.id.connectUser, null)
            isSuccess = true
        }
        handler?.postDelayed(runnable!!, 2500)
    }
    override fun onStop() {
        super.onStop()
        handler?.removeCallbacks(runnable!!)
        if(!isSuccess){
            activity?.finish()
        }
    }
}
