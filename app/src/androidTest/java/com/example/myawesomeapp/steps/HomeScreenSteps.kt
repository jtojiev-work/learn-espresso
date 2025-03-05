package com.example.myawesomeapp.steps

import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeRight
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.myawesomeapp.elements.HomeScreenElements

class HomeScreenSteps {
    private var homeScreenElement = HomeScreenElements()

    fun homeScreenBodyTextIsDisplayed() {
        homeScreenElement.homeScreenBodyText().check(matches(isDisplayed()))
    }

    fun homeScreenBurgerButtonIsDisplayed() {
        homeScreenElement.toolbarBurgerButton().check(matches(isDisplayed()))
    }

    fun homeScreenBurgerButtonClick() {
        homeScreenElement.toolbarBurgerButton().perform(click())
    }

    fun toolbarTitleIsDisplayed(title: String) {
        homeScreenElement.toolbarTitle(title).check(matches(isDisplayed()))
    }

    fun homeScreenMoreActionButtonIsDisplayed() {
        homeScreenElement.moreActionButton().check(matches(isDisplayed()))
    }

    fun homeScreenGreenEmailButtonIsDisplayed() {
        homeScreenElement.greenEmailButton().check(matches(isDisplayed()))
    }

    fun homeScreenGreenEmailButtonClick() {
        homeScreenElement.greenEmailButton().perform(click())
    }

    fun homeScreenNotificationMessageIsDisplayed() {
        homeScreenElement.homeScreenNotificationMessage().check(matches(isDisplayed()))
    }

    fun homeScreenNotificationMessageSwipe() {
        homeScreenElement.homeScreenNotificationMessage().perform(swipeRight())
    }

    fun homeScreenNotificationMessageIsNotDisplayed() {
        Thread.sleep(1000)
        homeScreenElement.homeScreenNotificationMessage().check(doesNotExist())
    }
}
