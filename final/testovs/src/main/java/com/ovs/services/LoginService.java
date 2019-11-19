package com.ovs.services;

import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.*;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ovs.dao.DataRepository;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import com.twilio.sdk.TwilioRestException;

import java.lang.reflect.UndeclaredThrowableException;
import java.security.GeneralSecurityException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.math.BigInteger;
import java.util.TimeZone;

@Service
public class LoginService {

	// Find your Account Sid and Token at twilio.com/user/account
	public static final String ACCOUNT_SID = "AC63269fb4d3f4398042c59436b27415b9";
	public static final String AUTH_TOKEN = "07adc06dee3eb0726ec8a3dc0ade1124";

	@Autowired
	@Qualifier("dataRepository")
	private DataRepository dataRepository;

	public String genOTP(String userId) throws TwilioRestException, SQLException {
		String seed32 = "3132333435363738393031323334353637383930"
				+ "313233343536373839303132";
		long T0 = 0;
		long X = 30;
		String otp = null;
		long testTime = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);

		String steps = "0";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.setTimeZone(TimeZone.getTimeZone("UTC"));

		try {
			long T = (testTime - T0) / X;
			steps = Long.toHexString(T).toUpperCase();
			while (steps.length() < 16)
				steps = "0" + steps;
			otp = generateTOTP(seed32, steps, "6", "HmacSHA256");
		} catch (final Exception e) {
			System.out.println("Error : " + e);
		}
		System.out.println("genetrated OTP is " + otp);
		boolean otpInserted = dataRepository.insertOTP(userId, otp);
		if(otpInserted)
			System.out.println("otp entered successfully");
		else
			System.out.println("otp entry failed");
		
		long mobNum = dataRepository.getMobileNum(userId);

		System.out.println("in loginservice test mobNum: " + Long.toString(mobNum));
		sendMsg(otp, Long.toString(mobNum));
		return otp;
	}
	
	public boolean validation(String userId, String otp)
			throws SQLException {
		System.out.println("in validation (LoginService)");
		boolean validate = dataRepository.OtpValidation(userId, otp);
		if(validate)
			System.out.println("voter validated");
		else
			System.out.println("validation failed");
		return validate;
	}
	
	public void sendMsg(String otp, String mobNum) throws TwilioRestException {
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

//		System.out.println("in sendMsg");
		List<NameValuePair> params = new ArrayList<NameValuePair>();
//		params.add(new BasicNameValuePair("To", "+919730930031"));
		System.out.println("mobNum "+mobNum);
		String mobNo = "+91"+mobNum;
		System.out.println("mobNo "+mobNo);
		params.add(new BasicNameValuePair("To", mobNo));
		params.add(new BasicNameValuePair("From", "+15084525455"));
		params.add(new BasicNameValuePair("Body",
				"Welcome to CyberVote. Use the given One Time Password and Cast Your Vote "
						+ otp));
		// params.add(new BasicNameValuePair("Body",
		// "TEST NO:10 use the given one time password"+generatePassword()+" and cast your vote "));
		MessageFactory messageFactory = (MessageFactory) client.getAccount()
				.getMessageFactory();
		Message message = messageFactory.create(params);
//		System.out.println(message.getSid());
	}
	
	public byte[] hmac_sha(String crypto, byte[] keyBytes, byte[] text) {
		try {
			Mac hmac;
			hmac = Mac.getInstance(crypto);
			SecretKeySpec macKey = new SecretKeySpec(keyBytes, "RAW");
			hmac.init(macKey);
			return hmac.doFinal(text);
		} catch (GeneralSecurityException gse) {
			throw new UndeclaredThrowableException(gse);
		}
	}

	/**
	 * This method converts a HEX string to Byte[]
	 *
	 * @param hex
	 *            : the HEX string
	 *
	 * @return: a byte array
	 */

	public byte[] hexStr2Bytes(String hex) {
		// Adding one byte to get the right conversion
		// Values starting with "0" can be converted
		byte[] bArray = new BigInteger("10" + hex, 16).toByteArray();

		// Copy all the REAL bytes, not the "first"
		byte[] ret = new byte[bArray.length - 1];
		for (int i = 0; i < ret.length; i++)
			ret[i] = bArray[i + 1];
		return ret;
	}

	public final int[] DIGITS_POWER
	// 0 1 2 3 4 5 6 7 8
	= { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000 };

	/**
	 * This method generates a TOTP value for the given set of parameters.
	 *
	 * @param key
	 *            : the shared secret, HEX encoded
	 * @param time
	 *            : a value that reflects a time
	 * @param returnDigits
	 *            : number of digits to return
	 * @param crypto
	 *            : the crypto function to use
	 *
	 * @return: a numeric String in base 10 that includes
	 *          {@link truncationDigits} digits
	 */

	public String generateTOTP(String key, String time, String returnDigits,
			String crypto) {
		int codeDigits = Integer.decode(returnDigits).intValue();
		String result = null;

		// Using the counter
		// First 8 bytes are for the movingFactor
		// Compliant with base RFC 4226 (HOTP)
		while (time.length() < 16)
			time = "0" + time;

		// Get the HEX in a Byte[]
		byte[] msg = hexStr2Bytes(time);
		byte[] k = hexStr2Bytes(key);

		byte[] hash = hmac_sha(crypto, k, msg);

		// put selected bytes into result int
		int offset = hash[hash.length - 1] & 0xf;

		int binary = ((hash[offset] & 0x7f) << 24)
				| ((hash[offset + 1] & 0xff) << 16)
				| ((hash[offset + 2] & 0xff) << 8) | (hash[offset + 3] & 0xff);

		int otp = binary % DIGITS_POWER[codeDigits];

		result = Integer.toString(otp);
		while (result.length() < codeDigits) {
			result = "0" + result;
		}
		return result;
	}
}
