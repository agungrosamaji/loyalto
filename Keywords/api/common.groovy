package api

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class common {
	/**
	 * Check Response Code
	 *
	 * @param username for auth login
	 * @param password for auth login
	 */
	@Keyword
	def static void checkResponseCode(response, int responseCode) {
		WS.verifyResponseStatusCode(response, responseCode)
		println(WS.getResponseStatusCode(response))
	}

	/**
	 * Login get token
	 *
	 * @param username for auth login
	 * @param password for auth login
	 * @return token for bearer token
	 */
	@Keyword
	def static String loginGetToken(String username, String password) {
		def response = WS.sendRequest(findTestObject('API/Login', [('username') : username, ('password') : password]))
		String token = WS.getElementPropertyValue(response, 'token')
		println(token)
		return token
	}

	/**
	 * Verify parameter value
	 *
	 * @param username for auth login
	 * @param password for auth login
	 * @param response parameter name
	 * @param response parameter value
	 */
	@Keyword
	def static void loginCheckParam(String username, String password, String name, String value) {
		def response = WS.sendRequest(findTestObject('API/Login', [('username') : username, ('password') : password]))
		WS.verifyElementPropertyValue(response, name, value)
	}
}
