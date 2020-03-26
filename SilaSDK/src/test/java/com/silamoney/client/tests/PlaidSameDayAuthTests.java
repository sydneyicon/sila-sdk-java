package com.silamoney.client.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import com.silamoney.client.api.ApiResponse;
import com.silamoney.client.api.SilaApi;
import com.silamoney.client.exceptions.BadRequestException;
import com.silamoney.client.exceptions.ForbiddenException;
import com.silamoney.client.exceptions.InvalidSignatureException;
import com.silamoney.client.exceptions.ServerSideException;
import com.silamoney.client.testsutils.DefaultConfigurations;

import org.junit.Test;

/**
 * PlaidSameDayAuthTests
 * 
 * @author wzelada
 */
public class PlaidSameDayAuthTests {

	SilaApi api = new SilaApi(DefaultConfigurations.host, DefaultConfigurations.appHandle,
			DefaultConfigurations.privateKey);

	String userHandle = "javasdk-893748932";
	String userPrivateKey = "f6b5751234d4586873714066c538b9ddaa51ee5e3188a58236be1671f0be0ed3";

	// @Test
	// public void Response200() throws Exception {
	// 	if (DefaultConfigurations.getUserHandle() == null) {
	// 		DefaultConfigurations.setUserHandle(userHandle);
	// 	}
	// 	if (DefaultConfigurations.getUserPrivateKey() == null) {
	// 		DefaultConfigurations.setUserPrivateKey(userPrivateKey);
	// 	}
	// 	ApiResponse response = api.plaidSameDayAuth(DefaultConfigurations.getUserHandle(), "default",
	// 			DefaultConfigurations.getUserPrivateKey());
	// 	//System.out.println(GsonUtils.objectToJsonStringFormato(response));
	// 	assertEquals(200, response.getStatusCode());
	// }

	@Test
	public void Response400() throws BadRequestException, InvalidSignatureException, ServerSideException, IOException,
			InterruptedException, ForbiddenException {
		if (DefaultConfigurations.getUserHandle() == null) {
			DefaultConfigurations.setUserHandle(userHandle);
		}
		if (DefaultConfigurations.getUserPrivateKey() == null) {
			DefaultConfigurations.setUserPrivateKey(userPrivateKey);
		}
		ApiResponse response = api.plaidSameDayAuth(DefaultConfigurations.getUserHandle(), "",
				DefaultConfigurations.getUserPrivateKey());

		assertEquals(400, response.getStatusCode());
	}

	@Test
	public void Response401() throws BadRequestException, InvalidSignatureException, ServerSideException, IOException,
			InterruptedException, ForbiddenException {
		if (DefaultConfigurations.getUserHandle() == null) {
			DefaultConfigurations.setUserHandle(userHandle);
		}
		if (DefaultConfigurations.getUserPrivateKey() == null) {
			DefaultConfigurations.setUserPrivateKey(userPrivateKey);
		}
		api = new SilaApi(DefaultConfigurations.host, DefaultConfigurations.appHandle,
				"3a1076bf45ab87712ad64ccb3b10217737f7faacbf2872e88fdd9a537d8fe266");
		ApiResponse response = api.plaidSameDayAuth(DefaultConfigurations.getUserHandle(), "default",
				DefaultConfigurations.getUserPrivateKey());

		assertEquals(401, response.getStatusCode());
	}
}