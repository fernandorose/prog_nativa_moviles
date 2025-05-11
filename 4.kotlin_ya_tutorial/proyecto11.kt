fun main(parametro: Array<String>) {
    // Solicita el primer valor
    print("Ingrese primer valor:")
    val valor1 = readLine()!!.toInt()

    // Solicita el segundo valor
    print("Ingrese segundo valor:")
    val valor2 = readLine()!!.toInt()

    // Determina cuál valor es mayor
    if (valor1 > valor2)
        print("El mayor valor es $valor1")
    else
        print("El mayor valor es $valor2")
}