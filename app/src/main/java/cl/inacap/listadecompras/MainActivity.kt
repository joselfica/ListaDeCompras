package cl.inacap.listadecompras

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    // Lista mutable donde se almacenarán los productos
    // ingresados por el usuario.
    //
    // mutableListOf() permite agregar nuevos elementos
    // durante la ejecución de la aplicación.
    private val productos = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Carga el diseño que creamos en:
        //
        // res/layout/activity_main.xml
        //
        // De esta manera, Android sabe qué interfaz
        // debe mostrar cuando se inicia esta Activity.
        setContentView(R.layout.activity_main)

        // Buscamos el campo de texto creado en XML.
        val etProducto = findViewById<EditText>(R.id.etProducto)

        // Buscamos el botón creado en XML.
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        // Buscamos el TextView donde mostraremos
        // los productos.
        val tvProductos = findViewById<TextView>(R.id.tvProductos)

        // Definimos qué debe ocurrir cuando el usuario
        // presiona el botón "Agregar".
        btnAgregar.setOnClickListener {

            // Obtenemos el texto escrito en el EditText.
            //
            // toString() convierte el contenido en String.
            //
            // trim() elimina espacios al principio y al final.
            val producto = etProducto.text.toString().trim()

            // Comprobamos si el usuario dejó vacío
            // el campo de texto.
            if (producto.isEmpty()) {

                // Mostramos un mensaje de advertencia.
                Toast.makeText(
                    this,
                    "Ingrese un producto",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                // Agregamos el producto a nuestra
                // lista mutable.
                productos.add(producto)

                // Convertimos todos los productos
                // de la lista en un solo texto.
                val textoProductos = productos.joinToString(
                    separator = "\n"
                ) { productoActual ->
                    "• $productoActual"
                }

                // Actualizamos el TextView para mostrar
                // los productos almacenados.
                tvProductos.text = getString(R.string.productos_titulo, textoProductos)

                // Limpiamos el campo de texto para que
                // el usuario pueda ingresar otro producto.
                etProducto.text.clear()
            }
        }
    }
}