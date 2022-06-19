package com.hoteles.ui.Hotel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.hoteles.R
import com.hoteles.databinding.FragmentAddHotelBinding
import com.hoteles.model.Hotel
import com.hoteles.viewmodel.HotelViewModel

class AddHotelFragment : Fragment() {

    private var _binding: FragmentAddHotelBinding? = null
    private val binding get() = _binding!!

    private lateinit var hotelViewModel: HotelViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        hotelViewModel =
            ViewModelProvider(this)[HotelViewModel::class.java]

        _binding = FragmentAddHotelBinding.inflate(inflater, container, false)


        binding.btRegistrar.setOnClickListener {
            addHotel()
        }

        return binding.root
    }

    private fun addHotel() {
        val nombre=binding.etNombre.text.toString()
        val email=binding.etEmail.text.toString()
        val telefono=binding.etTelefono.text.toString()
        val direccion=binding.etDireccion.text.toString()
        if (nombre.isNotEmpty()){
            val hotel= Hotel(0, nombre,email,telefono,direccion)
            hotelViewModel.addHotel(hotel)
            Toast.makeText(requireContext(),getString(R.string.msg_hotel_added),Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addHotelFragment_to_nav_hotel)
        } else {
            Toast.makeText(requireContext(),getString(R.string.msg_data),Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}