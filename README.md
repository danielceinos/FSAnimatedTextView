# FSAnimatedTextView

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/danielceinos/FSAnimatedTextView/blob/master/LICENSE.md)
[![Version](https://img.shields.io/badge/jitpack-1.0.4-green.svg)](https://jitpack.io/#danielceinos/FSAnimatedTextView/1.0.4)

<p align="center">
	<img src="https://github.com/danielceinos/FSAnimatedTextView/blob/develop/example1.gif" />
</p>

# Requirements

- minAndroidSdk: 16

# Installation
  
  Add to your gradle.build:
  ```
  allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  ```
  dependencies {
	        compile 'com.github.danielceinos:FSAnimatedTextView:1.0.4'
	}
  ```
# Use

```xml
  <com.fireshield.animatedtextview.FSAnimatedTV
      android:id="@+id/tv_number"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      app:textSize="50sp"
      app:textColor="@color/colorPrimary"
      />
```

```kotlin
	findViewById<FSAnimatedTV>(R.id.tv_number).setNum(1337)
```

```kotlin
	findViewById<FSAnimatedTV>(R.id.tv_number).setText("hey!")
```
