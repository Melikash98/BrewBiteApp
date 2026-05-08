package com.melikash98.brewbite.HelperClass;

import android.app.Activity;

import com.google.android.gms.wallet.PaymentsClient;
import com.google.android.gms.wallet.Wallet;
import com.google.android.gms.wallet.WalletConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * The GooglePayHelper class is a utility helper class responsible for building
 * Google Pay request objects and creating a configured PaymentsClient instance
 * for handling payment-related operations inside the application.
 *
 * This class centralizes all Google Pay logic in one place so that the payment
 * implementation stays clean, reusable, and easier to maintain across the app.
 *
 * Main responsibilities of this class:
 * - Creating a PaymentsClient instance with the required Google Pay environment
 * - Building the isReadyToPay request to check whether Google Pay is available
 *   on the device and supported by the user's account
 * - Building the PaymentDataRequest used to launch the Google Pay payment flow
 *
 * Why this helper class is useful:
 * - Keeps payment-related JSON building logic separated from UI or Activity code
 * - Improves readability and maintainability
 * - Makes it easier to update supported card networks, tokenization settings,
 *   merchant info, or transaction values in one single place
 *
 * Important notes:
 * - The class currently uses the TEST environment for development purposes
 * - The gateway, merchant ID, currency code, and country code should be updated
 *   according to the real production configuration before release
 * - The price value should be passed in a valid numeric string format, such as "9.99"
 */
public class GooglePayHelper {
    /**
     * Google Pay environment used for the PaymentsClient.
     *
     * ENVIRONMENT_TEST is recommended during development and testing.
     * It should be replaced with ENVIRONMENT_PRODUCTION when the application
     * is ready for live payments.
     */
    private static final int PAYMENTS_ENVIRONMENT = WalletConstants.ENVIRONMENT_TEST;

    /**
     * Creates and returns a PaymentsClient instance configured with the
     * selected Google Pay environment.
     *
     * This client is used to interact with Google Pay services and perform
     * payment-related operations.
     *
     * @param activity the current Activity context required by Google Pay
     * @return a configured PaymentsClient instance
     */

    public static PaymentsClient createPaymentsClient(Activity activity) {
        Wallet.WalletOptions walletOptions = new Wallet.WalletOptions.Builder()
                .setEnvironment(PAYMENTS_ENVIRONMENT)
                .build();
        return Wallet.getPaymentsClient(activity, walletOptions);
    }

    /**
     * Builds the request used to check whether the device and user account
     * are ready to use Google Pay.
     *
     * This request defines the supported payment method type, allowed card
     * authentication methods, and supported card networks.
     *
     * @return a JSONObject representing the isReadyToPay request
     * @throws JSONException if any JSON construction error occurs
     */

    public static JSONObject isReadyToPayRequest() throws JSONException {
        JSONObject request = new JSONObject();
        request.put("apiVersion", 2);
        request.put("apiVersionMinor", 0);

        JSONArray allowedPaymentMethods = new JSONArray();
        JSONObject paymentMethod = new JSONObject();
        paymentMethod.put("type", "CARD");

        JSONObject parameters = new JSONObject();
        parameters.put("allowedAuthMethods", new JSONArray()
                .put("PAN_ONLY")
                .put("CRYPTOGRAM_3DS"));
        parameters.put("allowedCardNetworks", new JSONArray()
                .put("VISA")
                .put("MASTERCARD"));

        paymentMethod.put("parameters", parameters);
        allowedPaymentMethods.put(paymentMethod);
        request.put("allowedPaymentMethods", allowedPaymentMethods);

        return request;
    }

    /**
     * Builds the PaymentDataRequest object used to launch the Google Pay
     * payment sheet and process the transaction.
     *
     * This request includes:
     * - Supported payment methods
     * - Tokenization specification for payment gateway processing
     * - Transaction information such as amount, currency, and country
     * - Merchant information displayed to the user during checkout
     *
     * @param price the total payment amount as a string, for example "9.99"
     * @return a JSONObject representing the payment data request
     * @throws JSONException if any JSON construction error occurs
     */

    public static JSONObject getPaymentDataRequest(String price) throws JSONException {
        JSONObject request = new JSONObject();
        request.put("apiVersion", 2);
        request.put("apiVersionMinor", 0);

        JSONArray allowedPaymentMethods = new JSONArray();
        JSONObject paymentMethod = new JSONObject();
        paymentMethod.put("type", "CARD");

        JSONObject parameters = new JSONObject();
        parameters.put("allowedAuthMethods", new JSONArray()
                .put("PAN_ONLY")
                .put("CRYPTOGRAM_3DS"));
        parameters.put("allowedCardNetworks", new JSONArray()
                .put("VISA")
                .put("MASTERCARD"));
        paymentMethod.put("parameters", parameters);

        JSONObject tokenizationSpec = new JSONObject();
        tokenizationSpec.put("type", "PAYMENT_GATEWAY");

        JSONObject tokenParams = new JSONObject();

        tokenParams.put("gateway", "example");
        tokenParams.put("gatewayMerchantId", "YOUR_MERCHANT_ID");
        tokenizationSpec.put("parameters", tokenParams);

        paymentMethod.put("tokenizationSpecification", tokenizationSpec);
        allowedPaymentMethods.put(paymentMethod);
        request.put("allowedPaymentMethods", allowedPaymentMethods);

        JSONObject transactionInfo = new JSONObject();
        transactionInfo.put("totalPrice", price);
        transactionInfo.put("totalPriceStatus", "FINAL");
        transactionInfo.put("currencyCode", "USD");
        transactionInfo.put("countryCode", "US");
        request.put("transactionInfo", transactionInfo);

        JSONObject merchantInfo = new JSONObject();
        merchantInfo.put("merchantName", "BrewBite");

        merchantInfo.put("merchantId", "BCR2DN4TZ3JDZMQ4");
        request.put("merchantInfo", merchantInfo);

        return request;
    }
}
