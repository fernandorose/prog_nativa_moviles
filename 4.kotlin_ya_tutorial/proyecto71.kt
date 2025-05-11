// Función para cargar dos valores, sumarlos e imprimir el resultado
fun cargarSuma() {
    print("Ingrese el primer valor:")
    val valor1 = readLine()!!.toInt()
    print("Ingrese el segundo valor:")
    val valor2 = readLine()!!.toInt()
    val suma = valor1 + valor2
    println("La suma de los dos valores es: $suma")
}

// Función para imprimir una línea de separación
fun separacion() {
    println("*******************************")
}

// Función principal que repite la carga y suma 5 veces
fun main(parametro: Array<String>) {
    for (i in 1..5) {
        cargarSuma()
        separacion()
    }
}
