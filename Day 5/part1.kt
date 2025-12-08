import java.io.File
import java.io.InputStream 


fun main() {
  var count = 0L
  val ranges : MutableList<String> = mutableListOf()
  val ingredients: MutableList<String> = mutableListOf()
  val listOfLines : List<String> = File("input.txt").readLines()
  for(line in listOfLines) {
    if(line.contains("-")) {
      ranges.add(line)
    }
    else if(line.isNotBlank()) {
      ingredients.add(line)
    }
    else {
      continue
    }
  }
    for(ingredient in ingredients) {
      for(range in ranges) {
      val start = range.split("-")[0].toLong()
      val end   = range.split("-")[1].toLong()
      if(ingredient.toLong() <= end && ingredient.toLong() >= start) {
        println("${ingredient} is between $start and $end")
        count++
        break
      }
    }
  }
  println("$count")
}
