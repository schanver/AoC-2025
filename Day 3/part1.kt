import java.io.File
import java.io.InputStream

fun main() {
  var sum = 0
  val listOfLines : List<String> = File("input.txt").readLines()
  for(lines in listOfLines) {
    var first = lines[0]
    var second = lines[1]
    for(index in 1 .. lines.length - 2) {
      if(lines[index] > first) {
        first   = lines[index]
        second  = lines[index + 1]
      }
      else if(lines[index] > second) {
        second = lines[index]
      }
    }
    if(lines.last() > second) {
      second = lines.last()
    }
    println("$first$second")
    sum += ("$first$second").toInt()

  }
  println(sum)
}
