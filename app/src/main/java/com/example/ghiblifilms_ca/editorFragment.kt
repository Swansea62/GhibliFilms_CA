package com.example.ghiblifilms_ca

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.example.ghiblifilms_ca.databinding.EditorFragmentBinding

class editorFragment : Fragment() {

    private val args: editorFragmentArgs by navArgs()
    private lateinit var binding: EditorFragmentbinding
    private lateinit var viewModel: EditorViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ActionBar is menu on top
        (activity as AppCompatActivity).supportActionBar?.let {
            // 'it' is similar to 'this' in Java (there are small differences)
            it.setHomeButtonEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
        }
        setHasOptionsMenu(true)

        // bind 'binding' to the editor fragment layout
        binding = EditorFragmentBinding.inflate(inflater, container, false)
        // args.plantId is the ID of the argument you added in the nav_graph (you added it to the editor fragment)
        binding.title.setText(args.ghibliArgs.title)
        binding.description.setText(args.ghibliArgs.description)

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true){
                override fun handleOnBackPressed(){
                    // you write the code for saveAndReturn - later this will need to save to the Database
                }
            }
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditorViewModel::class.java)
        // TODO: Use the ViewModel
    }

}