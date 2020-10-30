package com.particeep.test

/**
  * Tell developer names by the department code
  * Expected result:
  * Map(frontend -> List(Remy, Alexandre), analytics -> List(Pierre), api -> List(Noe))
  */
object MapYourMap {

  val devNames = Map("dev1" -> "Pierre", "dev2" -> "Remy", "dev3" -> "Noe", "dev4" -> "Alexandre")
  val devDepartments = Map("dev1" -> "analytics", "dev2" -> "frontend", "dev3" -> "api", "dev4" -> "frontend")

  val namesInDepartments:Map[String, List[String]] = getDevsAndDepartements(devNames, devDepartments)


  // TODO : Sort the map
  // Gets the departments and each dev associated to a specific one in a Map
  def getDevsAndDepartements(devMap : Map[String,String], deptMap : Map[String,String] ): Map[String, List[String]] = {

    var devDepartmentsPlus :Map[String, List[String]] = Map()

    for ((key,value) <- deptMap) {
      devDepartmentsPlus += (value -> getDevsByDepartment(value, devMap, deptMap))
    }
    devDepartmentsPlus
  }

  // Gets the devs associated to a specific department
  def getDevsByDepartment(dept : String, devMap : Map[String,String], deptMap : Map[String,String] ) : List[String] = {

    var devList : ListBuffer[String] = ListBuffer()

    for ((key,value) <- deptMap) {

      // If the departments match
      if(value.equals(dept)){
        devList += devMap(key)
      }
    }
    devList.toList
  }
}
