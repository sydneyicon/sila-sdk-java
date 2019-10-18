package com.silamoney.client.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Object sent in the transfer sila method.
 *
 * @author loren
 */
public class TransferMsg {

    @SerializedName("amount")
    private final int amount;

    @SerializedName("destination")
    private final String destination;

    @SerializedName("header")
    private final Header header;

    @SerializedName("message")
    private final String message;

    /**
     ** Constructor for TransferMsg object.
     *
     * @param userHandle
     * @param destination
     * @param amount
     * @param appHandle
     */
    public TransferMsg(String userHandle,
            String destination,
            int amount,
            String appHandle) {
        this.amount = amount;
        this.destination = destination;
        this.header = new Header(userHandle, appHandle);
        this.message = Message.ValueEnum.TRANSFER_MSG.getValue();
    }
}