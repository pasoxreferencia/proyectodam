package com.example.proyectodam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectodam.databinding.ActivityAddBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

private lateinit var binding: ActivityAddBinding

private val db = FirebaseFirestore.getInstance() //instanciamos la base de datos

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setup(email: String, provider: String) {

        title = "Gestionar citas "
        binding.emailTextView.text = email




        binding.logOutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            onBackPressed() //vuelve a la activity anterior
        }


        binding.saveButton.setOnClickListener {
            db.collection("users").document(email).
            set(hashMapOf(
                "provider" to provider,
                "nombre" to binding.nameTextView.text.toString(),
                "edad" to binding.edadTextView.text.toString(),
                "cita" to binding.citaTextView.text.toString(),
                "hospital" to binding.hospitalTextView.text.toString(),
                "cita2" to binding.cita2TextView.text.toString(),
                "hospital2" to binding.hospital2TextView.text.toString()
            )
            )

        }
        binding.getButton.setOnClickListener {
            db.collection("users").document(email).get().addOnSuccessListener {
                binding.adressTextView.setText(it.get("cita") as String?)
                binding.phoneTextView.setText(it.get("hospital") as String?)
                binding.date2TextView.setText(it.get("cita2") as String?)
                binding.hospital2TextView.setText(it.get("hospital2") as String?)
                binding.date3TextView.setText(it.get("cita3") as String?)
                binding.hospital3TextView.setText(it.get("hospital3") as String?)
            }

        }
        binding.deleteButton.setOnClickListener {
            db.collection("users").document(email).delete()
        }
    }

}