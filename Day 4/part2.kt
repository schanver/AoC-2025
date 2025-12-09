import java.io.File
import java.io.InputStream
import kotlin.collections.mutableListOf

fun main() {
  var iteration = 0
  var totalNum = 0
  var canBeRemoved : Boolean = true
  var count = 0
  var pairsToReplace : MutableList<Pair<Int,Int>>
  val list = File("input.txt")
  .readLines()
  .map { it.toMutableList() }
  .toMutableList()
  var neighbours : MutableList<Char>

  while(canBeRemoved) {
    count = 0
    pairsToReplace = mutableListOf()
    for(i in 0 until list.size) {
      for(j in 0 until list[i].size) {
        if(list[i][j] != '@') continue
        if(i == 0) {
          if(j == 0) {
            neighbours = mutableListOf(
              list[i][j+1],
              list[i+1][j],
              list[i+1][j+1]
            )
            if(neighbours.count { it == '@' } < 4) {
              count++
              pairsToReplace.add(Pair(i,j))
            }
          }
          else if(j == (list[i].size) -1){
            neighbours = mutableListOf(
              list[i][j-1],
              list[i+1][j],
              list[i+1][j-1]
            )
            if(neighbours.count { it == '@' } < 4) {
              count++
              pairsToReplace.add(Pair(i,j))
            }
          }
          else {
            neighbours = mutableListOf(
              list[i][j-1],
              list[i][j+1],
              list[i+1][j-1],
              list[i+1][j],
              list[i+1][j+1]
            )
            if(neighbours.count { it == '@' } < 4) {
              count++
              pairsToReplace.add(Pair(i,j))
            }
          }
        }
        else if(i == list.size - 1) {
          if(j == 0) {
            neighbours = mutableListOf(
              list[i][j+1],
              list[i-1][j],
              list[i-1][j+1]
            )
            if(neighbours.count { it == '@' } < 4) {
              count++
              pairsToReplace.add(Pair(i,j))
            }          }
          else if(j == (list[i].size) -1){
            neighbours = mutableListOf(
              list[i][j-1],
              list[i-1][j],
              list[i-1][j-1]
            )
            if(neighbours.count { it == '@' } < 4) {
              count++
              pairsToReplace.add(Pair(i,j))
              }
          }
          else {
            neighbours = mutableListOf(
              list[i-1][j-1],
              list[i-1][j],
              list[i-1][j+1],
              list[i][j-1],
              list[i][j+1],
            )
            if(neighbours.count { it == '@' } < 4) {
              count++
              pairsToReplace.add(Pair(i,j))
              }
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
            if(neighbours.count { it == '@' } < 4) {
              count++
              pairsToReplace.add(Pair(i,j))
            }
          }
          else if(j == (list[i].size) - 1) {
            neighbours = mutableListOf(
              list[i-1][j],
              list[i-1][j-1],
              list[i][j-1],
              list[i+1][j],
              list[i+1][j-1]
            )
            if(neighbours.count { it == '@' } < 4) {
              count++
              pairsToReplace.add(Pair(i,j))
              }
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
            if(neighbours.count { it == '@' } < 4) {
              count++
              pairsToReplace.add(Pair(i,j))
              }
          }

        }
      }
    }
    pairsToReplace.forEach { pair -> 
      list[pair.first][pair.second] = '.'
    }
    pairsToReplace.clear()
    if(count == 0) { 
      canBeRemoved = false
    }
    totalNum += count
    println("Iteration number $iteration")
    iteration++
  }
  println("Count: $totalNum")
}
