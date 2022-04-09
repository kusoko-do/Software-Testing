import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import java.text.ParseException

class DecisionTableTest {
    @DisplayName(value = "决策表测试用例")
    @ParameterizedTest
    @CsvFileSource(resources = ["/决策表测试用例.csv"], numLinesToSkip = 0, encoding = "UTF-8" )
    @Throws(ParseException::class)
    fun equivalenceTest(startTime:String, endTime:String, isStartDst:Boolean, isEndDst:Boolean, expected:String?){
        val bill = Bill(startTime, endTime, isStartDst, isEndDst)
        Assertions.assertEquals(expected, bill.display())
    }
}