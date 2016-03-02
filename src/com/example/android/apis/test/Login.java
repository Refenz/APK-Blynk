//A positive tests. Test suite for the user to log in the program Blynk.

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
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
		solo.tearDown();
		super.tearDown();
	}
/*	№0001 test. The fields e-mail and password is empty.
	1) Run the program's.
	2) Press the "Log In".
	3) Click "Log In".
	4) Wait for mistakes "You need to provide your email".*/
	public void test0001EmptyEmailFieldEmptyPasswordField() throws Exception {
		assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
				solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.waitForActivity("LoginActivity");
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			assertTrue(solo.searchText(Pattern.quote("You need to provide your email")));
	}
/*	№0002 test. E-mail Field empty. The password field is incorrect.
	1) Run the program.
	2) Press the "Log In" button.
	3) Enter in the "Password" incorrect password - "0000".
	4) Press the "Log In" button.
	5) Wait for mistakes "You need to provide your email".*/
	public void test0002EmptyEmailFieldWrongPassword() throws Exception {
		assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
				solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.waitForActivity("LoginActivity");
			assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_psw) failed.",
					solo.waitForEditTextById("cc.blynk.R.id.edit_psw", 5000));
			solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_psw"), "0000");
			assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
					solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			assertTrue(solo.searchText(Pattern.quote("You need to provide your email")));
	}
/*	№0003 test. E-mail Field empty. The password field is correct.
	1) Run the program.
	2) Press the "Log In" button.
	3) Enter in the "Password" field the correct password - "me901989".
	4) Press the "Log In" button.
	5) Wait for mistakes "You need to provide your email".*/
	public void test0003EmptyEmailFieldCorrectPassword() throws Exception {
		assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
				solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
		solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
		solo.waitForActivity("LoginActivity");
		assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_psw) failed.",
				solo.waitForEditTextById("cc.blynk.R.id.edit_psw", 5000));
		solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_psw"), "me901989");
		assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
				solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
		solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
		assertTrue(solo.searchText(Pattern.quote("You need to provide your email")));
	}
/*	№0004 test. In the field of e-mail is new address. The password field is empty.
	1) Run the program.
	2) Press the "Log In" button.
	3) Enter in the field "e-mail" valid username - "roma_@mail.ru".
	4) Press the "Log In" button.
	5) Expect mistakes "You need to provide your password".*/
	public void test0004NewEmailEmptyPasswordField() throws Exception {
		assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
				solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
		solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
		solo.waitForActivity("LoginActivity");
		assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_psw) failed.",
				solo.waitForEditTextById("cc.blynk.R.id.edit_psw", 5000));
		solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "roma_@mail.ru");
		assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
				solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
		solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
		assertTrue(solo.searchText(Pattern.quote("You need to provide your password")));
	}
/*	№0005 test. The field of e-mail is incorrect. The password field is empty.
	1) Run the program.
	2) Press the "Log In" button.
	3) Enter in the field "e-mail" valid username - "roma_kirichenko_@mail.ru".
	4) Press the "Log In" button.
	5) Expect mistakes "It's not a valid e-mail address".*/
	public void test0005WrongEmailEmptyPasswordField() throws Exception {
		assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
				solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
		solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
		solo.waitForActivity("LoginActivity");
		assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_login) failed.",
				solo.waitForEditTextById("cc.blynk.R.id.edit_login", 5000));
		solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "roma_kirichenko_");
		assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
				solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
		solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
		assertTrue(solo.searchText(Pattern.quote("It's not a valid e-mail address")));
	}
/*	№0006 Test. The field of e-mail is incorrect. The password field is incorrect.
	1) Run the program.
	2) Press the "Login" button.
	3) Enter in the field "e-mail" valid username - "roma_kirichenko_@mail.ru".
	4) Enter in the "Password" incorrect password - "0000".
	5) Click the "Login" button.
	6) Expect mistakes "It's not a valid e-mail address".*/
	public void test0006WrongEmailWrongPassword() throws Exception {
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
		solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
		assertTrue(solo.searchText(Pattern.quote("It's not a valid e-mail address")));
	}
/*	№0007 Test. The field of e-mail is incorrect. The password field is correct.
	1) Run the program.
	2) Press the "Login" button.
	3) Enter in the field "e-mail" valid username - "roma_kirichenko_@mail.ru".
	4) Enter in the "Password" correct password - "me901989".
	5) Click the "Login" button.
	6) Expect mistakes "It's not a valid e-mail address".*/
	public void test0007WrongEmailCorrectPassword() throws Exception {
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
		solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
		assertTrue(solo.searchText(Pattern.quote("It's not a valid e-mail address")));
	}
	
/*	№0008 test. The field of e-mail is correct. The password field is empty.
	1) Run the program.
	2) Press the "Login" button.
	3) Enter in the field "e-mail" valid username - "roma_kirichenko_@mail.ru".
	4) Click the "Login" button.
	5) Expect mistakes "You need to provide your password".*/
	
	public void test0008CorrectEmailEmptyPasswordField() throws Exception {
		assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
				solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
		solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
		solo.waitForActivity("LoginActivity");
		assertTrue("Wait for edit text (id: cc.blynk.R.id.edit_login) failed.",
				solo.waitForEditTextById("cc.blynk.R.id.edit_login", 5000));
		solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "roma_kirichenko_@mail.ru");
		assertTrue("Wait for button (id: cc.blynk.R.id.login_button) failed.",
				solo.waitForButtonById("cc.blynk.R.id.login_button", 5000));
		solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
		assertTrue(solo.searchText(Pattern.quote("You need to provide your password")));
		
	}
/*	№0009 test. The field of e-mail is correct. The password field is incorrect.
	1) Run the program.
	2) Press the "Login" button.
	3) Enter in the field "e-mail" valid username - "roma_kirichenko_@mail.ru".
	4) Enter in the "Password" incorrect password - "0000".
	5) Click the "Login" button.
	6) Expect mistakes "Authentication failed. Please check your login and pass.".*/
	public void test0009CorrectEmailWrongPassword() throws Exception {
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
		solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
		assertTrue(solo.searchText(Pattern.quote("Authentication failed. Please check your login and pass.")));
	
	}
/*	№0010 test. In the field of e-mail is new address. The password field is new.
	1) Run the program.
	2) Press the "Login" button.
	3) Enter in the field "e-mail" new username - "roma_@mail.ru".
	4) Enter in the "Password" incorrect password - "0000".
	5) Click the "Login" button.
	6) Expect mistakes "It`s not a valid e-mail address".*/
	public void test0010NewEmailNewPassword() throws Exception {
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
		solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
		assertTrue(solo.searchText(Pattern.quote("User is not registered")));

}
	
/*	№0011 test. The field of e-mail is correct. The password field is correct.
	1) Run the program.
	2) Press the "Login" button.
	3) Enter in the field "e-mail" valid username - "roma_kirichenko_@mail.ru".
	4) Enter in the "Password" incorrect password - "me901989".
	5) Click the "Login" button.
	6) Expect correct login and see the icon with the text "Create New Project".
	7) Press the logout button and see the icon with the text "Are you sure you want to log out?".
	8) Confirm the request for the logout by clicking "Logout".
	9) See the main menu*/
	public void test0011CorrectEmailCorrectPassword() throws Exception {
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
		solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button")); 
		solo.waitForActivity("DashboardListActivity");
		assertTrue(solo.searchText(Pattern.quote("Blynk")));
		assertTrue(solo.searchText(Pattern.quote("Create New Project")));
		assertTrue(solo.searchText(Pattern.quote("Scan QR Code")));
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
