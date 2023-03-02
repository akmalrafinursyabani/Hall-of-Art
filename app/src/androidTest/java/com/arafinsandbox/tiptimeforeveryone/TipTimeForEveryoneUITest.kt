package com.arafinsandbox.tiptimeforeveryone

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.arafinsandbox.tiptimeforeveryone.ui.theme.TipTimeForEveryoneTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipTimeForEveryoneUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipTimeForEveryoneTheme {
                TipTimeApp()
            }
        }

        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

        // onNodeWithText sensitif dengan Case. Watch out!
        composeTestRule.onNodeWithText(text = "Bill Amount", ignoreCase = true)
            .performTextInput("10")
        composeTestRule.onNodeWithText(
            text = "Tip (%)",
            ignoreCase = true
        ).performTextInput("20")
        composeTestRule.onNodeWithText("Tip amount: $expectedTip")
            .assertExists("No node with this text was found.")
    }

}