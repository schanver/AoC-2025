import java.io.File
import java.io.InputStream


fun main() {
  var sum = 0L
  val listOfLines : List<String> = File("input.txt").readLines()
  for(lines in listOfLines) {
    val digitList : MutableList<Char> = mutableListOf()
    digitList.clear()
    var spaceLeft = 3
    digitList.add(lines[0])
    for(i in 1 .. lines.toString().length-1) {
        if(lines[i].code > digitList.last().code && spaceLeft > 0) {
            val last = digitList.size
            digitList[last-1] = lines[i]
            spaceLeft--
        }
        else if(digitList.size < 12){
            digitList.add(lines[i])
        }
        else {
            continue
        }
    }
    val voltage = digitList.joinToString("").toLong()
    println("Voltage: $voltage")
    sum += voltage
  }
  println("Sum: $sum")
}
