package github.aqt.alwayssuggest;

import android.inputmethodservice.InputMethodService;
import android.text.InputType;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Main implements IXposedHookLoadPackage {
	final String PACKAGE_NAME = "com.google.android.inputmethod.latin";

	@Override
	public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
		if (!lpparam.packageName.equals(PACKAGE_NAME)) {
			return;
		}

		XposedHelpers.findAndHookMethod(
			InputMethodService.class, "doStartInput",
			InputConnection.class, EditorInfo.class, Boolean.TYPE,
			new XC_MethodHook() {
				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					EditorInfo editorInfo = (EditorInfo) param.args[1];

					// Clear bits for variations that disable the suggestions bar
					// This does of course mean that any other code dependent on these variations will not run
					editorInfo.inputType &= ~InputType.TYPE_TEXT_VARIATION_URI;
					editorInfo.inputType &= ~InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS;

					switch (editorInfo.inputType & InputType.TYPE_MASK_CLASS) {
						case InputType.TYPE_CLASS_TEXT:
							// Clear No suggestions bit (the whole point of this mod)
							editorInfo.inputType &= ~InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS;
							break;
					}
				}
			}
		);
	}
}
