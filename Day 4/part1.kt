import java.io.File
import java.io.InputStream
import kotlin.collections.mutableListOf

fun main() {
    var count = 0
    val list : MutableList<String> = mutableListOf()
    var neighbours : MutableList<Char>
    val inputStream: InputStream = File("input.txt").inputStream()
    inputStream.bufferedReader().forEachLine { line ->
        list.add(line)
    }

    for(i in 0 until list.size) {
      for(j in 0 until list[i].length) {
      if(list[i][j] != '@') continue
      if(i == 0) {
        if(j == 0) {
            neighbours = mutableListOf(
                list[i][j+1],
                list[i+1][j],
                list[i+1][j+1]
            )
          if(neighbours.count { it == '@' } < 4) count++
        }
        else if(j == (list[i].length) -1){
          neighbours = mutableListOf(
              list[i][j-1],
              list[i+1][j],
              list[i+1][j-1]
          )
          if(neighbours.count { it == '@' } < 4) count++
        }
        else {
          neighbours = mutableListOf(
              list[i][j-1],
              list[i][j+1],
              list[i+1][j-1],
              list[i+1][j],
              list[i+1][j+1]
          )
          if(neighbours.count { it == '@' } < 4) count++
        }
      }
      else if(i == list.size - 1) {
        if(j == 0) {
          neighbours = mutableListOf(
              list[i][j+1],
              list[i-1][j],
              list[i-1][j+1]
          )
          if(neighbours.count { it == '@' } < 4) count++
        }
        else if(j == (list[i].length) -1){
          neighbours = mutableListOf(
              list[i][j-1],
              list[i-1][j],
              list[i-1][j-1]
          )
          if(neighbours.count { it == '@' } < 4) count++
        }
        else {
          neighbours = mutableListOf(
              list[i-1][j-1],
              list[i-1][j],
              list[i-1][j+1],
              list[i][j-1],
              list[i][j+1],
          )
          if(neighbours.count { it == '@' } < 4) count++
        }
      }
      else {
          if(j == 0) {
              neighbours = mutableListOf(
                  list[i-1][j],
                  list[i-1][j+1],
                  list[i][j+1],
                  list[i+1][j],
                  list[i+1][j+1]
              )
              if(neighbours.count { it == '@' } < 4) count++
          }
          else if(j == (list[i].length) - 1) {
              neighbours = mutableListOf(
                  list[i-1][j],
                  list[i-1][j-1],
                  list[i][j-1],
                  list[i+1][j],
                  list[i+1][j-1]
              )
              if(neighbours.count { it == '@' } < 4) count++
          }
          else {
              neighbours = mutableListOf(
                  list[i-1][j-1],
                  list[i-1][j],
                  list[i-1][j+1],
                  list[i][j-1],
                  list[i][j+1],
                  list[i+1][j-1],
                  list[i+1][j],
                  list[i+1][j+1]
              )
              if(neighbours.count { it == '@' } < 4) count++
          }

      }
    }
    }
    println("Count: $count")
}
