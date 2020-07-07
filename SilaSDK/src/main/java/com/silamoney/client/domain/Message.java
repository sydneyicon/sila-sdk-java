package com.silamoney.client.domain;

/**
 * Contains the message possible options.
 *
 * @author Karlo Lorenzana
 */
public class Message {
    
    private Message(){
        
    }

    /**
     * Enum that contains the message options.
     */
    public enum ValueEnum {

        /**
         * String value for HeaderMsg.
         */
        HEADER_MSG("header_msg"),
        /**
         * String value for EntityMsg.
         */
        ENTITY_MSG("entity_msg"),
        /**
         * String value for GetAccountMsg.
         */
        GET_ACCOUNTS_MSG("get_accounts_msg"),
        /**
         * String value for GetAccountMsg.
         */
        GET_ACCOUNT_BALANCE_MSG("get_account_balance_msg"),
        /**
         * String value for GetTransactionsMsg.
         */
        GET_TRANSACTIONS_MSG("get_transactions_msg"),
        /**
         * String value for IssueMsg.
         */
        ISSUE_MSG("issue_msg"),
        /**
         * String value for LinkAccountMsg.
         */
        LINK_ACCOUNT_MSG("link_account_msg"),
        /**
         * String value for RedeemMsg.
         */
        REDEEM_MSG("redeem_msg"),
        /**
         * String value for TransferMsg.
         */
        TRANSFER_MSG("transfer_msg"),
        /**
         * String value for PlaidSameDayAuthMsg.
         */
        PLAID_SAMEDAY_AUTH_MSG("plaid_sameday_auth_msg"),
        /**
         * String value for GetWalletMsg.
         */
        GET_WALLET_MSG("get_wallet_msg"),
        /**
         * String value for RegisterWalletMsg.
         */
        REGISTER_WALLET_MSG("register_wallet_msg"),
        /**
         * String value for UpdateWalletMsg.
         */
        UPDATE_WALLET_MSG("update_wallet_msg"),
        /**
         * String value for DeleteWalletMsg.
         */
        DELETE_WALLET_MSG("delete_wallet_msg"),
        /**
         * String value for GetWalletsMsg.
         */
        GET_WALLETS_MSG("get_wallets_msg"),
        /**
         * String value for GetSilaBalanceMsg.
         */
        GET_SILA_BALANCE("get_sila_balance"),
        /**
         * String value for GetBusinessTypes.
         */
        GET_BUSINESS_TYPES("get_business_types");

        private final String value;

        ValueEnum(String value) {
            this.value = value;
        }

        /**
         * Gets the selected message value.
         *
         * @return option value.
         */
        public String getValue() {
            return value;
        }
    }
}
