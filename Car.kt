class Car(val type: String,val model:Int, val price:Double,
          val milesDrive:Int, val owner:String)

class Customer(val name:String, val carBought: Car)
fun caculateSumPayment(carPrice:Double): Double {
    val taxRate = when {
        carPrice <= 20000.0 -> 0.05
        carPrice <=50000.0 ->0.1
        else ->0.15
    }
    return carPrice +(carPrice * taxRate)
}
fun main() {
  val cars =listOf(
      Car("BMW", 2015, 10000.0, 100, "David"),
      Car("Toyota", 2019, 39000.0, 100, "Tom"),
      Car("Mercedes", 2020, 60000.0, 100, "Hieulee")

  )

    val customer1=Customer("Hussein Alrubaves", cars[0])
    val customer2 = Customer("Bob", cars[1])
    val customer3 = Customer("Alice", cars[2])

    val customer = listOf(customer1,customer2,customer3)

    var totalSum=0.0

    for(Customer in customer){
        val car = Customer.carBought
        val totalPayment = caculateSumPayment(car.price)
        totalSum += totalPayment
        println("Customer: ${Customer.name}")
        println("car: ${car.type} (${car.model})")
        println("Price: ${car.price}")
        println("Total payment (with tax): $${"%.2f".format(totalPayment)}")
        println("-------------")
    }
}