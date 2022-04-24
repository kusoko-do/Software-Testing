package removeTest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.text.ParseException

class Test {
    private fun stringToLinkedList(input: String): LinkedList<String>{
        return LinkedList(input.split(","))
    }

    private val linkedList = LinkedList<Int>()

    @DisplayName(value = "基路径测试用例")
    @Test
    @Throws(ParseException::class)
    fun removeTest1(){
        val expected = listOf(1, 2)
        linkedList.add(1)
        linkedList.add(2)
        linkedList.remove(3)
        assertEquals(linkedList, LinkedList(expected))
    }

    @DisplayName(value = "基路径测试用例")
    @Test
    @Throws(ParseException::class)
    fun removeTest2(){
        val expected = listOf(1)
        linkedList.add(1)
        linkedList.add(2)
        linkedList.remove(2)
        assertEquals(linkedList, LinkedList(expected))
    }

    @DisplayName(value = "基路径测试用例")
    @Test
    @Throws(ParseException::class)
    fun removeTest3(){
        val expected = listOf(1)
        linkedList.add(null)
        linkedList.add(1)
        linkedList.remove(null)
        assertEquals(linkedList, LinkedList(expected))
    }

    @DisplayName(value = "基路径测试用例")
    @Test
    @Throws(ParseException::class)
    fun removeTest4(){
        val expected = listOf(1, 2)
        linkedList.add(1)
        linkedList.add(2)
        linkedList.remove(null)
        assertEquals(linkedList, LinkedList(expected))
    }
}