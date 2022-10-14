interface StringCalculator {
    fun countOcurrencesOfCharacter(text: String, character: Char): Int
    fun removeCharacter(text: String, character: Char): String
    fun replaceOcurrencesWithNewCharacter(text: String, characterToReplace: Char, newCharacter: Char): String
    fun concatenate(text1: String, text2: String): String
    fun lengthOfString(text: String): Int
    fun length5StarRating(text: String): String
    fun containsWordCaseInsensitive(text: String, word: String): Boolean
}

internal class StringCalculatorImpl : StringCalculator {
    override fun countOcurrencesOfCharacter(text: String, character: Char): Int =
        text.filter { it == character }.count()

    override fun removeCharacter(text: String, character: Char): String =
        text.filterNot { it == character }

    override fun replaceOcurrencesWithNewCharacter(text: String, characterToReplace: Char, newCharacter: Char): String =
        text.replace(characterToReplace, newCharacter)

    override fun concatenate(text1: String, text2: String): String =
        "$text1$text2"

    override fun lengthOfString(text: String): Int =
        text.length

    override fun length5StarRating(text: String): String {
        val length = text.length

        return when (length) {
            in 0..9 -> "⭐ very small ($length)"
            in 10..19 -> "⭐⭐ small ($length)"
            in 20..29 -> "⭐⭐⭐ medium ($length)"
            in 30..39 -> "⭐⭐⭐⭐ big ($length)"
            else -> "⭐⭐⭐⭐⭐ very big ($length)"
        }
    }

    override fun containsWordCaseInsensitive(text: String, word: String): Boolean =
        text.contains(word, ignoreCase = true)
}