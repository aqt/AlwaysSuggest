AlwaysSuggest
=============

Make Gboard / Google Keyboard always show suggestions

Features
---------

* Always show suggestions (if the bar is enabled for this type of text field)
* Show suggestions bar in URI text fields, [other flavors](https://developer.android.com/reference/android/text/InputType.html) may be added in the future

Instructions
-----------

This is an xposed module, if you do not know what xposed is I suggest you first look elsewhere for instructions.

I have not yet add this module to the official repository, meaning if you want to install this module you'll have to download the apk from here or build it yourself from source.

If you wish to use this module with another keyboard you'll probably only need to change the `PACKAGE_NAME` string as I'm hooking the generic `InputMethodService` class, but you'll still have to build the project yourself.
