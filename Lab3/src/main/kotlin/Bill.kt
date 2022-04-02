import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Bill(startTime:String, endTime:String, isStartDst:Boolean, isEndDst:Boolean){
    private val formatStartTime = dateFormat(startTime)
    private val formatEndTime = dateFormat(endTime)
    private var duration = java.time.Duration.between(formatStartTime, formatEndTime).toSeconds().toInt()
    init {
        if(duration%60 == 0) {
            duration /= 60
        }
        else{
            duration = duration/60 + 1
        }
        if(isStartDst == isEndDst){

        }
        else if(isStartDst) {
            duration += 60
        }
        else{
            duration -= 60
        }
    }


    private fun fee(): Double {
        return if(duration <= 20){
            duration * 0.05
        } else{
            1.00 + (duration-20) * 0.10
        }
    }

    fun display(): String {
        //println("${formatStartTime}, ${formatEndTime}, $isStartDst, $isEndDst, $duration, ${fee()}\n");
        if(duration>1800){
            return ("账单错误")
        }
        else if(duration<=0){
            return ("账单错误")
        }
        return("${fee()}$")
    }

    private fun dateFormat(time:String):LocalDateTime{
        val ft = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return LocalDateTime.parse(time, ft)
    }
}