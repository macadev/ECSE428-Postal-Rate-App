package com.example.danielmacario.amp_ecse_428;


import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class UITest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void check_empty_weight_input() {
        // No weight value was passed
        Espresso.onView(withId(R.id.length))
                .perform(replaceText("140.3"));
        Espresso.onView(withId(R.id.width))
                .perform(replaceText("140.3"));

        Espresso.onView(withId(R.id.submitButton)).perform(click());

        Espresso.onView(withId(R.id.output)).check(matches(withText("Invalid Input")));

    }

    @Test
    public void check_empty_length_input() {
        // No weight value was passed
        Espresso.onView(withId(R.id.weight))
                .perform(replaceText("50"));
        Espresso.onView(withId(R.id.width))
                .perform(replaceText("140.3"));

        Espresso.onView(withId(R.id.submitButton)).perform(click());

        Espresso.onView(withId(R.id.output)).check(matches(withText("Invalid Input")));

    }

    @Test
    public void check_empty_width_input() {
        // No weight value was passed
        Espresso.onView(withId(R.id.weight))
                .perform(replaceText("50"));
        Espresso.onView(withId(R.id.length))
                .perform(replaceText("140.3"));

        Espresso.onView(withId(R.id.submitButton)).perform(click());

        Espresso.onView(withId(R.id.output)).check(matches(withText("Invalid Input")));

    }

    @Test
    public void nonumeric_length_input() {
        // No weight value was passed
        Espresso.onView(withId(R.id.weight))
                .perform(replaceText("50"));
        Espresso.onView(withId(R.id.width))
                .perform(replaceText("50"));
        Espresso.onView(withId(R.id.length))
                .perform(replaceText("ABC"));

        Espresso.onView(withId(R.id.submitButton)).perform(click());

        Espresso.onView(withId(R.id.output)).check(matches(withText("Only numerical input is allowed")));

    }

    @Test
    public void nonumeric_width_input() {
        // No weight value was passed
        Espresso.onView(withId(R.id.weight))
                .perform(replaceText("50"));
        Espresso.onView(withId(R.id.width))
                .perform(replaceText("ZZZ"));
        Espresso.onView(withId(R.id.length))
                .perform(replaceText("134.3"));

        Espresso.onView(withId(R.id.submitButton)).perform(click());

        Espresso.onView(withId(R.id.output)).check(matches(withText("Only numerical input is allowed")));

    }

    @Test
    public void nonumeric_weight_input() {
        // No weight value was passed
        Espresso.onView(withId(R.id.weight))
                .perform(replaceText("SERGE!"));
        Espresso.onView(withId(R.id.width))
                .perform(replaceText("50"));
        Espresso.onView(withId(R.id.length))
                .perform(replaceText("100.5"));

        Espresso.onView(withId(R.id.submitButton)).perform(click());

        Espresso.onView(withId(R.id.output)).check(matches(withText("Only numerical input is allowed")));

    }

}

