import java.io.File
import java.io.InputStream 


fun main() {
  val lines = File("input.txt").readLines()

  val ranges = lines.takeWhile { it.isNotBlank() }
  .map { line ->
    val (start, end) = line.split("-").map { it.toLong() }
    start to end
  }

  val sorted = ranges.sortedBy { it.first }

  var total = 0L

  var (curStart, curEnd) = sorted.first()

  for ((s, e) in sorted.drop(1)) {
    if (s <= curEnd + 1) {
      curEnd = maxOf(curEnd, e)
    } else {
      total += (curEnd - curStart + 1)
      curStart = s
      curEnd = e
    }
  }

  total += (curEnd - curStart + 1)

  println(total)
}


