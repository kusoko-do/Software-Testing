import removeTest.LinkedList

class Test {

}

fun main() {

    val linkedList = LinkedList<String>()
    linkedList.add(null)
    linkedList.remove(null)
    println(linkedList)
}