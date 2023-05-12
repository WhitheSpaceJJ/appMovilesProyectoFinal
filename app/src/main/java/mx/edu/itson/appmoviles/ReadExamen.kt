package mx.edu.itson.appmoviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase

class ReadExamen : AppCompatActivity() {

    //realtime database
    private var userRef = FirebaseDatabase.getInstance().getReference("usuarios")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_examen)


        userRef.addChildEventListener(object : ChildEventListener {
            override fun onCancelled(databaseError: DatabaseError) { }
            override fun onChildMoved(dataSnapshot: DataSnapshot, previusName: String?) {

            }
            override fun onChildChanged(dataSnapshot: DataSnapshot, previusName: String?) { }
            override fun onChildRemoved(snapshot: DataSnapshot) { }

            override fun onChildAdded(dataSnapshot: DataSnapshot, p1: String?) {
                val usuario2 = dataSnapshot.getValue(Usuario2::class.java)
                if (usuario2 != null) writeMark(usuario2)
            }

        })

    }



    private fun writeMark(mark: Usuario2){
        var listV: TextView = findViewById(R.id.ltvUsuarios) as TextView
        val text = listV .text.toString() + mark.toString() + "\n"
        listV.text = text
    }

}