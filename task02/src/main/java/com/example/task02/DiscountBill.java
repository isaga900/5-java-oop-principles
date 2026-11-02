package com.example.task02;

public class DiscountBill extends Bill {

    private final double discountPercent;

    public DiscountBill(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public long getDiscountAmount() {
        long totalPrice = super.getPrice();
        return (long) (totalPrice * discountPercent / 100.0);
    }

    @Override
    public long getPrice() {
        long totalPrice = super.getPrice();
        long discount = getDiscountAmount();
        return totalPrice - discount;
    }
}