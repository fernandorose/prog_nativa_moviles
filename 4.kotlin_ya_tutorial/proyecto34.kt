fun main(parametro: Array<String>) {
    print("Cuantas piezas procesará:")
    val n = readLine()!!.toInt()
    var x = 1
    var cantidad = 0

    // Procesa piezas y cuenta las aptas por su medida
    while (x <= n) {
        print("Ingrese la medida de la pieza:")
        val largo = readLine()!!.toDouble()
        if (largo >= 1.20 && largo <= 1.30)
            cantidad = cantidad + 1
        x = x + 1
    }
    print("La cantidad de piezas aptas son: $cantidad")
}