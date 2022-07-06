/*
 * Etapa 2 - Observatorio
 * Crear al Observatorio, que es un objeto que conoce a todos los países y debe 
 * poder responder las consultas que se enuncian a continuación.
 */
object Observatorio() {
  val paises = ListOf<Pais>()
/*
 * Para dos países en particular, cuyos nombres se envían por parámetro, se 
 * pide poder resolver las mismas consultas de la etapa anterior:
 *
 * Poder consultar si son limítrofes.
 */
  fun sonLimitrofes(paisA: String, paisB: String) = return True
/*
 * Saber si necesitan traducción para poder dialogar
 */
  fun necesitanTraduccion(paisA: String, paisB: String) = return True 
/*
 * Conocer si son potenciales aliados.
 */
  fun sonPotencialesAliados(paisA: String, paisB: String) = return True 
/* 
 * Saber si conviene ir de compras.
 */
  fun convieneIrDeCompras(paisOrigen: String, paisDestino: String) = return True 
/* 
 * Conocer a cuánto equivale un determinado monto en la moneda local, 
 * transformado en la moneda del país de destino.
 */
  fun cuantoEquivale(monto: Double, paisOrigen: String, paisDestino: String) = return True 
/*  
 * Ojo, que se pide (a propósito) que los parámetros sean los nombres de los 
 * países y no los objetos que los representan - de hecho es lo único que 
 * cambia entre esta etapa y la anterior. Para este punto puede resultar un 
 * poco molesto, pero nos va a facilitar la etapa siguiente.
 */
/*  
 * Sobre el conjunto de todos los países:
 * 
 * Obtener los códigos ISO de los 5 países con mayor densidad poblacional.
 */
/* 
 * Indicar el nombre del continente con más paises plurinacionales.
 */
/* 
 * Conocer el promedio de densidad poblacional de los países insulares (o sea, 
 * aquellos países que son islas).
 */


 }