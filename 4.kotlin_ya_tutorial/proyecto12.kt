fun main(parametro: Array<String>) {
    // Solicita el primer valor
    print("Ingrese el primer valor:")
    val valor1 = readLine()!!.toInt()

    // Solicita el segundo valor
    print("Ingrese el segundo valor:")
    val valor2 = readLine()!!.toInt()

    // Verifica cuál es menor y aplica operaciones
    if (valor1 < valor2) {
        val suma = valor1 + valor2
        val resta = valor1 - valor2
        println("La suma de los dos valores es: $suma")
        println("La resta de los dos valores es: $resta")
    } else {
        val producto = valor1 * valor2
        val division = valor1 / valor2
        println("El producto de los dos valores es: $producto")
        println("La división de los dos valores es: $division")
    }
}