# EspressoWrap
A wrapper library for Espresso to help write UI tests with helper functions which take care of the boilerplate code.

## Usage
Extend your UI Test class with EspressoWrap, then simply call these functions to perform desired functionality.

```java
  
  /* To perform click on a view with specific id */
    performClick(R.id.view);

    /* To perform click on a view with specific id
       with option to ignore action if view isn't available */
    performClick(R.id.view, true);

    /* To perform click on a view containing specific text */
    performClick("text");

    /* To perform click on a view containing specific text
       with option to ignore action if view isn't available */
    performClick("text", true);

    /* To perform click on a view with specific id & containing specific text */
    performClick(R.id.view, "text");
    
    /* To perform click on a view with specific id & containing specific text 
       with option to ignore action if view isn't available */
    performClick(R.id.view, "text", true);

    /* To perform click after scrolling to the view with specific id */
    performClickAfterScroll(R.id.view);

    /* To perform click after scrolling to the view with specific id 
       with option to ignore action with view isn't available */
    performClickAfterScroll(R.id.view, true);
    
    /* To perform click after scrolling to the view with specific text */
    performClickAfterScroll("text");

    /* To perform click after scrolling to the view with specific text 
       with option to ignore action with view isn't available */
    performClickAfterScroll("text", true);

    /* To perform click on a specific index of a recyclerview */
    performClickOnRecyclerViewItem(R.id.recyclerView, index);
    
    /* To perform click on a specific index of a recyclerview 
       with option to ignore action if recyclerview isn't available */
    performClickOnRecyclerViewItem(R.id.recyclerView, index, true);
    
    /* Type in an EditText with specific id */
    performTyping(R.id.editText, "dummy text");
    
    /* Type in an EditText with specific id with option to ignore action if editText isn't available */
    performTyping(R.id.editText, "dummy text", true);
    
    /* Replace text of a textview */
    setTextInTextView("replaced text");
    
    /* To wait for specific milliseconds before next performing next action */
    waitFor(2000);
    
```


## Gradle Dependencies
Add esspresso dependencies as per your need

```groovy
  /* For recyclerview & nested scrolling */
    compile "com.android.support:recyclerview-v7:$supportLibVer"
    
  /* Espresso and JUnit */
    testCompile 'junit:junit:4.12'
    androidTestCompile'com.android.support.test.espresso:espresso-core:3.0.1'
    androidTestCompile "com.android.support:support-annotations:$supportLibVer"
    androidTestCompile 'com.android.support.test.espresso:espresso-intents:3.0.1'
    compile 'com.android.support.test.espresso:espresso-idling-resource:3.0.1'
    androidTestCompile 'com.android.support.test.espresso:espresso-contrib:3.0.1', {
        exclude group: 'com.android.support', module: 'support-annotations'
        exclude group: 'com.android.support', module: 'support-v4'
        exclude group: 'com.android.support', module: 'design'
        exclude group: 'com.android.support', module: 'recyclerview-v7'
    }
```
