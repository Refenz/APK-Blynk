/*A positive tests. Test suite for the user to log in the program Blynk.
Abbreviation:
	PreC-Pre Conditions
	TC-Test Case
	PostC-Post Conditions*/

package com.example.android.apis.test;

import android.test.ActivityInstrumentationTestCase2;
import android.app.Activity;
import junit.framework.AssertionFailedError;
import com.bitbar.recorder.extensions.ExtSolo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
public class Login extends ActivityInstrumentationTestCase2<Activity> {

	private static final String LAUNCHER_ACTIVITY_CLASSNAME = "com.blynk.android.activity.ProxyActivity";
	private static Class<?> launchActivityClass;
	static {
		try {
			launchActivityClass = Class.forName(LAUNCHER_ACTIVITY_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	private ExtSolo solo;

	@SuppressWarnings("unchecked")
	public Login() {
		super((Class<Activity>) launchActivityClass);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		solo = new ExtSolo(getInstrumentation(), getActivity(), this.getClass().getCanonicalName(), getName());
// 		PreC (Logout if User has been Login)
		 	boolean string1 = true;
		 	boolean string2 = solo.searchText(Pattern.quote("Create New Project"));
		 	if(string1 == string2) {
		 		solo.clickOnImageButton(0);
		 		solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.buttonDefaultPositive"));
			}
		 }

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
		solo.tearDown();
		super.tearDown();
	}
	
//№0001 test. The fields e-mail and password is empty.
	public void test0001EmptyEmailFieldEmptyPasswordField() throws Exception {
//		PreC
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
				solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.waitForActivity("LoginActivity");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_login) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_login", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_psw) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_psw", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_psw"), "");
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
//		TC
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			assertTrue(solo.searchText(Pattern.quote("You need to provide your email")));
	}
	
//№0002 test. E-mail Field empty. The password field is incorrect.
	public void test0002EmptyEmailFieldWrongPassword() throws Exception {
//		PreC
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
				solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.waitForActivity("LoginActivity");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_login) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_login", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_psw) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_psw", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_psw"), "0000");
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
//		TC
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			assertTrue(solo.searchText(Pattern.quote("You need to provide your email")));
	}
	
//№0003 test. E-mail Field empty. The password field is correct.
	public void test0003EmptyEmailFieldCorrectPassword() throws Exception {
//		PreC
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
				solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.waitForActivity("LoginActivity");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_login) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_login", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_psw) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_psw", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_psw"), "me901989");
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
//		TC
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			assertTrue(solo.searchText(Pattern.quote("You need to provide your email")));
	}
	
//№0004 test. In the field of e-mail is new address. The password field is empty.
	public void test0004NewEmailEmptyPasswordField() throws Exception {
//		PreC
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
				solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.waitForActivity("LoginActivity");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_psw) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_psw", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "roma_@mail.ru");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_psw) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_psw", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_psw"), "");
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
//		TC
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			assertTrue(solo.searchText(Pattern.quote("You need to provide your password")));
	}
	
//№0005 test. The field of e-mail is incorrect. The password field is empty.
	public void test0005WrongEmailEmptyPasswordField() throws Exception {
//		PreC
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
				solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.waitForActivity("LoginActivity");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_login) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_login", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "roma_kirichenko_");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_psw) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_psw", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_psw"), "");
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
//		TC
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			assertTrue(solo.searchText(Pattern.quote("It's not a valid e-mail address")));
	}
	
//№0006 Test. The field of e-mail is incorrect. The password field is incorrect.
	public void test0006WrongEmailWrongPassword() throws Exception {
//		PreC
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
				solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.waitForActivity("LoginActivity");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_login) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_login", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "roma_kirichenko_");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_psw) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_psw", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_psw"), "0000");
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
//		TC
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			assertTrue(solo.searchText(Pattern.quote("It's not a valid e-mail address")));
	}
	
//№0007 Test. The field of e-mail is incorrect. The password field is correct.
	public void test0007WrongEmailCorrectPassword() throws Exception {
//		PreC
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
				solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.waitForActivity("LoginActivity");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_login) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_login", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "roma_kirichenko_");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_psw) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_psw", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_psw"), "me901989");
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
//		TC
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			assertTrue(solo.searchText(Pattern.quote("It's not a valid e-mail address")));
	}
	
//№0008 test. The field of e-mail is correct. The password field is empty.	
	public void test0008CorrectEmailEmptyPasswordField() throws Exception {
//		PreC
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
				solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.waitForActivity("LoginActivity");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_login) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_login", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "roma_kirichenko_@mail.ru");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_psw) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_psw", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_psw"), "");
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
//		TC
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			assertTrue(solo.searchText(Pattern.quote("You need to provide your password")));
			}
	
//№0009 test. The field of e-mail is correct. The password field is incorrect.
	public void test0009CorrectEmailWrongPassword() throws Exception {
//		PreC
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
				solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.waitForActivity("LoginActivity");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_login) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_login", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "roma_kirichenko_@mail.ru");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_psw) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_psw", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_psw"), "0000");
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
//		TC
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			assertTrue(solo.searchText(Pattern.quote("Authentication failed. Please check your login and pass.")));
		}
	
//№0010 test. In the field of e-mail is new address. The password field is new.
	public void test0010NewEmailNewPassword() throws Exception {
//		PreC
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
				solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.waitForActivity("LoginActivity");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_login) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_login", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "roma_@mail.ru");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_psw) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_psw", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_psw"), "0000");
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
//		TC
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			assertTrue(solo.searchText(Pattern.quote("User is not registered")));
}
	
//№0011 test. The field of e-mail is correct. The password field is correct.
	public void test0011CorrectEmailCorrectPassword() throws Exception {
//		PreC
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
				solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.waitForActivity("LoginActivity");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_login) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_login", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "roma_kirichenko_@mail.ru");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_psw) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_psw", 5000));
				solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_psw"), "me901989");
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
				solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
//		TC
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button")); 
			solo.waitForActivity("DashboardListActivity");
			assertTrue(solo.searchText(Pattern.quote("Blynk")));
			assertTrue(solo.searchText(Pattern.quote("Create New Project")));
			assertTrue(solo.searchText(Pattern.quote("Scan QR Code")));
//		PostC
			assertTrue("Wait for image button (index: 0) failed.", solo.waitForImageButton(0, 5000));
			solo.clickOnImageButton(0);
			assertTrue(solo.searchText(Pattern.quote("Are you sure you want to log out?")));
			assertTrue(solo.searchText(Pattern.quote("Cancel")));
			assertTrue(solo.searchText(Pattern.quote("Logout")));
			assertTrue("Wait for text (id: cc.blynk.R.id.buttonDefaultPositive) failed.",
					solo.waitForTextById("cc.blynk.R.id.buttonDefaultPositive", 5000));
				solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.buttonDefaultPositive"));
			solo.waitForActivity("StartActivity");
			assertTrue(solo.searchText(Pattern.quote("Create New Account")));
			assertTrue(solo.searchText(Pattern.quote("Log In")));
			assertTrue(solo.searchText(Pattern.quote("Why do I need an account?")));
}
}
