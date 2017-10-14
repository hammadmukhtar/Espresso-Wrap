package com.innovoid.espressowrap;

import android.support.annotation.CheckResult;
import android.support.test.espresso.AmbiguousViewMatcherException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ScrollToAction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.anyOf;

public class EspressoWrap{

    private static final int RETRY_COUNT = 5;
    private static final int RETRY_COUNT_OPTIONAL = 2;
    private static final int RETRY_TIME = 2000;

    /**
     * Performs click operation on given view id
     * @param id view id
     * @return true if the action was performed successfully, false otherwise
     */
    public boolean performClick(int id){
        return performClick(id, false);
    }

    /**
     * Performs click operation on given view id
     * @param id view id
     * @param optional true if event is optional, false if mandatory
     * @return true if the action was performed successfully, false otherwise
     */
    public boolean performClick(int id, boolean optional){
        int retry_count = optional ? RETRY_COUNT_OPTIONAL : RETRY_COUNT;
        boolean performed = false;
        ViewInteraction view = null;
        for(int i = 0 ; i < retry_count ; i++){
            view = onView(allOf(withId(id), isDisplayed()));
            if(exists(view)) {
                view.perform(click());
                performed = true;
                break;
            }
            else {
                waitFor(RETRY_TIME);
            }
        }
        if(view != null && !performed && !optional)
            view.perform(click());
        return performed;
    }

    /**
     * Performs click operation in scrolling view on given view id
     * @param id view id
     * @return true if the action was performed successfully, false otherwise
     */
    public boolean performClickAfterScroll(int id){
        return performClickAfterScroll(id, false);
    }

    /**
     * Performs click operation in scrolling view on given view id
     * @param id view id
     * @param optional true if event is optional, false if mandatory
     * @return true if the action was performed successfully, false otherwise
     */
    public boolean performClickAfterScroll(int id, boolean optional){
        int retry_count = optional ? RETRY_COUNT_OPTIONAL : RETRY_COUNT;
        boolean performed = false;
        ViewInteraction view = null;
        for(int i = 0 ; i < retry_count ; i++){
            view = onView(allOf(withId(id)));
            if(exists(view)) {
                view.perform(customScrollTo(), click());
                performed = true;
                break;
            }
            else {
                waitFor(RETRY_TIME);
            }
        }
        if(view != null && !performed && !optional)
            view.perform(customScrollTo(), click());
        return performed;
    }

    /**
     * Performs click operation on given view
     * @param view {@link ViewInteraction} on which click operation will be performed
     * @return true if the action was performed successfully, false otherwise
     */
    public boolean performClick(ViewInteraction view){
        return performClick(view, false);
    }

    /**
     * Performs click operation on given view
     * @param view {@link ViewInteraction} on which click operation will be performed
     * @param optional true if event is optional, false if mandatory
     * @return true if the action was performed successfully, false otherwise
     */
    public boolean performClick(ViewInteraction view, boolean optional){
        int retry_count = optional ? RETRY_COUNT_OPTIONAL : RETRY_COUNT;
        boolean performed = false;
        for(int i = 0 ; i < retry_count ; i++){
            if(exists(view)) {
                view.perform(click());
                performed = true;
                break;
            }
            else {
                waitFor(RETRY_TIME);
            }
        }
        if(view != null && !performed && !optional)
            view.perform(click());
        return performed;
    }

    /**
     * Performs click operation on a view having given text
     * @param text view with text on which click will be performed
     * @return true if the action was performed successfully, false otherwise
     */
    public boolean performClick(String text){
        return performClick(text, false);
    }

    /**
     * Performs click operation on a view having given text
     * @param text view with text on which click will be performed
     * @param optional true if event is optional, false if mandatory
     * @return true if the action was performed successfully, false otherwise
     */
    public boolean performClick(String text, boolean optional){
        int retry_count = optional ? RETRY_COUNT_OPTIONAL : RETRY_COUNT;
        boolean performed = false;
        ViewInteraction view = null;
        for(int i = 0 ; i < retry_count ; i++){
            view = onView(allOf(withText(text), isDisplayed()));
            if(exists(view)) {
                view.perform(click());
                performed = true;
                break;
            }
            else {
                waitFor(RETRY_TIME);
            }
        }
        if(view != null && !performed && !optional)
            view.perform(click());
        return performed;
    }

    /**
     * Performs click operation on a view in scrolling view having given text
     * @param text view with text on which click will be performed
     * @return true if the action was performed successfully, false otherwise
     */
    public boolean performClickAfterScroll(String text){
        return performClickAfterScroll(text, false);
    }

    /**
     * Performs click operation on a view in scrolling view having given text
     * @param text view with text on which click will be performed
     * @param optional true if event is optional, false if mandatory
     * @return true if the action was performed successfully, false otherwise
     */
    public boolean performClickAfterScroll(String text, boolean optional){
        int retry_count = optional ? RETRY_COUNT_OPTIONAL : RETRY_COUNT;
        boolean performed = false;
        ViewInteraction view = null;
        for(int i = 0 ; i < retry_count ; i++){
            view = onView(allOf(withText(text)));
            if(exists(view)) {
                view.perform(customScrollTo(), click());
                performed = true;
                break;
            }
            else {
                waitFor(RETRY_TIME);
            }
        }
        if(view != null && !performed && !optional)
            view.perform(customScrollTo(), click());
        return performed;
    }

    /**
     * Performs click operation on a view having given specific view id and text
     * @param id view id
     * @param text text of view against given id
     * @return true if the action was performed successfully, false otherwise
     */
    public boolean performClick(int id, String text){
        return performClick(id, text, false);
    }

    /**
     * Performs click operation on a view having given specific view id and text
     * @param id view id
     * @param text text of view against given id
     * @param optional true if event is optional, false if mandatory
     * @return true if the action was performed successfully, false otherwise
     */
    public boolean performClick(int id, String text, boolean optional){
        int retry_count = optional ? RETRY_COUNT_OPTIONAL : RETRY_COUNT;
        boolean performed = false;
        ViewInteraction view = null;
        for(int i = 0 ; i < retry_count ; i++){
            view = onView(allOf(withId(id), withText(text), isDisplayed()));
            if(exists(view)) {
                view.perform(click());
                performed = true;
                break;
            }
            else {
                waitFor(RETRY_TIME);
            }
        }
        if(view != null && !performed && !optional)
            view.perform(click());
        return performed;
    }

    /**
     * Performs click operation on a reclyclerview having given specific view id and item index
     * @param id view id
     * @param index item no in the recyclerview
     * @return true if the action was performed successfully, false otherwise
     */
    public boolean performClickOnRecyclerViewItem(int id, int index){
        return performClickOnRecyclerViewItem(id, index, false);
    }

    /**
     * Performs click operation on a reclyclerview having given specific view id and item index
     * @param id view id
     * @param index item no in the recyclerview
     * @param optional true if event is optional, false if mandatory
     * @return true if the action was performed successfully, false otherwise
     */
    public boolean performClickOnRecyclerViewItem(int id, int index, boolean optional){
        int retry_count = optional ? RETRY_COUNT_OPTIONAL : RETRY_COUNT;
        boolean performed = false;
        ViewInteraction view = null;
        for(int i = 0 ; i < retry_count ; i++){
            view = onView(allOf(withId(id)));
            if(exists(view)) {
                try {
                    view.perform(customScrollTo(), actionOnItemAtPosition(index, click()));
                }catch (Exception e){
                    
                    view.perform(actionOnItemAtPosition(index, click()));
                }
                performed = true;
                break;
            }
            else {
                waitFor(RETRY_TIME);
            }
        }
        if(view != null && !performed && !optional)
            view.perform(customScrollTo(), actionOnItemAtPosition(index, click()));
        return performed;
    }

    /**
     * Performs click operation on a reclyclerview having given specific view id and item index
     * @param id view id
     * @param text text to type in the view
     * @return true if the action was performed successfully, false otherwise
     */
    public boolean performTyping(int id, String text){
        return performTyping(id, text, false);
    }

    /**
     * Performs click operation on a reclyclerview having given specific view id and item index
     * @param id view id
     * @param text text to type in the view
     * @param optional true if event is optional, false if mandatory
     * @return true if the action was performed successfully, false otherwise
     */
    public boolean performTyping(int id, String text, boolean optional){
        int retry_count = optional ? RETRY_COUNT_OPTIONAL : RETRY_COUNT;
        boolean performed = false;
        ViewInteraction view = null;
        for(int i = 0 ; i < retry_count ; i++){
            view = onView(allOf(withId(id), isDisplayed()));
            if(exists(view)) {
                view.perform(typeText(text));
                performed = true;
                break;
            }
            else {
                waitFor(RETRY_TIME);
            }
        }
        if(view != null && !performed && !optional)
            view.perform(typeText(text));
        return performed;
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    public static long getRandomNumber(){
        return (long) (Math.abs(Math.random() * 100 % 1000));
    }


    public static long getRandomNumber(long max){
        return (long) (Math.abs(Math.random() * 100 % max));
    }

    public static long getRandomNumber(long min, long max){
        return (long) (Math.abs(Math.random() * 100 % max)) + min;
    }

    /**
     * Returns if the view exists
     * @param interaction view
     * @return
     */
    @CheckResult
    public static boolean exists(ViewInteraction interaction) {
        try {
            interaction.perform(new ViewAction() {
                @Override public Matcher<View> getConstraints() {
                    return any(View.class);
                }
                @Override public String getDescription() {
                    return "Check for view's existence";
                }
                @Override public void perform(UiController uiController, View view) {/* Do nothing */}
            });
            return true;
        } catch (AmbiguousViewMatcherException ex) {
            return true; // Found more than 1 views
        } catch (Exception ex) {
            return false;
        }
    }

    public static ViewAction setTextInTextView(final String value){
        return new ViewAction() {
            @SuppressWarnings("unchecked")
            @Override
            public Matcher<View> getConstraints() {
                return allOf(isDisplayed(), isAssignableFrom(TextView.class));
            }

            @Override
            public void perform(UiController uiController, View view) {
                ((TextView) view).setText(value);
            }

            @Override
            public String getDescription() {
                return "Change text in TextView";
            }
        };
    }

    /**
     * Perform action of waiting for a specific time.
     */
    private static ViewAction waitImplementation(final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "Wait for " + millis + " milliseconds.";
            }

            @Override
            public void perform(UiController uiController, final View view) {
                uiController.loopMainThreadForAtLeast(millis);
            }
        };
    }

    /**
     * Waits for specific time
     * @param millis time in millis
     */
    public static void waitFor(final long millis){
        onView(isRoot()).perform(waitImplementation(millis));
    }

    public ViewAction customScrollTo() {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return allOf(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE), isDescendantOfA(anyOf(
                        isAssignableFrom(ScrollView.class), isAssignableFrom(HorizontalScrollView.class),
                        isAssignableFrom(RecyclerView.class), isAssignableFrom(NestedScrollView.class)))
                );
            }

            @Override
            public String getDescription() {
                return null;
            }

            @Override
            public void perform(UiController uiController, View view) {
                new ScrollToAction().perform(uiController, view);
            }
        };
    }
}
