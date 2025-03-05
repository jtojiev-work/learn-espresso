package com.example.myawesomeapp.elements

import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.myawesomeapp.R
import org.hamcrest.core.AllOf.allOf

class HomeScreenElements {
    fun homeScreenBodyText(): ViewInteraction =
        onView(
            allOf(
                withId(R.id.text_home),
                withText("This is home Fragment"),
            ),
        )

    fun toolbarBurgerButton(): ViewInteraction =
        onView(
            allOf(
                isDescendantOfA(withId(R.id.toolbar)),
                isAssignableFrom(ImageButton::class.java),
                withContentDescription(
                    "Open navigation drawer",
                ),
            ),
        )

    fun toolbarTitle(title: String): ViewInteraction =
        onView(
            allOf(
                isDescendantOfA(withId(R.id.toolbar)),
                isAssignableFrom(TextView::class.java),
                withText(title),
            ),
        )

    fun moreActionButton(): ViewInteraction =
        onView(
            allOf(
                isDescendantOfA(withId(R.id.toolbar)),
                isAssignableFrom(ImageView::class.java),
                withContentDescription("More options"),
            ),
        )

    fun greenEmailButton(): ViewInteraction =
        onView(
            allOf(
                withId(R.id.fab),
                withContentDescription("Floating action button"),
            ),
        )

    fun homeScreenNotificationMessage(): ViewInteraction = onView(withText("Replace with your own action"))
}
