fun main() {
    val name = "Sven"
    val wasOnline = 2102
    val minutesValue = wasOnline / 60
    val hourValue = wasOnline / (60 * 60)

    print(agoToText(wasOnline, name, minutesValue, hourValue))
}

private fun agoToText(wasOnline: Int, name: String, minutesValue: Int, hourValue: Int): String {
    return when (wasOnline) {
        in 0..60 ->
            "$name был(а) только что"
        in 61..(60 * 60) -> minutes(minutesValue, name)
        in (60 * 60) + 1..24 * (60 * 60) -> hours(hourValue, name)
        in (24 * (60 * 60)) + 1..24 * 2 * (60 * 60) ->
            "$name был(а) сегодня"
        in (24 * 2 * (60 * 60)) + 1..24 * 3 * (60 * 60) ->
            "$name был(а) вчера"
        else ->
            "$name был(а) давно"
    }
}

private fun hours(hourValue: Int, name: String): String {
    return when {
        hourValue % 10 == 1 && hourValue % 100 == 21 -> "$name был(а) $hourValue час назад"
        hourValue % 100 in 2..4 && hourValue % 100 in 22..24 -> "$name был(а) $hourValue часа назад"
        else -> "$name был(а) $hourValue часов назад"
    }
}

private fun minutes(minutesValue: Int, name: String): String {
    return when {
        minutesValue % 10 in 2..4 && minutesValue % 100 !in 11..19 -> "$name был(а) $minutesValue минуты назад"
        minutesValue % 10 == 1 && minutesValue % 100 != 11 -> "$name был(а) $minutesValue минуту назад"
        else -> "$name был(а) $minutesValue минут назад"
    }
}