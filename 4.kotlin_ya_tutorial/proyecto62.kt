fun main(parametro: Array<String>) {
    var total = 0

    // Evalúa 10 sueldos y acumula solo los altos
    for(i in 1..10) {
        print("Ingrese sueldo del operario:")
        val sueldo = readLine()!!.toInt()
        total += when {
            sueldo > 5000 -> {
                println("Sueldo alto")
                sueldo
            }
            sueldo > 2000 -> {
                println("Sueldo medio")
                0
            }
            else -> {
                println("Sueldo bajo")
                0
            }
        }
    }
    println("Gastos totales en sueldos altos: $total")
}