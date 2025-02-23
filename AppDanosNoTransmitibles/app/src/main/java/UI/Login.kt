package UI

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.softyus.appdanosnotransmitibles.R

class Login : AppCompatActivity() {

    lateinit var userName:EditText
    lateinit var password:EditText
    lateinit var btnLogin:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userName = findViewById(R.id.user_name)
        password = findViewById(R.id.password_input)
        btnLogin = findViewById(R.id.login_btn)

        btnLogin.setOnClickListener{
            val user_name = userName.text.toString()
            val password_in = password.text.toString()
            Log.i("test credentiales","userName:$user_name and password:$password_in")
        }
    }
}