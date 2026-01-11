package org.acme.record;

public record PaymentRequest(String customerId, String merchantId, double amount) {
}
