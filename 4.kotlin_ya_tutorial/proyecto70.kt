// Muestra un mensaje de presentación
fun presentacion() {
    println("Programa que permite cargar dos valores por teclado.")
    println("Efectua la suma de los valores")
    println("Muestra el resultado de la suma")
    println("*******************************")
}

// Solicita dos valores y los suma
fun cargarSumar() {
    print("Ingrese el primer valor:")
    val valor1 = readLine()!!.toInt()
    print("Ingrese el segundo valor:")
    val valor2 = readLine()!!.toInt()
    val suma = valor1 + valor2
    println("La suma de los dos valores es: $suma")
}

// Muestra mensaje de despedida
fun finalizacion() {
    println("*******************************")
    println("Gracias por utilizar este programa")
}

// Función principal que ejecuta todo
fun main(parametro: Array<String>) {
    presentacion()
    cargarSumar()
    finalizacion()
}