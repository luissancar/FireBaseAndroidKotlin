package com.example.luisjosesanchezcarrasco.firebaseandroidkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("tutorial") //igual a la de la base de datos
        println( myRef.key)



        val menuListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                println("data change")
                // val contacto : Contactos  = dataSnapshot.getValue<Contactos>(Contactos::class.java)
                //val contacto = dataSnapshot.getValue<Contactos>(Contactos::class.java)
               // Log.i("Contacto", "ffffffffffffffffffffff "+contacto.nombre)
                //Log.i("Valor", dataSnapshot.getValue<Int>(Int::class.java).toString())

                for (objj  in dataSnapshot.children){

                    val registro=objj.getValue()

                    Log.i("dato",registro.toString())


                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                println("loadPost:onCancelled ${databaseError.toException()}")
            }
        }

        myRef.child("contactos").addValueEventListener(menuListener)
        /*
        Log.i("KEY", myRef.key)
        texto.text= myRef.key
        myRef.setValue(9) // modifica por valor 9

        myRef.addValueEventListener(menuListener)
        myRef.addListenerForSingleValueEvent(menuListener)  //solo se ejecuta una vez

*/
        // myRef.child("contactos").addValueEventListener(menuListener)

        button.setOnClickListener {
            var c= Contactos()


            val random = Random()

            c.telefono= random.nextLong()
            c.nombre="nombre "+c.telefono
            myRef.child("contactos").push().setValue(c)
        }


    }
}