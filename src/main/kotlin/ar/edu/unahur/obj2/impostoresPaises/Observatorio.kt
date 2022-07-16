package ar.edu.unahur.obj2.impostoresPaises

/*
 * Etapa 2 - Observatorio
 * Crear al Observatorio, que es un objeto que conoce a todos los países y debe 
 * poder responder las consultas que se enuncian a continuación.
 */
object Observatorio {
  val paises = mutableListOf<Pais>()

  fun agregarPais(pais: Pais) = paises.add(pais)

  fun obtenerPais(nombrePais: String): Pais? = paises?.find {p->p.nombre == nombrePais}
/*
 * Para dos países en particular, cuyos nombres se envían por parámetro, se 
 * pide poder resolver las mismas consultas de la etapa anterior:
 *
 * Poder consultar si son limítrofes.
 */
  fun sonLimitrofes(paisA: String, paisB: String): Boolean{
    val unPais = obtenerPais(paisA)
    val otroPais = obtenerPais(paisB)

    return obtenerPais(paisA)!!.paisesLimitrofes.contains(otroPais) && obtenerPais(paisB)!!.paisesLimitrofes.contains(unPais)
}
/*
 * Saber si necesitan traducción para poder dialogar
 */
  fun necesitanTraduccion(paisA: String, paisB: String): Boolean {

    return obtenerPais(paisA)!!.idiomasOficiales.intersect(obtenerPais(paisB)!!.idiomasOficiales).isEmpty()
}

  fun compartenBloqueRegional(paisA: String, paisB: String): Boolean{
    return obtenerPais(paisA)!!.bloquesRegionales.intersect(obtenerPais(paisB)!!.bloquesRegionales).isNotEmpty()
  }
/*
 * Conocer si son potenciales aliados.
 */
  fun sonPotencialesAliados(paisA: String, paisB: String): Boolean{

    return !necesitanTraduccion(paisA,paisB) && compartenBloqueRegional(paisA,paisB)
  }

/* 
 * Saber si conviene ir de compras.
 */
  fun convieneIrDeComprasDesdeA(paisOrigen: String, paisDestino: String): Boolean {

      return obtenerPais(paisDestino)!!.cotizacionDolar > obtenerPais(paisOrigen)!!.cotizacionDolar
}
/* 
 * Conocer a cuánto equivale un determinado monto en la moneda local, 
 * transformado en la moneda del país de destino.
 */
  fun aCuantoEquivaleEn(monto: Double, paisOrigen: String, paisDestino: String): Double{
    return monto/obtenerPais(paisOrigen)!!.cotizacionDolar * obtenerPais(paisDestino)!!.cotizacionDolar
  }
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

  fun codigosPaisesMasDensamentePoblados(): MutableList<String> {
    var densidades = paises.map { p->p.densidadPoblacional() }.sorted().take(5)
    var codigosISO: MutableList<String> = mutableListOf()

    densidades.forEach() {
      codigosISO.addAll(paises.filter { p -> p.densidadPoblacional() == it }.map { p -> p.codigoIso3 })
    }

    return codigosISO
  }
/*
 * Indicar el nombre del continente con más paises plurinacionales.
 */

  //fun continenteConMasPaisesPlurinacionales(): String {}

/*
 * Conocer el promedio de densidad poblacional de los países insulares (o sea, 
 * aquellos países que son islas).
 */
  //fun promedioDensidadPoblacionalPaisesInsulares(): Double {}

 }