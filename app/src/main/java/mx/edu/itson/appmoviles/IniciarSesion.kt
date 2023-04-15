package mx.edu.itson.appmoviles

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class IniciarSesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)
        var usuario =  Usuario(
            correoElectronico = "",
            nombreUsuario = "",
            contrasena = "",
            temasFavoritos = arrayListOf(
                /*
                "tecnología", "ciencia", "cultura"
                 ,"tecnología", "ciencia", "cultura"
                 */
            ),
            perfiles = arrayListOf(PerfilUsuario("jose",21,R.drawable.perfiloficial1,
                arrayListOf(1,2,3,4),
                arrayListOf(0,0,0,0)
                ),
                PerfilUsuario("giovanni",37,R.drawable.perfiloficial2,
                        arrayListOf(1,2,3,4),
                arrayListOf(0,0,0,0)
                ),
                PerfilUsuario("josegiovanni",58,R.drawable.perfiloficial3,
                    arrayListOf(1,2,3,4),
                    arrayListOf(0,0,0,0))
                /*
                        perfiles.add(PerfilUsuario("jose",21,R.drawable.perfiloficial1))
        perfiles.add(PerfilUsuario("giovanni",37,R.drawable.perfiloficial2))
        perfiles.add(PerfilUsuario("josegiovanni",58,R.drawable.perfiloficial3))
                PerfilUsuario(
                    nombrePerfil = "perfil1",
                    descripcion = "Descripción del perfil 1"
                )
                */
            )
        )
        var usuarioEditText: EditText=findViewById(R.id.et_usuario_inicio)
        var contraEditText: EditText=findViewById(R.id.et_contraseña_inicio)
        val btnIniciarSesion: Button = findViewById(R.id.btn_iniciar_sesion)



        val tvolvide_Pass: TextView = findViewById(R.id.tvOlvidePass)
        val btnRegistrarse: Button = findViewById(R.id.btn_registrarse)

        btnIniciarSesion.setOnClickListener{
        if(usuarioEditText.getText().toString().isEmpty() || contraEditText.getText().toString().isEmpty() ){
            Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                usuario.nombreUsuario=usuarioEditText.text.toString()
                usuario.contrasena=contraEditText.text.toString()
                var intent: Intent = Intent(this, Perfiles::class.java)
                intent.putExtra("usuario", usuario)
                startActivity(intent)
            }
        }
        tvolvide_Pass.setOnClickListener {
            var intent: Intent = Intent(this, PaswordOlvidada::class.java)
            startActivity(intent)
        }

        btnRegistrarse.setOnClickListener{
            var intent: Intent = Intent(this, CrearCuenta::class.java)
            startActivity(intent)
        }
}

}