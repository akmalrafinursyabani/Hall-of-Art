package com.arafinsandbox.tiptimeforeveryone

import org.junit.Assert
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTest {
    @Test
    fun calculate_20_percent_tip_no_roundup(
    ) {
        val amount: Double = 10.00
        val tipPercent: Double = 20.00
        val roundUp: Boolean = false

        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount, tipPercent, roundUp)

        Assert.assertEquals(expectedTip, actualTip)
    }
}