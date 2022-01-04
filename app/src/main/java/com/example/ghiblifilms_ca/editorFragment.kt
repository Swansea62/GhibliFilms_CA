package com.example.ghiblifilms_ca

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ghiblifilms_ca.databinding.EditorFragmentBinding

class editorFragment : Fragment() {

    private val args: editorFragmentArgs by navArgs()
    private lateinit var binding: EditorFragmentBinding
    private lateinit var viewModel: EditorViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.let {
            it.setHomeButtonEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
        }
        setHasOptionsMenu(true)

        binding = EditorFragmentBinding.inflate(inflater, container, false)
        binding.title.setText(args.ghibliArgs.title)
        binding.ogTitle.setText(args.ghibliArgs.original_title)
        binding.romTitle.setText(args.ghibliArgs.original_title_romanised)
        binding.description.setText(args.ghibliArgs.description)
        binding.director.setText(args.ghibliArgs.director)
        binding.producer.setText(args.ghibliArgs.producer)
        binding.releaseDate.setText(args.ghibliArgs.release_date)
        binding.runningTime.setText(args.ghibliArgs.running_time)

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true){
                override fun handleOnBackPressed(){
                    // you write the code for saveAndReturn - later this will need to save to the Database
                    saveAndReturn()
                }
            }
        )

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            // When the home button is clicked, save changes then return to the MainFragment, which is the List
            android.R.id.home -> saveAndReturn()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun saveAndReturn() : Boolean{
        findNavController().navigateUp()
        return true
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditorViewModel::class.java)
        // TODO: Use the ViewModel
    }

}