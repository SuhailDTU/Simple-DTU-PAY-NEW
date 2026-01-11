package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.exceptions.UserNotFoundException;
import org.acme.record.Customer;
import org.acme.record.Merchant;
import org.acme.record.Payment;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class DTUPayService {

    private final ConcurrentHashMap<UUID, Customer> customers = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<UUID, Merchant> merchants = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<UUID, Payment> payments = new ConcurrentHashMap<>();

    public UUID registerCustomer(String name) {
        var id = UUID.randomUUID();
        var customer = new Customer(name);
        customers.put(id, customer);
        return id;
    }

    public void deleteCustomer(UUID id) {
        if (!customers.containsKey(id)) {
            throw new UserNotFoundException("Customer does not exist");
        }
        customers.remove(id);
    }

    public Optional<Customer> getCustomerById(UUID id) {
        var customer = customers.get(id);
        return Optional.ofNullable(customer);
    }

    public UUID registerMerchant(String name) {
        var id = UUID.randomUUID();
        var merchant = new Merchant(name);
        merchants.put(id, merchant);
        return id;
    }

    public void deleteMerchant(UUID id) {
        if (!merchants.containsKey(id)) {
            throw new UserNotFoundException("Merchant does not exist");
        }
        merchants.remove(id);
    }

    public Optional<Merchant> getMerchantById(UUID id) {
        var merchant = merchants.get(id);
        return Optional.ofNullable(merchant);
    }

    public UUID createPayment(UUID customerId, UUID merchantId, BigDecimal amount) {
        UUID paymentId = UUID.randomUUID();
        if (!customers.containsKey(customerId)) {
            throw new UserNotFoundException("Customer does not exist");
        }
        if (!merchants.containsKey(merchantId)) {
            throw new UserNotFoundException("Merchant does not exist");
        }

        var payment = new Payment(paymentId, customerId, merchantId, amount, Instant.now());
        payments.put(paymentId, payment);
        return paymentId;
    }

    public Optional<Payment> getPaymentById(UUID id) {
        var payment = payments.get(id);
        return Optional.ofNullable(payment);
    }

    public Collection<Payment> getAllPayments() {
        return payments.values();
    }
}
