// Diccionario de alumnos con materias y notas usando Map y List
data class Materia(val nombre: String, val nota: Int)

fun cargar(alumnos: MutableMap<Int, MutableList<Materia>>) {
    print("¿Cuántos alumnos cargará?: ")
    val cant = readLine()!!.toInt()

    for (i in 1..cant) {
        print("Ingrese DNI: ")
        val dni = readLine()!!.toInt()
        val listaMaterias = mutableListOf<Materia>()

        do {
            print("Ingrese materia del alumno: ")
            val nombre = readLine()!!
            print("Ingrese nota: ")
            val nota = readLine()!!.toInt()
            listaMaterias.add(Materia(nombre, nota))
            print("¿Ingresar otra nota? (si/no): ")
            val opcion = readLine()!!
        } while (opcion == "si")

        alumnos[dni] = listaMaterias
    }
}

fun imprimir(alumnos: MutableMap<Int, MutableList<Materia>>) {
    for ((dni, listaMaterias) in alumnos) {
        println("DNI del alumno: $dni")
        for (materia in listaMaterias) {
            println("Materia: ${materia.nombre}")
            println("Nota: ${materia.nota}")
        }
        println()
    }
}

fun consultaPorDni(alumnos: MutableMap<Int, MutableList<Materia>>) {
    print("Ingrese el DNI del alumno a consultar: ")
    val dni = readLine()!!.toInt()

    if (dni in alumnos) {
        println("Cursa las siguientes materias:")
        val lista = alumnos[dni]
        if (lista != null) {
            for ((nombre, nota) in lista) {
                println("Nombre de materia: $nombre")
                println("Nota: $nota")
            }
        }
    }
}

fun main(args: Array<String>) {
    val alumnos: MutableMap<Int, MutableList<Materia>> = mutableMapOf()
    cargar(alumnos)
    imprimir(alumnos)
    consultaPorDni(alumnos)
}
