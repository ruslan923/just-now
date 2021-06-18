fun main() {
    val name = "Sven"
    val wasOnline = 5198
    val minutesValue = wasOnline / 60
    val hourValue = wasOnline / (60 * 60)

    agoToText(wasOnline, name, minutesValue, hourValue)
}

private fun agoToText(wasOnline: Int, name: String, minutesValue: Int, hourValue: Int) {
    when (wasOnline) {
        in 0..60 ->
            print("$name был(а) только что")
        in 61..(60 * 60) -> minutes(minutesValue, name)
        in (60 * 60) + 1..24 * (60 * 60) -> hours(hourValue, name)
        in (24 * (60 * 60)) + 1..24 * 2 * (60 * 60) ->
            print("$name был(а) сегодня")
        in (24 * 2 * (60 * 60)) + 1..24 * 3 * (60 * 60) ->
            print("$name был(а) вчера")
        else ->
            print("$name был(а) давно")
    }
}

private fun hours(hourValue: Int, name: String) {
    when (hourValue) {
        1, 21 ->
            print("$name был(а) $hourValue час назад")
        in 2..4, in 22..24 ->
            print("$name был(а) $hourValue часа назад")
        in 5..20 ->
            print("$name был(а) $hourValue часов назад")
    }
}

private fun minutes(minutesValue: Int, name: String) {
    when (minutesValue) {
        1, 21, 31, 41, 51 ->
            print("$name был(а) $minutesValue минуту назад")
        in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 ->
            print("$name был(а) $minutesValue минуты назад")
        in 5..20, 11, in 25..30, in 35..40, in 45..50, in 55..60 ->
            print("$name был(а) $minutesValue минут назад")
    }
}