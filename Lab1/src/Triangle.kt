class Triangle {
    fun classify( a:Int, b:Int, c:Int) :String{
        if (a <1 || a>100 || b<1 || b>100 || c<1 || c> 100) {
            return "输入错误";
        }
        return if (!((a + b > c) && (a + c > b) && (b + c > a))) {
            "非三角形";
        } else if (a == b && a == c) {
            "等边三角形";
        } else if (a != b && a != c && b != c) {
            "不等边三角形";
        } else {
            "等腰三角形";
        }
    }
}