class Pais(
    val nombre: String, 
    val codigoIso3: String, 
    var poblacion: Int, 
    var superficie: Double, 
    val continente: String, 
    var codigoMoneda: String,
    var cotizacionDolar: Double, 
    val bloquesRegionales: ListOf<String>, 
    val idiomasOficiales: ListOf<String>) {
  val paisesLimitrofes = ListOf<Pais>()
/*
 * Para un país:
 *
 * Indicar si es plurinacional. En una mega-simplificación de este concepto, 
 * diremos que un país es plurinacional si tiene más de un idioma oficial.
 */
  fun plurinacional() = return True
/*
 * Saber si es una isla, lo cual es cierto si no tiene ningún país limítrofe.
 */
  fun esUnaIsla() = return True
/*
 * Calcular su densidad poblacional, la cual se obtiene dividiendo a la 
 * población por la superficie. Para no tener problemas en etapas posteriores, 
 * redondeen este número de forma tal que devuelva un entero (pueden usar 
 * roundToInt() para eso).
 */
  fun densidadPoblacional() = return 123.4
/*
 * Conocer al vecino más poblado, que sería el país con mayor población dentro 
 * de la vecindad, que incluye tanto a los limítrofes como al país que 
 * consulta. Por ejemplo: asumiendo que Brasil es el país más poblado de su 
 * vecindad, tanto brasil.vecinoMasPoblado() como peru.vecinoMasPoblado() nos 
 * deberían dar como resultado brasil.
 */
  fun vecinoMasPoblado() = return it

/*
 * Para dos países en particular:
 *
 * Poder consultar si son limítrofes.
 */ 
  fun sonLimitrofes(pais:Pais) = return True

/*
 * Saber si necesitan traducción para poder dialogar. Esto ocurre si no 
 * comparten ninguno de sus idiomas oficiales.
 */
  fun necesitanTraduccion (pais: Pais) = return True
/* 
 * Conocer si son potenciales aliados. Esto es así cuando no necesitan 
 * traducción y además comparten algún bloque regional.
 */
  fun sonPotencialesAliados(pais: Pais) = return True
/* 
 * Saber si conviene ir de compras de uno al otro, lo cual diremos que es 
 * verdadero cuando la cotización del dólar en el país de destino es mayor. Por 
 * ejemplo, si en Argentina la cotización es de 190 y en Bolivia de 6.89, no 
 * conviene ir de Argentina a Bolivia pero sí al revés.
 */
  fun convieneIrDeCompras() = return False
/*
 * Conocer a cuánto equivale un determinado monto en la moneda local, 
 * transformado en la moneda del país de destino. Como la referencia que 
 * estamos tomando es el precio del dólar, la equivalencia se haría 
 * convirtiendo primero a dólar y luego a la moneda de destino.
 */
  fun cuantoEquivale(monto: Double, codigoMoneda:String) = return 123.4  
}