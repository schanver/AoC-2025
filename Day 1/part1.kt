import java.io.File
import java.io.InputStream

    fun main(args: Array<String>) {
        val inputStream: InputStream = File("input.txt").inputStream()
        var dial = 50
        var count = 0

        inputStream.bufferedReader().forEachLine { line ->
            val modified = if( line.isNotEmpty()) {
                val first = if (line[0] == 'R') '+' else '-'
                first + line.substring(1)
            } else line
            val diff = dial + modified.toInt()
            dial = (diff).rem(100)
            if(dial == 0) count++ 
        } 
        println(count)
    }
