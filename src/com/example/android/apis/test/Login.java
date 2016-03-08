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


private static final String AssertTest_1_2_3 = "You need to provide your email";
private static final String AssertTest_4_8 = "You need to provide your password";
private static final String AssertTwst_5_6_7 = "It's not a valid e-mail address";
private static final String AssertTest_9 = "Authentication failed. Please check your login and pass.";
private static final String AssertTest_10 = "User is not registered";
private static final String AssertTest_11 = "Create New Project";

//	WrongEmail
	private static final String WE = "roma_kirichenko_";
//	NewEmail
	private static final String NE = "roma_@mail.ru";
//	CorrectEmail
	private static final String CE = "roma_kirichenko_@mail.ru";
//	WrongPassword
	private static final String WP = "0000";
//	CorrectPassword
	private static final String CP = "me901989";
	
	private static final String BUTTON_VERIFICATION_LOGOUT = "cc.blynk.R.id.buttonDefaultPositive";
	private static final String BUTTON_LOGIN = "cc.blynk.R.id.login_button";
	private static final String FIELD_INPUT_PASSWORD = "cc.blynk.R.id.edit_psw";
	private static final String FIELD_INPUT_LOGIN = "cc.blynk.R.id.edit_login";
	
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
// 		PreC (BUTTON_VERIFICATION_LOGOUT if User was Login)
		if(solo.searchText(Pattern.quote(AssertTest_11))) {
			solo.clickOnImageButton(0);
		 	solo.clickOnText((TextView) solo.findViewById(BUTTON_VERIFICATION_LOGOUT));
			}
		 }

	@Override
	public void tearDown() throws Exception {
//		PostC (BUTTON_VERIFICATION_LOGOUT if the User is Login)
	 	if(solo.searchText(Pattern.quote(AssertTest_11))) {
			solo.clickOnImageButton(0);
			solo.clickOnText((TextView) solo.findViewById(BUTTON_VERIFICATION_LOGOUT));
	 		}
		solo.finishOpenedActivities();
		solo.tearDown();
		super.tearDown();
		}
	
//№0001 test. The fields e-mail and password is empty.
	public void test0001EmptyEmailFieldEmptyPasswordField() throws Exception {
//		PreC
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
				solo.waitForActivity("LoginActivity");
			solo.waitForEditTextById(FIELD_INPUT_LOGIN, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_LOGIN), "");
			solo.waitForEditTextById(FIELD_INPUT_PASSWORD, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_PASSWORD), "");
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
//		TC
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
			assertTrue(solo.searchText(Pattern.quote(AssertTest_1_2_3)));
			}
	
//№0002 test. E-mail Field empty. The password field is incorrect.
	public void test0002EmptyEmailFieldWrongPassword() throws Exception {
//		PreC
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
				solo.waitForActivity("LoginActivity");
			solo.waitForEditTextById(FIELD_INPUT_LOGIN, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_LOGIN), "");
			solo.waitForEditTextById(FIELD_INPUT_PASSWORD, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_PASSWORD), WP);
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
//		TC
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
			assertTrue(solo.searchText(Pattern.quote(AssertTest_1_2_3)));
			}
	
//№0003 test. E-mail Field empty. The password field is correct.
	public void test0003EmptyEmailFieldCorrectPassword() throws Exception {
//		PreC
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
				solo.waitForActivity("LoginActivity");
			solo.waitForEditTextById(FIELD_INPUT_LOGIN, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_LOGIN), "");
			solo.waitForEditTextById(FIELD_INPUT_PASSWORD, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_PASSWORD), CP);
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
//		TC
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
			assertTrue(solo.searchText(Pattern.quote(AssertTest_1_2_3)));
			}
	
//№0004 test. In the field of e-mail is new address. The password field is empty.
	public void test0004NewEmailEmptyPasswordField() throws Exception {
//		PreC
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
				solo.waitForActivity("LoginActivity");
			solo.waitForEditTextById(FIELD_INPUT_PASSWORD, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_LOGIN), NE);
			solo.waitForEditTextById(FIELD_INPUT_PASSWORD, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_PASSWORD), "");
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
//		TC
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
			assertTrue(solo.searchText(Pattern.quote(AssertTest_4_8)));
			}
	
//№0005 test. The field of e-mail is incorrect. The password field is empty.
	public void test0005WrongEmailEmptyPasswordField() throws Exception {
//		PreC
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
				solo.waitForActivity("LoginActivity");
			solo.waitForEditTextById(FIELD_INPUT_LOGIN, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_LOGIN), WE);
			solo.waitForEditTextById(FIELD_INPUT_PASSWORD, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_PASSWORD), "");
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
//		TC
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
			assertTrue(solo.searchText(Pattern.quote(AssertTwst_5_6_7)));
			}
	
//№0006 Test. The field of e-mail is incorrect. The password field is incorrect.
	public void test0006WrongEmailWrongPassword() throws Exception {
//		PreC
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
				solo.waitForActivity("LoginActivity");
			solo.waitForEditTextById(FIELD_INPUT_LOGIN, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_LOGIN), WE);
			solo.waitForEditTextById(FIELD_INPUT_PASSWORD, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_PASSWORD), WP);
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
//		TC
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
			assertTrue(solo.searchText(Pattern.quote(AssertTwst_5_6_7)));
			}
	
//№0007 Test. The field of e-mail is incorrect. The password field is correct.
	public void test0007WrongEmailCorrectPassword() throws Exception {
//		PreC
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
				solo.waitForActivity("LoginActivity");
			solo.waitForEditTextById(FIELD_INPUT_LOGIN, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_LOGIN), WE);
			solo.waitForEditTextById(FIELD_INPUT_PASSWORD, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_PASSWORD), CP);
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
//		TC
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
			assertTrue(solo.searchText(Pattern.quote(AssertTwst_5_6_7)));
			}
	
//№0008 test. The field of e-mail is correct. The password field is empty.	
	public void test0008CorrectEmailEmptyPasswordField() throws Exception {
//		PreC
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
				solo.waitForActivity("LoginActivity");
			solo.waitForEditTextById(FIELD_INPUT_LOGIN, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_LOGIN), CE);
			solo.waitForEditTextById(FIELD_INPUT_PASSWORD, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_PASSWORD), "");
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
//		TC
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
			assertTrue(solo.searchText(Pattern.quote(AssertTest_4_8)));
			}
	
//№0009 test. The field of e-mail is correct. The password field is incorrect.
	public void test0009CorrectEmailWrongPassword() throws Exception {
//		PreC
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
				solo.waitForActivity("LoginActivity");
			solo.waitForEditTextById(FIELD_INPUT_LOGIN, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_LOGIN), CE);
			solo.waitForEditTextById(FIELD_INPUT_PASSWORD, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_PASSWORD), WP);
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
//		TC
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
			assertTrue(solo.searchText(Pattern.quote(AssertTest_9)));
			}
	
//№0010 test. In the field of e-mail is new address. The password field is new.
	public void test0010NewEmailNewPassword() throws Exception {
//		PreC
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
				solo.waitForActivity("LoginActivity");
			solo.waitForEditTextById(FIELD_INPUT_LOGIN, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_LOGIN), NE);
			solo.waitForEditTextById(FIELD_INPUT_PASSWORD, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_PASSWORD), WP);
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
//		TC
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
			assertTrue(solo.searchText(Pattern.quote(AssertTest_10)));
			}
	
//№0011 test. The field of e-mail is correct. The password field is correct.
	public void test0011CorrectEmailCorrectPassword() throws Exception {
//		PreC
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN));
				solo.waitForActivity("LoginActivity");
			solo.waitForEditTextById(FIELD_INPUT_LOGIN, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_LOGIN), CE);
			solo.waitForEditTextById(FIELD_INPUT_PASSWORD, 1000);
				solo.enterText((EditText) solo.findViewById(FIELD_INPUT_PASSWORD), CP);
			solo.waitForButtonById(BUTTON_LOGIN, 1000);
//		TC
			solo.clickOnButton((Button) solo.findViewById(BUTTON_LOGIN)); 
			assertTrue(solo.searchText(Pattern.quote(AssertTest_11)));
			}
}
