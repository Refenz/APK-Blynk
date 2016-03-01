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
/*	№1 test. The fields e-mail and password empty.
	1) Run the program's.
	2) Press the "Log In".
	3) Click "Log In".
	4) Wait for mistakes "You need to provide your email".*/
	public void test1EmptyEmailFieldEmptyPasswordField() throws Exception {
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			assertTrue(solo.searchText(Pattern.quote("You need to provide your email")));
	}
/*	№2 test. E-mail Field empty. The password field is incorrect.
	1) Run the program.
	2) Press the "Log In" button.
	3) Enter in the "Password" incorrect password - "0000".
	4) Press the "Log In" button.
	5) Wait for mistakes "You need to provide your email".*/
	public void test2EmptyEmailFieldWrongPassword() throws Exception {
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_psw"), "0000");
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			assertTrue(solo.searchText(Pattern.quote("You need to provide your email")));
	}
/*	№3 test. E-mail Field empty. The password field is correct.
	1) Run the program.
	2) Press the "Log In" button.
	3) Enter in the "Password" field the correct password - "me901989".
	4) Press the "Log In" button.
	5) Wait for mistakes "You need to provide your email".*/
	public void test3EmptyEmailFieldCorrectPassword() throws Exception {
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_psw"), "me901989");
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			assertTrue(solo.searchText(Pattern.quote("You need to provide your email")));
	}
/*	№4 test. The field of e-mail is incorrect. The password field empty.
	1) Run the program.
	2) Press the "Log In" button.
	3) Enter in the field "e-mail" valid username - "roma_kirichenko_@mail.ru".
	4) Press the "Log In" button.
	5) Expect mistakes "It's not a valid e-mail address".*/
	public void test4WrongEmailEmptyPasswordField() throws Exception {
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "roma_kirichenko_");
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			assertTrue(solo.searchText(Pattern.quote("It's not a valid e-mail address")));
	}
/*	№5 Test. The field of e-mail is incorrect. The password field is incorrect.
	1) Run the program.
	2) Press the "Login" button.
	3) Enter in the field "e-mail" valid username - "roma_kirichenko_@mail.ru".
	4) Enter in the "Password" incorrect password - "0000".
	5) Click the "Login" button.
	6) Expect mistakes "It's not a valid e-mail address".*/
	public void test5WrongEmailWrongPassword() throws Exception {
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "roma_kirichenko_");
			solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_psw"), "0000");
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			assertTrue(solo.searchText(Pattern.quote("It's not a valid e-mail address")));
	}
/*	№6 Test. The field of e-mail is incorrect. The password field is correct.
	1) Run the program.
	2) Press the "Login" button.
	3) Enter in the field "e-mail" valid username - "roma_kirichenko_@mail.ru".
	4) Enter in the "Password" correct password - "me901989".
	5) Click the "Login" button.
	6) Expect mistakes "It's not a valid e-mail address".*/
	public void test6WrongEmailCorrectPassword() throws Exception {
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "roma_kirichenko_");
			solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_psw"), "me901989");
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			assertTrue(solo.searchText(Pattern.quote("It's not a valid e-mail address")));
	}
	
/*	№7 test. The field of e-mail is correct. The password field empty.
	1) Run the program.
	2) Press the "Login" button.
	3) Enter in the field "e-mail" valid username - "roma_kirichenko_@mail.ru".
	4) Click the "Login" button.
	5) Expect mistakes "You need to provide your password".*/
	
	public void test7CorrectEmailEmptyPasswordField() throws Exception {
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "roma_kirichenko_@mail.ru");
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			assertTrue(solo.searchText(Pattern.quote("You need to provide your password")));
		
	}
/*	№8 test. The field of e-mail is correct. The password field is incorrect.
	1) Run the program.
	2) Press the "Login" button.
	3) Enter in the field "e-mail" valid username - "roma_kirichenko_@mail.ru".
	4) Enter in the "Password" incorrect password - "0000".
	5) Click the "Login" button.
	6) Expect mistakes "Authentication failed. Please check your login and pass.".*/
	public void test8CorrectEmailWrongPassword() throws Exception {
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "roma_kirichenko_@mail.ru");
			solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_psw"), "0000");
			solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
			assertTrue(solo.searchText(Pattern.quote("Authentication failed. Please check your login and pass.")));
	
	}
	
/*	№9 test. The field of e-mail is correct. The password field is correct.
	1) Run the program.
	2) Press the "Login" button.
	3) Enter in the field "e-mail" valid username - "roma_kirichenko_@mail.ru".
	4) Enter in the "Password" incorrect password - "me901989".
	5) Click the "Login" button.
	6) Expect correct login and see the icon with the text "Create New Project".
	7) Press the logout button and see the icon with the text "Are you sure you want to log out?".
	8) Confirm the request for the logout by clicking "Logout".
	9) See the main menu*/
	public void test9CorrectEmailCorrectPassword() throws Exception {
		solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
		solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_login"), "roma_kirichenko_@mail.ru");
		solo.enterText((EditText) solo.findViewById("cc.blynk.R.id.edit_psw"), "me901989");
		solo.clickOnButton((Button) solo.findViewById("cc.blynk.R.id.login_button"));
		assertTrue(solo.searchText(Pattern.quote("Create New Project")));
		solo.clickOnImageButton(0);
		assertTrue(solo.searchText(Pattern.quote("Are you sure you want to log out?")));
		solo.clickOnText((TextView) solo.findViewById("cc.blynk.R.id.buttonDefaultPositive"));
		assertTrue(solo.searchText(Pattern.quote("Why do I need an account?")));
}
}
