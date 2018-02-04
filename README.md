# FSAnimatedTextView

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/danielceinos/FSAnimatedTextView/blob/master/LICENSE.md)
[![Version](https://img.shields.io/badge/jitpack-1.0.5-green.svg)](https://jitpack.io/#danielceinos/FSAnimatedTextView/1.0.5)

<p align="center">
	<img src="https://github.com/danielceinos/FSAnimatedTextView/blob/develop/example2.gif" />
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
	        compile 'com.github.danielceinos:FSAnimatedTextView:1.0.5'
	}
  ```
# Use

## Options

    <attr name="textSize" format="dimension"/>
    <attr name="textColor" format="color"/>
    <attr name="duration" format="integer"/>
    <attr name="leftDrawable" format="reference"/>
    <attr name="leftDrawableHeight" format="dimension"/>
    <attr name="leftDrawableWidth" format="dimension"/>
    <attr name="leftDrawableSize" format="dimension"/>
    <attr name="leftDrawableTint" format="color"/>
    <attr name="colorFeedback" format="boolean"/>

## Example

```xml
 <com.fireshield.animatedtextview.FSAnimatedTV
          android:id="@+id/tv_retweet"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:layout_marginLeft="6dp"
          android:layout_weight="1"
          app:colorFeedback="true"
          app:duration="200"
          app:leftDrawable="@drawable/ic_cached"
          app:leftDrawableSize="20dp"
          app:leftDrawableTint="#FFF"
          app:textColor="#FFF"
          app:textSize="16sp"
          />
```

```kotlin
	findViewById<FSAnimatedTV>(R.id.tv_number).setNum(1337)
```

```kotlin
	findViewById<FSAnimatedTV>(R.id.tv_number).setText("hey!")
```

```kotlin
	 findViewById<FSAnimatedTV>(R.id.tv_like).increment(1)
```
     
```kotlin
	 findViewById<FSAnimatedTV>(R.id.tv_like).decrement(6)
```