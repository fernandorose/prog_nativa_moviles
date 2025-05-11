fun main(argumento: Array<String>) {
    // Solicita al usuario el primer valor
    print("Ingrese primer valor:")
    val valor1 = readLine()!!.toInt()

    // Solicita al usuario el segundo valor
    print("Ingrese segundo valor:")
    val valor2 = readLine()!!.toInt()

    // Suma los valores
    val suma = valor1 + valor2
    println("La suma de $valor1 y $valor2 es $suma")

    // Multiplica los valores
    val producto = valor1 * valor2
    println("El producto de $valor1 y $valor2 es $producto")
}