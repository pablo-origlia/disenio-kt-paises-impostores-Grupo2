class Pais(
    val nombre: String, 
    val codigoIso3: String, 
    var poblacion: Int, 
    var superficie: Double, 
    val continente: String, 
    var codigoMoneda: String
    var cotizacionDolar: Double, 
    val paisesLimitrofes: ListOf<Pais>, 
    val bloquesRegionales: ListOf<String>, 
    val idiomasOficiales: ListOf<String>) {
}