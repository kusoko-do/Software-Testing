import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import java.text.ParseException

class EquivalenceTest {
    @DisplayName(value = "等价类测试用例")
    @ParameterizedTest
    @CsvFileSource(resources = ["/等价类测试用例.csv"], numLinesToSkip = 0, encoding = "UTF-8" )
    @Throws(ParseException::class)
    fun equivalenceTest(startTime:String, endTime:String, isStartDst:Boolean, isEndDst:Boolean, expected:String?){
        val bill = Bill(startTime, endTime, isStartDst, isEndDst)
        assertEquals(expected, bill.display())
    }
}