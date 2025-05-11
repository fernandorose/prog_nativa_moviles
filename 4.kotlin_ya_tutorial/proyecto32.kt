fun main(parametro: Array<String>) {
    print("Ingrese un valor:")
    val valor = readLine()!!.toInt()
    var x = 1

    // Imprime los números desde 1 hasta el valor ingresado
    while (x <= valor) {
        println(x)
        x = x + 1
    }
}