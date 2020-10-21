package Assignment1

object MapsInScala extends App {
  def defineMap: Map[String, Double] = {

    val priceOfProducts: Map[String, Double] = Map("Product1" -> 1000,
      "Product2" -> 1500,
      "Product3" -> 500,
      "Product4" -> 3000,
      "Product5" -> 2000,
      "Product6" -> 1700,
      "Product7" -> 1250,
      "Product8" -> 1400,
      "Product9" -> 2250,
      "Product10" -> 750)
    var reducedPriceMap: Map[String, Double] = Map()
    print("Output for 5 : ")
    priceOfProducts.keys.foreach { key =>
      reducedPriceMap += (key -> priceOfProducts(key) * 0.9)

    }
    reducedPriceMap
  }

  print("Output for 5: " + defineMap)
}
