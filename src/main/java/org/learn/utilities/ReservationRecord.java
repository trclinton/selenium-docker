package org.learn.utilities;

public record ReservationRecord(String firstName,
                                String lastName,
                                String email,
                                String street,
                                String city,
                                String state,
                                String zipCode,
                                String passengerCount,
                                String expectedPrice) {}
