package com.silamoney.client.tests;

import com.silamoney.client.api.ApiResponse;
import com.silamoney.client.api.SilaApi;
import com.silamoney.client.domain.BaseResponse;
import com.silamoney.client.exceptions.BadRequestException;
import com.silamoney.client.exceptions.ForbiddenException;
import com.silamoney.client.exceptions.InvalidSignatureException;
import com.silamoney.client.exceptions.ServerSideException;
import com.silamoney.client.testsutils.DefaultConfigurations;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Karlo Lorenzana
 */
public class TransferSilaTests {

    SilaApi api = new SilaApi(DefaultConfigurations.host,
            DefaultConfigurations.appHandle,
            DefaultConfigurations.privateKey);

    @Test
    public void Response200Success() throws Exception {
        ApiResponse response = api
                .TransferSila(DefaultConfigurations.userHandle,
                        13,
                        "user2.silamoney.eth",
                        DefaultConfigurations.userPrivateKey);

        assertEquals(200, response.getStatusCode());
        assertEquals("ref submitted to ETH queue", 
                ((BaseResponse) response.getData()).getMessage());
        assertEquals("SUCCESS", ((BaseResponse) response.getData()).getStatus());
    }

    @Test
    public void Response200Failure() throws Exception {
        ApiResponse response = api
                .TransferSila("failure.silamoney.eth",
                        13,
                        "user2.silamoney.eth",
                        DefaultConfigurations.userPrivateKey);

        assertEquals(200, response.getStatusCode());
        assertEquals("ref not submitted to ETH queue", 
                ((BaseResponse) response.getData()).getMessage());
        assertEquals("FAILURE", ((BaseResponse) response.getData()).getStatus());
    }

    @Test(expected = BadRequestException.class)
    public void Response400() throws
            BadRequestException,
            InvalidSignatureException,
            ServerSideException,
            IOException,
            InterruptedException,
            ForbiddenException {
        ApiResponse response = api
                .TransferSila("badrequest.silamoney.eth",
                        13,
                        "user2.silamoney.eth",
                        DefaultConfigurations.userPrivateKey);
    }

    @Test(expected = InvalidSignatureException.class)
    public void Response401() throws
            BadRequestException,
            InvalidSignatureException,
            ServerSideException,
            IOException,
            InterruptedException,
            ForbiddenException {
        ApiResponse response = api
                .TransferSila("invalidsignature.silamoney.eth",
                        13,
                        "user2.silamoney.eth",
                        DefaultConfigurations.userPrivateKey);
    }
}
