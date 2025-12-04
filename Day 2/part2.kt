import java.io.File
import java.io.InputStream

fun main() {
  val inputStream: InputStream = File("input.txt").inputStream()
  var rangeList : MutableList<String> = mutableListOf()
  val numsToAdd : MutableList<Long> = mutableListOf()
  var sum = 0L
  inputStream.bufferedReader().forEachLine {
    rangeList = it.split(",").toMutableList()
  }
  rangeList.forEach { range ->
    val start = range.split("-").first()
    val end   = range.split("-").last()
    for(num in start.toLong() .. end.toLong()) {
      val stringOfNum = num.toString()
      val strLen = stringOfNum.length
      for(subStrLen in 1 .. strLen/2) {
        if(strLen % subStrLen != 0) continue

        val count = strLen / subStrLen
        if(count < 2) continue


        val pattern = stringOfNum.substring(0,subStrLen)
        val s = buildString { 
          repeat(count) { append(pattern) }
        }
      //  println("Pattern: $pattern")
      //  println("Appended Pattern: $s")
        //println("Our number: $stringOfNum")
        
        if(s == stringOfNum) {
          sum += num
          break
        //  println("Sum: $sum")
        }
      }

    }
  }

  println("Result: $sum")
}
