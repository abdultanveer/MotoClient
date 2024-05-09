package com.example.motoclient

import androidx.test.espresso.Espresso
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher



@LargeTest
@RunWith(AndroidJUnit4::class)
class SecActivityTest {
    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(SecondActivity::class.java)

    @Test
    fun loginTest() {
        //select the edittext and enter moto android
        onView(withId(R.id.etContact))
            .perform(typeText("moto android abdul"), closeSoftKeyboard());
        //click the button
        onView(withId(R.id.btnContact)).perform(click());
        //assert if the tv has the text present in et
        onView(withId(R.id.tvCon))
            .check(matches(withText("moto android abdul")));

    }
}