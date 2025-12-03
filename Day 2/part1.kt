import java.io.File
import java.io.InputStream



fun main(args: Array<String>) {
    val inputStream: InputStream = File("input.txt").inputStream()
        var rangeList : MutableList<String> = mutableListOf()
        val numsToAdd : MutableList<Long> = mutableListOf()
        inputStream.bufferedReader().forEachLine {
            rangeList = it.split(",").toMutableList()
        }
    println(rangeList[0])
        rangeList.forEach { range -> 
            val start = range.split("-")[0]
                val end   = range.split("-")[1]
                //println("$start to $end")
                for (num in start.toLong()..end.toLong()) {
                    val str = num.toString()
                        if (str.length % 2 == 0) {
                            val middleIndex = str.length / 2
                                if (str.substring(0, middleIndex) == str.substring(middleIndex)) {
                                    numsToAdd.add(num) 
                                    println(str) 
                                }
                        }
                }

        }
        val result : Long = numsToAdd.sum()
        println(result)
}
