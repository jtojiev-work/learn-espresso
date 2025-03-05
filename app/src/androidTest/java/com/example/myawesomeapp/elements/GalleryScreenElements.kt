package com.example.myawesomeapp.elements

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.hasSibling
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.myawesomeapp.R
import org.hamcrest.core.AllOf.allOf

class GalleryScreenElements {
    fun galleryItemList(): ViewInteraction = onView(withId(R.id.recycle_view))

    fun gallerySelectItem(itemNumber: String): ViewInteraction =
        onView(
            allOf(
                withId(R.id.item_title),
                withText("My title"),
                hasSibling(allOf(withId(R.id.item_number), withText(itemNumber))),
            ),
        )

    fun gallerySelectedItemNotification(itemNumber: String): ViewInteraction =
        onView(
            withText("Item #$itemNumber clicked successfully!"),
        )
}
