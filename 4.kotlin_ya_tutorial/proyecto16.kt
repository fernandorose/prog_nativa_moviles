fun main(parametro: Array<String>) {
    // Solicita un valor entero
    print("Ingrese un valor entero:")
    val valor = readLine()!!.toInt()

    // Determina si el número es par o impar, y calcula cuadrado o cubo
    val resultado = if (valor % 2 == 0) {
        print("Cuadrado:")
        valor * valor
    } else {
        print("Cubo:")
        valor * valor * valor
    }

    // Imprime el resultado
    print(resultado)
}