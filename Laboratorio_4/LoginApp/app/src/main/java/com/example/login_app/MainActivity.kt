package com.example.login_app

import android.content.Context
import android.content.Intent
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.login_app.ui.theme.Login_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login_AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var navController = rememberNavController()
                    LogInScreen(navController)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogInScreen(navController: NavController) {

    var context = LocalContext.current
    var usuario = ""
    var password = ""
    var maxCharacters : Int = 36
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
            text = "Usuario:",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth())
        Row {
            Spacer(modifier = Modifier.width(55.dp))
            usuario = FieldString()
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
            Button(onClick = {validarUsuario(URL = "https://localhost/LoginExample/php/public/", usuario = usuario, password = password, context)},
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
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Login_AppTheme {
        var navController = rememberNavController()
        LogInScreen(navController)
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


private fun validarUsuario(URL: String, usuario : String, password : String, context : Context) {

    // Crear la solicitud POST con los parámetros
    val stringRequest = object : StringRequest(
        Request.Method.POST, // Método HTTP POST
        URL, // URL a la que deseas enviar la solicitud
        Response.Listener<String> { response ->
            if (!response.isEmpty()) {
                val intent = Intent(context, MainScreen::class.java)
                context.startActivity(intent)
            } else {
                Toast.makeText(context, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show()
            }
        },
        Response.ErrorListener { error ->
            Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show()
        }
    ) {
        // Aquí puedes agregar los parámetros a la solicitud
        override fun getParams(): MutableMap<String, String> {
            var params = HashMap<String, String>()
            params["usuario"] = usuario
            params["password"] = password
            return params
        }
    }

    val requestQueue = Volley.newRequestQueue(context)
    requestQueue.add(stringRequest)
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

