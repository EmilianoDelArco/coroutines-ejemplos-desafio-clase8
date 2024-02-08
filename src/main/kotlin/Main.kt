package org.example

import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

//importante tener esta dependencias
//implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.2")
//implementation ("org.json:json:20211205")
//implementation("com.github.kittinunf.fuel:fuel:2.3.1")
//testImplementation("org.jetbrains.kotlin:kotlin-test")

// Función simulada de descarga de contenido
//suspend fun descargarContenido(): String {
//    delay(TimeUnit.SECONDS.toMillis(2)) // Simula una descarga que toma 2 segundos
//    return "¡Contenido descargado!"
//}

//fun main() = runBlocking {
//    println("Iniciando la descarga...")
//
//    // Crear una coroutine para la descarga
//    val resultadoDescarga: Deferred<String> = async {
//        descargarContenido()
//    }
//
//    println("Realizando otras tareas mientras se descarga el contenido...")
//
//    // El programa principal puede realizar otras tareas mientras espera la descarga
//    for (i in 1..5) {
//        delay(TimeUnit.SECONDS.toMillis(1))
//        println("Realizando tarea $i...")
//    }
//
//    // Obtener el resultado cuando esté disponible
//    val contenidoDescargado = resultadoDescarga.await()
//
//    println("Descarga completada: $contenidoDescargado")
//}

//Ejemplo 2
import kotlinx.coroutines.*

//fun main() {
//    // TODO: Crea una coroutine que imprima un mensaje después de una pausa
//    GlobalScope.launch {
//        delay(1000) // Pausa de 1 segundo
//        println("¡Hola desde la coroutine!")
//    }
//
//    // Otras tareas pueden continuar aquí
//
//    // Asegúrate de que la aplicación no se cierre inmediatamente
//    readLine()
//}


//Ejemplo 3
//suspend fun tareaPosiblementeFallida(): String {
//    delay(1000) // Simula una tarea que toma 1 segundo
//    if (randomError()) {
//        throw RuntimeException("¡Algo salió mal!")
//    }
//    return "¡Tarea completada con éxito!"
//}
//
//fun randomError(): Boolean {
//    return (0..1).random() == 1 // Simula un error ocasional
//}
//
//fun main() = runBlocking {
//    // TODO: Crea una coroutine con resultado y manejo de errores
//    try {
//        val resultado = async { tareaPosiblementeFallida() }.await()
//        println(resultado)
//    } catch (e: Exception) {
//        println("¡Error: ${e.message}")
//    }
//}

//Desafio

suspend fun corredor(nombre: String, velocidad: Long) {
    var distanciaRecorrida = 0
    while (distanciaRecorrida < 100) {
        delay(velocidad) // Simula la velocidad del corredor
        distanciaRecorrida += 10
        println("$nombre ha recorrido $distanciaRecorrida metros.")
    }
    println("$nombre ha cruzado la línea de meta.")
}

fun main() = runBlocking {
    val corredor1 = async { corredor("Corredor 1", 100) }
    val corredor2 = async { corredor("Corredor 2", 150) }

    // Esperar a que ambos corredores crucen la línea de meta
    corredor1.await()
    corredor2.await()

    // Determinar el ganador
    println("¡Carrera terminada!")
    val ganador = if (corredor1.isActive) "Corredor 2" else "Corredor 1"
    println("El ganador es: $ganador")
}
