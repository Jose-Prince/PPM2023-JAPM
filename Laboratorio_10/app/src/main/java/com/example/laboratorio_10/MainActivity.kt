package com.example.laboratorio_10

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class MainActivity : ComponentActivity() {
    private lateinit var googleSignInClient: GoogleSignInClient
    private val ReqCode = 123
    private lateinit var firebaseAuth: FirebaseAuth
    private val auth : FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseApp.initializeApp(this)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("146390523987-rur8de4cj6trs15v07f76ignpo94rrma.apps.googleusercontent.com")
            .requestEmail()
            .build()
        
        googleSignInClient = GoogleSignIn.getClient(this, gso)
        firebaseAuth = FirebaseAuth.getInstance()

        fun updateUI(account: GoogleSignInAccount) {
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            firebaseAuth.signInWithCredential(credential).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    SavedPreference.setEmail(this, account.email.toString())
                    SavedPreference.setUsername(this, account.displayName.toString())
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }

        fun handleResult(task: Task<GoogleSignInAccount>) {
            try {
                val account = completedTask.getResult(ApiException::class.java)
                if (account != null) {
                    updateUI(account)
                }
            } catch (e: ApiException) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        setContent {
                    val currentUser = auth.currentUser

                    if (currentUser != null){
                        var context = LocalContext.current
                        val intent = Intent(context, MainScreen::class.java)
                        context.startActivity(intent)
                    }

                    var navController = rememberNavController()
            var context = LocalContext.current
            var email = ""
            var password = ""
            Box (
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ){

            }
            Column (modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.TopCenter),
                verticalArrangement = Arrangement.Center){
                DrawShape(shape = RectangleShape)
                Spacer(modifier = Modifier.height(125.dp))

                Text(
                    text = "Correo Electrónico:",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth())
                Row {
                    Spacer(modifier = Modifier.width(55.dp))
                    email = FieldString()
                }
                Spacer(modifier = Modifier.height(50.dp))
                Text(
                    text = "Contraseña:",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Row {
                    Spacer(modifier = Modifier.width(55.dp))
                    password = FieldString()
                }
                Spacer(modifier = Modifier.height(70.dp))
                Row {
                    Spacer(modifier = Modifier.width(113.dp))
                    Button(onClick = { login(auth,email,password, context)},
                        colors = ButtonDefaults.buttonColors(Color.Green)
                    ) {
                        Text(text = "Iniciar sesión",
                            fontSize = 21.sp)
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "     ─────────── O ───────────     ",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(10.dp))
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)){
                    Spacer(modifier = Modifier.width(117.dp))
                    Button(
                        onClick = { val intent = Intent(context, SignUpScreen::class.java)
                            context.startActivity(intent) },
                        colors = ButtonDefaults.buttonColors(Color.Green)
                    ) {
                        Text(text = "Resgistrarse",
                            fontSize = 21.sp)
                    }
                }
                Button(onClick = { /*TODO*/ }) {
                    Text("Sign In with Google")
                }
            }
            fun signInGoogle() {
                val signInIntent: Intent = googleSignInClient.signInIntent
                startActivityForResult(signInIntent, ReqCode)
            }

            fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
                    super.onActivityResult(requestCode, resultCode, data)
                if (requestCode == ReqCode) {
                    val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                    handleResult(task)
                }
            }
       }
   }
}

@Composable
fun DrawShape(
    shape: Shape,
    width: Dp = 500.dp,
    height: Dp = 50.dp
) {
    Column (modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.TopCenter)) {
        Box (modifier = Modifier
            .size(width, height)
            .clip(shape)
            .background(Color.Blue))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FieldString() : String {
    var text by remember { mutableStateOf("") }
    var maxCharacters : Int = 36

    OutlinedTextField(
        value = text,
        onValueChange = {newText ->
            if (newText.length <= maxCharacters)
                text = newText
        },
        modifier = Modifier
            .border(width = 2.dp, Color.Cyan, RoundedCornerShape(32.dp))
            .background(Color.Cyan, shape = RoundedCornerShape(32.dp)),
        shape = RoundedCornerShape(32.dp),
        singleLine = true,
        textStyle = TextStyle(textAlign = TextAlign.Center,
            fontSize = 21.sp)
    )
    return text
}

private fun login(auth: FirebaseAuth, email : String, password: String, context: Context) {
    if  (email.isBlank() || password.isBlank()) {
        Toast.makeText(context, "Correo o contraseña vacios", Toast.LENGTH_SHORT).show()
        return

    }
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { signInTask ->
            if (signInTask.isSuccessful) {
                Toast.makeText(context, "Sesion iniciada", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, MainScreen::class.java)
                context.startActivity(intent)
            } else {
                auth.fetchSignInMethodsForEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful){
                            val result = task.result
                            if (result.equals(email)){
                                Toast.makeText(context, "Credenciales inválidas", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(context, "Credenciales inválidas", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            if (isInternetAvailable(context)) {
                                Toast.makeText(context, "Correo inválido", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(context, "Sin Internet", Toast.LENGTH_SHORT).show()
                            }

                        }
                    }
            }
        }
}

fun isInternetAvailable(context: Context) : Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork
    val capabilities = connectivityManager.getNetworkCapabilities(network)
    return capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
}
