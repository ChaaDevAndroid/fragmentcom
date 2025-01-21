package com.example.fragmentCom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.Observer
import com.example.fragmentCom.utils.onClick
import com.example.fragmentcom.R


class FilterFragment : Fragment() {
    private val listViewModel: ListViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listViewModel.selectedItem.observe(viewLifecycleOwner, Observer { item ->
            Toast.makeText(requireContext(), item.item, Toast.LENGTH_SHORT).show()
        })

        view.findViewById<Button>(R.id.send_data_to_fragment_using_result_api).onClick {
            setFragmentResult("requestKey", bundleOf("bundleKey" to Strings.resulFragmentApi))
            val listFragment = ListFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.containerFragment, listFragment)
                .commit()
        }
    }


}