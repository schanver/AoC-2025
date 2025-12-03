import java.io.File
import java.io.InputStream

fun moduloForNegative(a: Int , b: Int) : Int {
        var result = a
        while(result < 0){
            result = ((result % b) + b) % b
        }
        return result
}

fun main() {
    val inputStream : InputStream = File("input.txt").inputStream()
        var dial = 50
        var count : Int = 0

        inputStream.bufferedReader().forEachLine { line ->
            val modified = if(line.isNotEmpty()) {
                val first = if(line[0] == 'R') '+' else '-'
                    first + line.substring(1)
            } else line
                println("$line is performed")
                val value = modified.toInt()
                val diff = dial + value  
                if(value > 0) {
                    for(i in (dial+1) .. diff) { 
                        if(i % 100 == 0) count++
                    }
                }
                else {
                    for (i in (dial-1) downTo diff) {
                        if(i % 100 == 0) count++ 
                    } 
                } 
                dial = if(diff > 0) { diff % 100 } else { moduloForNegative(diff,100) }
                println("Dial is at: $dial")
                println("Current Count: $count")
        }
        println("Final count is $count")
}
