package com.example.bruno.devportfolio.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bruno.devportfolio.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [WorkFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [WorkFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class WorkFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work, container, false)
    }
}
