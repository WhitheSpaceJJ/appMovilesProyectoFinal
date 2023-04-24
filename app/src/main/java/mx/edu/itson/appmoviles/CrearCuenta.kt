package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.*
import com.google.firebase.ktx.Firebase

class CrearCuenta : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cuenta)

        auth = Firebase.auth

        val ivRegresar : ImageView = findViewById(R.id.ivRegresarCrear)
        val btnRegistrase : Button = findViewById(R.id.btnCrearRegistrarse)

        ivRegresar.setOnClickListener{
            var intent: Intent = Intent(this, IniciarSesion::class.java)
            startActivity(intent)
        }

        btnRegistrase.setOnClickListener{
            //var intent: Intent = Intent(this, ConfigurarPerfil::class.java)
            //startActivity(intent)
            valida_registro()
        }
    }

    private fun valida_registro(){
        val et_crear_usuario : EditText = findViewById(R.id.etCrearusuario)
        val et_crear_correo : EditText = findViewById(R.id.etCrearCorreoE)
        val et_crear_contra : EditText = findViewById(R.id.etCrearContrasenia)
        val et_crear_contra_confirmar: EditText = findViewById(R.id.etCrearContraseniaConfirmar)

        var usuario: String = et_crear_usuario.text.toString()
        var correo: String = et_crear_correo.text.toString()
        var contra1: String = et_crear_contra.text.toString()
        var contra2: String = et_crear_contra_confirmar.text.toString()

        if (!usuario.isNullOrBlank() && !correo.isNullOrBlank() && !contra1.isNullOrBlank() &&
            !contra2.isNullOrBlank()){
            if(contra1 == contra2){
                registrarFirebase(correo, contra1)
            }else{
                Toast.makeText(this,"Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this,"Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun registrarFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser

                    Toast.makeText(baseContext, "${user?.email} Se ha creado correctamente.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    //Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }
            }

    }
}