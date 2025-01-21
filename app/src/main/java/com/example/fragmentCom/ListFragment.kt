package com.example.fragmentCom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.fragmentCom.utils.onClick
import com.example.fragmentcom.R

class ListFragment : Fragment() {
    private val viewModel: ItemViewModel by activityViewModels()
    private val listViewModel: ListViewModel by activityViewModels()
    private val shareChildViewModel: ShareChildViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.toActivity).onClick {
            viewModel.selectItem(Item(Strings.shareDataToAct))
        }
        view.findViewById<Button>(R.id.toFragment).onClick {
            listViewModel.selectItem(Item(Strings.shareDataToFragment))
            val filterFragment = FilterFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.containerFragment, filterFragment)
                .commit()
        }
        view.findViewById<Button>(R.id.toChildFragment).onClick {
            val childFragment = ChildFragment()
            childFragmentManager.beginTransaction()
                .replace(R.id.child_fragment_container, childFragment)
                .commit()
        }

        shareChildViewModel.selectedItem.observe(viewLifecycleOwner, Observer { item ->
            Toast.makeText(requireContext(), item.item, Toast.LENGTH_SHORT).show()
        })

        setFragmentResultListener("requestKey") { requestKey, bundle ->
            val result = bundle.getString("bundleKey")
            Toast.makeText(requireContext(), result, Toast.LENGTH_SHORT).show()
        }

        view.findViewById<Button>(R.id.fragmentResultApi).onClick {
            val filterFragment = FilterFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.containerFragment, filterFragment)
                .commit()
        }

    }

}