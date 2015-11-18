## GearVRf simple-sample for Android Studio

This is a copy of GearVR Framework's sample app *simple-sample* built by Android Studio.

NOTE: This project contains prebuilt binaries of VRLib 0.6 and GearVR Framework 2.0 instead of sources.

See more details for:

* [Oculus Mobile SDK (VRLib)](https://developer.oculus.com/)
* [GearVR Framework](http://wiki.gearvrf.org/)

## How to use this

1. git clone https://github.com/ejeinc/GearVRf_simplesample.git
2. Copy your osig file to `app/src/main/assets`
3. Launch Android Studio
4. File -> Open... -> Choose cloned directory.
5. Click OK
6. Run

## Migrating from Oculus Mobile SDK and GearVR Framework (for maintenance)

1. Build Oculus Mobild SDK with Eclipse (import VrApi and VrAppFramework project and build)
2. Build GearVR Framework with Eclipse (import GVRf/Framework project and build)
3. Copy generated files to this repository

| File in Eclipse project | Copy destination (relative from this repository) |
| ---                     | ---              |
| VrApi/pPrebuilt_Libs/VrApi.jar          | gearvrf/libs/VrApi.jar
| VrAppFramework/bin/vrappframework.jar   | gearvrf/libs/vrappframework.jar
| Framework/bin/framework.jar             | gearvrf/libs/framework.jar
| Framework/libs/armeabi-v7a/libassimp.so | gearvrf/src/main/jniLibs/armeabi-v7a/libassimp.so
| Framework/libs/armeabi-v7a/libgvrf.so   | gearvrf/src/main/jniLibs/armeabi-v7a/libgvrf.so
| Framework/libs/armeabi-v7a/libvrapi.so  | gearvrf/src/main/jniLibs/armeabi-v7a/libvrapi.so

and build again.

## Use with gradle

You can use GearVRf as dependency of your app.

Note: This is **not** official repository. It's for my experiments. It should not be used in production software.

In project top level `build.gradle`, add repository location URL.

```gradle
// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:1.1.0'

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        maven { url "http://ejeinc.github.io/GearVRf_simplesample/repository/" } // Add this line
        jcenter()
    }
}
```

and, add dependency in your `app/build.gradle`.

```gradle
...

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile 'org.gearvr:gvrf:2.1.0' // Add this line

    // and other libraries
}
```

Don't forget to declare required permissions and `<activity>` attributes in `AndroidManifest.xml`.

```xml
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
...
<application
    android:icon="@mipmap/ic_launcher"
    android:label="@string/app_name"
    android:theme="@android:style/Theme.Black.NoTitleBar.Fullscreen">

    <meta-data
        android:name="com.samsung.android.vr.application.mode"
        android:value="vr_only" />

    <activity
        android:name=".MainActivity_"
        android:configChanges="orientation|screenSize|keyboard|keyboardHidden"
        android:excludeFromRecents="true"
        android:label="@string/app_name"
        android:launchMode="singleTask"
        android:screenOrientation="landscape">
        
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />

            <!-- only in develop -->
            <category android:name="android.intent.category.LAUNCHER" />
            <!-- you should enable this line when publishing -->
            <!--<category android:name="android.intent.category.INFO" />-->
        </intent-filter>
    </activity>

</application>
```
