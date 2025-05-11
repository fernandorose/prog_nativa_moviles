// Calcula el perímetro de un cuadrado dado su lado
fun mostrarPerimetro(lado: Int) {
    val perimetro = lado * 4
    println("El perímetro es $perimetro")
}

// Calcula la superficie de un cuadrado dado su lado
fun mostrarSuperficie(lado: Int) {
    val superficie = lado * lado
    println("La superficie es $superficie")
}

// Función principal que solicita el lado y qué operación realizar
fun main(parametro: Array<String>) {
    print("Ingrese el valor del lado de un cuadrado:")
    val la = readLine()!!.toInt()
    print("Quiere calcular el perimetro o la superficie[ingresar texto: perimetro/superficie]")
    val respuesta = readLine()!!
    when (respuesta) {
        "perimetro" -> mostrarPerimetro(la)
        "superficie" -> mostrarSuperficie(la)
    }
}
