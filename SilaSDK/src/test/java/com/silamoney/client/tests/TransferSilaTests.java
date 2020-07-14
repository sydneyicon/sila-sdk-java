package com.silamoney.client.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.UUID;

import com.silamoney.client.api.ApiResponse;
import com.silamoney.client.api.SilaApi;
import com.silamoney.client.domain.TransferSilaResponse;
import com.silamoney.client.exceptions.BadRequestException;
import com.silamoney.client.exceptions.ForbiddenException;
import com.silamoney.client.exceptions.InvalidSignatureException;
import com.silamoney.client.exceptions.ServerSideException;
import com.silamoney.client.testsutils.DefaultConfigurations;
import org.junit.Test;

/**
 *
 * @author Karlo Lorenzana
 */
public class TransferSilaTests {

	SilaApi api = new SilaApi(DefaultConfigurations.host, DefaultConfigurations.appHandle,
			DefaultConfigurations.privateKey);

	 

	@Test
	public void Response200Success() throws Exception {
		// TRANSACTIONS4
		 
		ApiResponse response = api.transferSila(DefaultConfigurations.getUserHandle(), 100, "geko.silamoney.eth", null,
				"test descriptor", DefaultConfigurations.correctUuid,
				DefaultConfigurations.getUserPrivateKey());

		assertEquals(200, response.getStatusCode());
		assertEquals("test descriptor", ((TransferSilaResponse) response.getData()).getDescriptor());
		assertEquals("SUCCESS", ((TransferSilaResponse) response.getData()).getStatus());
		assertNotNull(((TransferSilaResponse) response.getData()).getTransactionId());
	}

	@Test
	public void Response400() throws BadRequestException, InvalidSignatureException, ServerSideException, IOException,
			InterruptedException, ForbiddenException {
		// TRANSACTIONS5
		 
		ApiResponse response = api.transferSila(DefaultConfigurations.getUserHandle(), 100,
				DefaultConfigurations.getUserPrivateKey(), DefaultConfigurations.getUserPrivateKey(),
				"test descriptor", UUID.randomUUID().toString(),
				DefaultConfigurations.getUserPrivateKey());
		assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void Response400WrongUuid() throws BadRequestException, InvalidSignatureException, ServerSideException, IOException,
			InterruptedException, ForbiddenException {
		// TRANSACTIONS5
		ApiResponse response = api.transferSila(DefaultConfigurations.getUserHandle(), 100,
				DefaultConfigurations.getUserPrivateKey(), DefaultConfigurations.getUserPrivateKey(),
				"test descriptor", DefaultConfigurations.wrongUuid,
				DefaultConfigurations.getUserPrivateKey());

		assertEquals(400, response.getStatusCode());
	}

	@Test
	public void Response401() throws BadRequestException, InvalidSignatureException, ServerSideException, IOException,
			InterruptedException, ForbiddenException {
		 
		api = new SilaApi(DefaultConfigurations.host, DefaultConfigurations.appHandle,
				"3a1076bf45ab87712ad64ccb3b10217737f7faacbf2872e88fdd9a537d8fe266");
		ApiResponse response = api.transferSila(DefaultConfigurations.getUserHandle(), 100, "geko.silamoney.eth", null,
				"test descriptor", UUID.randomUUID().toString(),
				DefaultConfigurations.getUserPrivateKey());
		
		assertEquals(401, response.getStatusCode());
	}
}
