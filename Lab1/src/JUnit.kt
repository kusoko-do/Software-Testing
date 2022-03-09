import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TriangleTest{
    @Test
    @DisplayName("输入错误")
    fun parameters_error_test() {
        val triangle = Triangle()
        val error_type = triangle.classify(0, 4, 5)
        assertEquals("输入错误", error_type)
    }

    @Test
    @DisplayName("不等边三角形")
    fun scalene_test() {
        val triangle = Triangle()
        val error_type = triangle.classify(3, 4, 6)
        assertEquals("不等边三角形", error_type)
    }

    @Test
    @DisplayName("等边三角形")
    fun equilateral_test() {
        val triangle = Triangle()
        val error_type = triangle.classify(3, 3, 3)
        assertEquals("等边三角形", error_type)
    }

    @Test
    @DisplayName("等腰三角形")
    fun isosceles_test() {
        val triangle = Triangle()
        val error_type = triangle.classify(3, 3, 2)
        assertEquals("等腰三角形", error_type)
    }
}