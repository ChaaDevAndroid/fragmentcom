package com.example.fragmentCom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import com.example.fragmentCom.utils.onClick
import com.example.fragmentcom.R


class ChildFragment : Fragment() {
    private val viewModel: ShareChildViewModel by viewModels({ requireParentFragment() })
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_child, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.toParentFragment).onClick {
            viewModel.selectItem(Item(Strings.shareDataToParentFragment))
        }
    }

}