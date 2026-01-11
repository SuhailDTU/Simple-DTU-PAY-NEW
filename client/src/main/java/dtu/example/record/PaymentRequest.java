package dtu.example.record;

public record PaymentRequest(String customerId, String merchantId, double amount) {
}
