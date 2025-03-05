package com.example.myawesomeapp.elements

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.myawesomeapp.R
import org.hamcrest.core.AllOf.allOf

class SlideshowScreenElements {
    fun slideshowScreenBodyText(): ViewInteraction =
        onView(
            allOf(
                withId(R.id.text_slideshow),
                withText("This is slideshow Fragment"),
            ),
        )
}
