import java.io.File 
import java.math.BigInteger

fun main() {
  val expected = BigInteger("4277556")
  var result = BigInteger("0")
  var sumColumn = BigInteger("0")
  var multColumn = BigInteger("1")
  val listOfValues : MutableList<MutableList<String>> = mutableListOf()
  val listOfLines : List<String> = File("input.txt").readLines()
  
  listOfLines.forEach { line ->
    val values = line.trim()
      .split(" ")
      .filter { it.isNotEmpty() }
      .toMutableList()
    listOfValues.add(values)
  }
  
  for(j in 0 ..< listOfValues[0].size) {
    if(j != 0) {
      result += if(sumColumn > BigInteger.ZERO) sumColumn else multColumn
    }
    sumColumn = BigInteger("0")
    multColumn = BigInteger("1")
    
    for(i in 0 ..< listOfValues.size - 1) {
      println("Result: $result")
      if(listOfValues[listOfValues.size - 1][j] == "*") {
        multColumn *= listOfValues[i][j].toBigInteger()
      }
      else if(listOfValues[listOfValues.size - 1][j] == "+") {
        sumColumn += listOfValues[i][j].toBigInteger()
      }
    }
  }
  result += if(sumColumn > BigInteger.ZERO) sumColumn else multColumn
  println("Result: $result")
  println("Expected: $expected")
}
