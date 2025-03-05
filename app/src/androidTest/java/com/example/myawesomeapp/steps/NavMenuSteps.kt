package com.example.myawesomeapp.steps

import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.myawesomeapp.elements.NavMenuElements

class NavMenuSteps {
    private var navMenuElements = NavMenuElements()

    fun userProfilePhotoIsDisplayed() {
        navMenuElements.userProfilePhoto().check(matches(isDisplayed()))
    }

    fun userProfileNameIsDisplayed() {
        navMenuElements.userProfileName().check(matches(isDisplayed()))
    }

    fun userProfileEmailIsDisplayed() {
        navMenuElements.userProfileEmail().check(matches(isDisplayed()))
    }

    fun homeScreenOptionIsDisplayed() {
        navMenuElements.homeScreenOption().check(matches(isDisplayed()))
    }

    fun homeScreenOptionClick() {
        navMenuElements.homeScreenOption().check(matches(isDisplayed())).perform(click())
    }

    fun galleryScreenOptionIsDisplayed() {
        navMenuElements.galleryScreenOption().check(matches(isDisplayed()))
    }

    fun galleryScreenOptionClick() {
        navMenuElements.galleryScreenOption().check(matches(isDisplayed())).perform(click())
    }

    fun galleryScreenOptionIsChecked() {
        navMenuElements.galleryScreenOption().check(matches(isChecked()))
    }

    fun slideShowScreenOptionIsDisplayed() {
        navMenuElements.slideShowScreenOption().check(matches(isDisplayed()))
    }

    fun slideShowScreenOptionClick() {
        navMenuElements.slideShowScreenOption().check(matches(isDisplayed())).perform(click())
    }
}
