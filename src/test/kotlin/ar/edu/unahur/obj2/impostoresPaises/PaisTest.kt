class PaisTest : DescribeSpec ({
  val argentina = Pais(    
    nombre = "Argentina", 
    codigoIso3 = "ARG", 
    poblacion = 47000000, 
    superficie = 2780400.0, 
    continente = "America", 
    codigoMoneda = "ARS",
    cotizacionDolar = 135.6, 
    bloquesRegionales = ListOf<String>("UNASUR", "MERCOSUR"), 
    idiomasOficiales = ListOf<String>("español","guarani","qom")
  )
  describe("Test de Pais") {
    it("Comprobación de atributos") {
      return 
    }
  }