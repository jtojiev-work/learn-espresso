package com.example.myawesomeapp.elements

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.myawesomeapp.R
import org.hamcrest.core.AllOf.allOf

class NavMenuElements {
    fun userProfilePhoto(): ViewInteraction =
        onView(
            allOf(
                withId(R.id.imageView),
                withContentDescription("Navigation header"),
            ),
        )

    fun userProfileName(): ViewInteraction = onView(withText("Android Studio"))

    fun userProfileEmail(): ViewInteraction = onView(withText("android.studio@android.com"))

    fun homeScreenOption(): ViewInteraction =
        onView(
            allOf(
                isDescendantOfA(withId(R.id.nav_home)),
                withText("Home"),
            ),
        )

    fun galleryScreenOption(): ViewInteraction =
        onView(
            allOf(
                isDescendantOfA(withId(R.id.nav_gallery)),
                withText("Gallery"),
            ),
        )

    fun slideShowScreenOption(): ViewInteraction =
        onView(
            allOf(
                isDescendantOfA(withId(R.id.nav_slideshow)),
                withText("Slideshow"),
            ),
        )
}
