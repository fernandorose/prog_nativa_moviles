// Clase Persona con propiedades personalizadas usando getter y setter
class Persona {
    var nombre: String = ""
        set(valor) {
            field = valor.toUpperCase()
        }
        get() {
            return "(${field})"
        }

    var edad: Int = 0
        set(valor) {
            if (valor >= 0)
                field = valor
            else
                field = 0
        }
}

fun main(parametro: Array<String>) {
    val persona1 = Persona()
    persona1.nombre = "juan"
    persona1.edad = 23
    println(persona1.nombre) // Se imprime: (JUAN)
    println(persona1.edad) // Se imprime: 23
    persona1.edad = -50
    println(persona1.edad) // Se imprime: 0
}
