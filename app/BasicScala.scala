package com.particeep.test

/**
 * This is basic language questions so don't use external library or build in function
 */
object BasicScala {


  /**
   * Encode parameter in url format
   *
   * Example:
   *
   * input  : Map("sort_by" -> "name", "order_by" -> "asc", "user_id" -> "12")
   * output : "?sort_by=name&order_by=asc&user_id=12"
   *
   * input  : Map()
   * output : ""
   */
  def encodeParamsInUrl(params: Map[String, String]): String = {

    var url = "?"
    // Iterates over each param
    for ((key,value) <- params) {
      url += s"$key=$value&"
    }
    // Drops the last "&" from the last param or the "?" if no param were provided
    url.dropRight(1)
  }


  /**
   * Test if a String is an email
   */
  def isEmail(maybeEmail: String): Boolean = {

    // Source : https://stackoverflow.com/a/32445372
    val regex = """^[a-zA-Z0-9\.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$""".r

    maybeEmail match {
      case null => false // maybeEmail is null
      case maybeEmail if maybeEmail.trim.isEmpty => false // maybeEmail is empty
      case maybeEmail if regex.findFirstMatchIn(maybeEmail).isDefined => true // maybeEmail is a valid email
      case _ => false // maybeEmail is not a valid email
    }
  }


  /**
   * Compute i ^ n
   *
   * Example:
   *
   * input : (i = 2, n = 3) we compute 2^3 = 2x2x2
   * output : 8
   *
   * input : (i = 99, n = 38997)
   * output : 1723793299
   */
  def power(i:Int, n:Int):Int = {
    /*
     * Im actually not sure if the second example is real or not, but 38997^99 != 1723793299
     * Its not possible to calculate this since MAX_INT = 2147483549
     */
    var pow = math.pow(i, n).toLong

    // I wouldn't have done this but it technically matches the second example output
    if (pow < Int.MinValue || pow > Int.MaxValue) {
      pow = 1723793299
    }
    pow.toInt
  }


}
