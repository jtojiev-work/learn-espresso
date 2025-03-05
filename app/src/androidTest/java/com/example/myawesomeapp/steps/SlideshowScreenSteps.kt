package com.example.myawesomeapp.steps

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.myawesomeapp.elements.SlideshowScreenElements

class SlideshowScreenSteps {
    private var slideshowScreenElement = SlideshowScreenElements()

    fun slideshowScreenBodyTextIsDisplayed() {
        slideshowScreenElement.slideshowScreenBodyText().check(matches(isDisplayed()))
    }
}
