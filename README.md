# EspressoWrap
A wrapper library for Espresso to help write UI tests.

# Usage
Extend your UI Test class with EspressoWrap, then simply call these functions to get desired functionality
```java
  performClick(R.id.xyz);
  performClick(R.id.xyz, true);
  
  performClick(String);
  performClick(String, true);
```


##Gradle Dependencies
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
