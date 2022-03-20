import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import java.text.ParseException

class BoundaryValueTest {
    fun param_triangle(a:Int, b:Int, c:Int, expected:String){
        val triangle = Triangle()
        val type = triangle.classify(a,b,c)
        assertEquals(expected, type)
    }

    @DisplayName(value = "三角形一般边界测试用例")
    @ParameterizedTest
    @CsvFileSource(resources = ["/resources/三角形一般边界测试用例.csv"], numLinesToSkip = 0, encoding = "UTF-8" )
    @Throws(ParseException::class)
    fun fileTest1(a: Int, b: Int, c: Int, expected: String?) {
        val triangle = Triangle()
        val type = triangle.classify(a, b, c)
        assertEquals(expected, type)
    }

    @DisplayName(value = "三角形健壮测试用例")
    @ParameterizedTest
    @CsvFileSource(resources = ["/resources/三角形健壮测试用例.csv"], numLinesToSkip = 0, encoding = "UTF-8" )
    @Throws(ParseException::class)
    fun fileTest2(a: Int, b: Int, c: Int, expected: String?) {
        val triangle = Triangle()
        val type = triangle.classify(a, b, c)
        assertEquals(expected, type)
    }

    @DisplayName(value = "三角形健壮性最坏情况测试用例")
    @ParameterizedTest
    @CsvFileSource(resources = ["/resources/三角形健壮性最坏情况测试用例.csv"], numLinesToSkip = 0, encoding = "UTF-8" )
    @Throws(ParseException::class)
    fun fileTest3(a: Int, b: Int, c: Int, expected: String?) {
        val triangle = Triangle()
        val type = triangle.classify(a, b, c)
        assertEquals(expected, type)
    }

    @DisplayName(value = "三角形最坏情况一般边界值测试用例")
    @ParameterizedTest
    @CsvFileSource(resources = ["/resources/三角形最坏情况一般边界值测试用例.csv"], numLinesToSkip = 0, encoding = "UTF-8" )
    @Throws(ParseException::class)
    fun fileTest4(a: Int, b: Int, c: Int, expected: String?) {
        val triangle = Triangle()
        val type = triangle.classify(a, b, c)
        assertEquals(expected, type)
    }
}