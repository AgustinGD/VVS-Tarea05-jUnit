
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StringCalculatorTest {
    private val stringCalculator = StringCalculatorImpl()

    @Test
    fun `given a string and a char it should return char ocurrences`(){
        val text = "hello world"
        val char = 'l'

        val expected = 3
        val result = stringCalculator.countOcurrencesOfCharacter(text, char)

        assertEquals(expected, result)
    }

    @Test
    fun `given an empty string and a char it should return zero ocurrences`(){
        val text = ""
        val char = 'l'

        val expected = 0
        val result = stringCalculator.countOcurrencesOfCharacter(text, char)

        assertEquals(expected, result)
    }

    @Test
    fun `given a string and a char it should return string without appearance of char`(){
        val text = "hello world"
        val char = 'l'

        val expected = "heo word"
        val result = stringCalculator.removeCharacter(text, char)

        assertEquals(expected, result)
    }

    @Test
    fun `given a string, new char and old char it should return string with the new chars`(){
        val text = "hello world"
        val oldChar = 'l'
        val newChar = '*'

        val expected = "he**o wor*d"
        val result = stringCalculator.replaceOcurrencesWithNewCharacter(text, oldChar, newChar)

        assertEquals(expected, result)
    }

    @Test
    fun `given two strings it should return the concatenation`(){
        val text1 = "hello"
        val text2 = " world"

        val expected = "hello world"
        val result = stringCalculator.concatenate(text1, text2)

        assertEquals(expected, result)
    }

    @Test
    fun `given a string it should return the length`(){
        val text = "hello world"

        val expected = 11
        val result = stringCalculator.lengthOfString(text)

        assertEquals(expected, result)
    }

    @Test
    fun `given an empty string it should return zero length`(){
        val text = ""

        val expected = 0
        val result = stringCalculator.lengthOfString(text)

        assertEquals(expected, result)
    }

    @Test
    fun `given an empty string (lower bound) it should return very small length rating`(){
        val text = ""

        val expected = "⭐ very small (0)"
        val result = stringCalculator.length5StarRating(text)

        assertEquals(expected, result)
    }

    @Test
    fun `given a very small string (upper bound) it should return very small length rating`(){
        val text = "hello wor"

        val expected = "⭐ very small (9)"
        val result = stringCalculator.length5StarRating(text)

        assertEquals(expected, result)
    }


    @Test
    fun `given a small string (lower bound) it should return small length rating`(){
        val text = "hello worl"

        val expected = "⭐⭐ small (10)"
        val result = stringCalculator.length5StarRating(text)

        assertEquals(expected, result)
    }

    @Test
    fun `given a small string (upper bound) it should return small length rating`(){
        val text = "hello world hello w"

        val expected = "⭐⭐ small (19)"
        val result = stringCalculator.length5StarRating(text)

        assertEquals(expected, result)
    }

    @Test
    fun `given a medium string (lower bound) it should return medium length rating`(){
        val text = "hello world hello wo"

        val expected = "⭐⭐⭐ medium (20)"
        val result = stringCalculator.length5StarRating(text)

        assertEquals(expected, result)
    }

    @Test
    fun `given a medium string (upper bound) it should return medium length rating`(){
        val text = "hello world hello world hello"

        val expected = "⭐⭐⭐ medium (29)"
        val result = stringCalculator.length5StarRating(text)

        assertEquals(expected, result)
    }

    @Test
    fun `given a big string (lower bound) it should return big length rating`(){
        val text = "hello world hello world hello "

        val expected = "⭐⭐⭐⭐ big (30)"
        val result = stringCalculator.length5StarRating(text)

        assertEquals(expected, result)
    }

    @Test
    fun `given a big string (upper bound) it should return big length rating`(){
        val text = "hello world hello world hello world hel"

        val expected = "⭐⭐⭐⭐ big (39)"
        val result = stringCalculator.length5StarRating(text)

        assertEquals(expected, result)
    }

    @Test
    fun `given a very big string (lower bound) it should return very big length rating`(){
        val text = "hello world hello world hello world hell"

        val expected = "⭐⭐⭐⭐⭐ very big (40)"
        val result = stringCalculator.length5StarRating(text)

        assertEquals(expected, result)
    }

    @Test
    fun `given a lower cased string and an existing upper cased substring it should return true`(){
        val text = "hello world"
        val word = "WORLD"

        val result = stringCalculator.containsWordCaseInsensitive(text, word)

        assertTrue(result)
    }

    @Test
    fun `given a lower cased string and an existing mixed case substring it should return true`(){
        val text = "hello world"
        val word = "WoRlD"

        val result = stringCalculator.containsWordCaseInsensitive(text, word)

        assertTrue(result)
    }

    @Test
    fun `given a string and a non existing substring it should return false`(){
        val text = "hello world"
        val word = "dog"

        val result = stringCalculator.containsWordCaseInsensitive(text, word)

        assertFalse(result)
    }

}