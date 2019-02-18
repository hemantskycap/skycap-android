# Core Module

## How to add:

### Project's `build.gradle`
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://dl.bintray.com/skycap/skycap-android' }
    }
}
```

### Module's `build.gradle`
```gradle
implementation 'skycap.android:core:1.0.0-alpha11’
```

### Other Useful Refererences:
Bintray : https://bintray.com/beta/#/skycap/skycap-android?tab=packages