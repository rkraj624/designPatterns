package com.design.patterns.strategy;
/*
 * When you have multiple algorithms or strategies for solving a particular problem, and you want to choose the appropriate one at runtime. For example, sorting algorithms like quicksort, bubbleSort, and mergeSort can be implemented using the Strategy pattern.
 */
public class StrategyPatternDesign {
    public interface PaymentStrategy {
        void pay(int amount);
    }

    public static class CreditCardPayment implements PaymentStrategy {
        @Override
        public void pay(int amount) {
            System.out.println("Payment has initiated of Rs " + amount );
        }
    }

    public static class PayPalPayment implements PaymentStrategy {
        @Override
        public void pay(int amount) {
            System.out.println("Payment has initiated of Rs " + amount );
        }
    }

    public static class ShoppingCart {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void checkout(int amount) {
            paymentStrategy.pay(amount);
        }
    }
    public interface Strategy {
        int execute(int a, int b);
    }
    public static class Context{
        private Strategy strategy;
        public Context(Strategy strategy){
            this.strategy = strategy;
        }
        int executeStrategy(int a, int b){
            return strategy.execute(a,b);
        }
    }
    public static class additionStrategy implements Strategy{
        @Override
        public int execute(int a, int b) {
            return a+b;
        }
    }
    public static class substractionStrategy implements Strategy{
        @Override
        public int execute(int a, int b) {
            return Math.abs(a-b);
        }
    }
    public static void main(String[] args) {
        Context context = new Context(new additionStrategy());
        System.out.println(context.executeStrategy(1,2));

        ShoppingCart cart = new ShoppingCart();

        // Set the payment strategy to credit card
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100);

        // Change the payment strategy to PayPal
        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(50);
    }
}
