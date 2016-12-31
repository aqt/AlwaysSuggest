AlwaysSuggest
=============

Make Gboard / Google Keyboard always show suggestions.

Features
---------

* Always show suggestions (if the bar is enabled for this type of text field, it's for example disabled for passwords).
* Show suggestions bar in more text fields (URI and email), [other flavors](https://developer.android.com/reference/android/text/InputType.html) may be added in the future.

Instructions
-----------

This is an xposed module, if you do not know what xposed is you'll need to look elsewhere for instructions before continuing.

I have not added this module to the official repository yet, which means that if you want to install this module you can either download the apk [from the releases](https://github.com/aqt/AlwaysSuggest/releases/latest) or build it yourself from source.

If you wish to use this module with another keyboard you'll probably only need to change the `PACKAGE_NAME` string as I'm hooking the generic `InputMethodService` class.
