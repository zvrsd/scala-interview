package com.particeep.test

object WhatsWrong1 {

  trait Interface {
    val city: String
    val support: String = s"Ici c'est $city !"
  }

  case object Supporter extends Interface {

    override val city = "Paris"
  }
  /*
   * It prints "Paris"
   */
  Supporter.city //What does this print ?

  /*
   * It prints "Ici c'est null !"
   *
   * Because when the support variable is set, it takes the content
   * of city, which is null at that time. We could change city as much
   * as we want, the support value will not change
   *
   * To overcome this issue, instead of getting the value from the support
   * variable, we could dynamically get it, via a function
   *
   * def getSupport : String = {
   *  s"Ici c'est $city !"
   * }
   *
   */
  Supporter.support //What does this print and why ? How to fix it ?
}
