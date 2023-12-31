package com.example.api_implementation

import android.graphics.Bitmap
import android.os.Bundle
import android.os.Environment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.api_implementation.ui.theme.API_ImplementationTheme
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix
import java.io.File
import java.io.FileOutputStream
import java.util.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            API_ImplementationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    API_ImplementationTheme {
        Screen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen() {
    var text by remember { mutableStateOf("")}
    var qrBitmap by remember { mutableStateOf<Bitmap?>(null)}

    val context = LocalContext.current

    val density = LocalDensity.current.density
    val qrCodeSize = (100 * density).toInt()

    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        TextField(
            value = text, onValueChange = { newText -> text = newText },
            placeholder = { Text(text = "Ingresar texto", textAlign = TextAlign.Center) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Button(onClick = {
            if (text.isNotEmpty()){
                qrBitmap = generateQRCode(text, qrCodeSize)
            }
        }) {
            Text(text = "Generar")
        }

        if (qrBitmap != null) {
            Column (modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                Image(
                    bitmap = qrBitmap!!.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .background(MaterialTheme.colorScheme.primary)
                )
                Button(onClick = { saveQRCode(context,qrBitmap!!) }) {
                    Text(text = "Guardar")
                }
            }

        }

    }

}

fun generateQRCode(text: String, size: Int): Bitmap? {
    return try {
        val bitMatrix : BitMatrix = MultiFormatWriter()
            .encode(text, BarcodeFormat.QR_CODE,size,size)
        val width = bitMatrix.width
        val height = bitMatrix.height
        val bmp = Bitmap.createBitmap(width,height,Bitmap.Config.RGB_565)
        for (x in 0 until width){
            for (y in 0 until height) {
                bmp.setPixel(x,y,if (bitMatrix[x,y]) android.graphics.Color.BLACK else android.graphics.Color.WHITE)
            }
        }
        bmp
    } catch (e: Exception){
        e.printStackTrace()
        null
    }
}

fun saveQRCode(context: android.content.Context, bitmap: Bitmap) {
    val directory = File(Environment.getExternalStorageDirectory(), "API_Implementation")
    if (!directory.exists()) {
        directory.mkdirs()
    }

    val fileName = "QRimage.png"

    val filePath = File(directory, fileName)

    try {
        val fos = FileOutputStream(filePath)
        bitmap.compress(Bitmap.CompressFormat.PNG,100,fos)
        fos.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}


