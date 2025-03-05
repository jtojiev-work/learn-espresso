package com.example.myawesomeapp.steps

import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.myawesomeapp.elements.GalleryScreenElements

class GalleryScreenSteps {
    private var galleryScreenElement = GalleryScreenElements()

    fun galleryItemListIsDisplayed() {
        Thread.sleep(1000)
        galleryScreenElement.galleryItemList().check(matches(isDisplayed()))
    }

    fun galleryItemClick(itemNumber: String) {
        galleryScreenElement.gallerySelectItem(itemNumber).perform(click())
    }

    fun gallerySelectedItemNotificationIsDisplayed(itemNumber: String) {
        galleryScreenElement.gallerySelectedItemNotification(itemNumber)
    }

    fun galleryItemListSwipeUp() {
        Thread.sleep(1000)
        galleryScreenElement.galleryItemList().perform(swipeUp())
    }
}
