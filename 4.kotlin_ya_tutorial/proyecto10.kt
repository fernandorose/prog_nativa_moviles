fun main(parametro: Array<String>) {
    // Solicita el sueldo del empleado
    print("Ingrese el sueldo del empleado:")
    val sueldo = readLine()!!.toDouble()

    // Verifica si debe pagar impuestos
    if (sueldo > 3000) {
        println("Debe pagar impuestos")
    }
}