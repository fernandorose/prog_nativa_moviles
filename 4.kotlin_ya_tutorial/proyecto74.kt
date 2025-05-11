// Función para mostrar un mensaje con decoración
fun mmostrarMensaje(mensaje: String) {
    println("*************************************************")
    println(mensaje)
    println("*************************************************")
}

// Función para ingresar dos valores y mostrar su suma
fun cargarSumar() {
    print("Ingrese el primer valor:")
    val valor1 = readLine()!!.toInt()
    print("Ingrese el segundo valor:")
    val valor2 = readLine()!!.toInt()
    val suma = valor1 + valor2
    println("La suma de los dos valores es: $suma")
}

// Función principal que muestra mensajes y realiza la suma
fun main(parametro: Array<String>) {
    mmostrarMensaje("El programa calcula la suma de dos valores ingresados por teclado.")
    cargarSumar()
    mmostrarMensaje("Gracias por utilizar este programa")
}
