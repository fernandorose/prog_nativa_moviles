fun main(parametro: Array<String>) {
    // Solicita el precio del producto
    print("Ingrese el precio del producto:")
    val precio = readLine()!!.toDouble()

    // Solicita la cantidad de productos
    print("Ingrese la cantidad de productos:")
    val cantidad = readLine()!!.toInt()

    // Calcula el total a pagar
    val total = precio * cantidad
    println("El total a pagar es $total")
}