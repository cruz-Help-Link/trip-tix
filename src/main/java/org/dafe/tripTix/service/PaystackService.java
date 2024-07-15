package org.dafe.tripTix.service;

import org.dafe.tripTix.dto.InitializePaymentDto;
import org.dafe.tripTix.repository.InitializePaymentResponse;
import org.dafe.tripTix.repository.PaymentVerificationResponse;

public interface PaystackService {
    InitializePaymentResponse initializePayment(InitializePaymentDto initializePaymentDto);

    PaymentVerificationResponse paymentVerification(String reference) throws Exception;
}
