package com.design.patterns.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DecoratorDesignPattern {
    public static final Logger logger = LoggerFactory.getLogger(DecoratorDesignPattern.class);

    // Step 1: Component (Interface)
    interface Coffee {
        double cost();
    }

    // Step 2: Concrete Component
    static class SimpleCoffee implements Coffee {
        @Override
        public double cost() {
            return 2.0;
        }
    }

    // Step 3: Decorator
    public abstract static class CoffeeDecorator implements Coffee {
        protected Coffee decoratedCoffee;

        private CoffeeDecorator(Coffee decoratedCoffee) {
            this.decoratedCoffee = decoratedCoffee;
        }

        @Override
        public double cost() {
            return decoratedCoffee.cost();
        }
    }

    // Step 4: Concrete Decorators
    public static class MilkDecorator extends CoffeeDecorator {
        public MilkDecorator(Coffee decoratedCoffee) {
            super(decoratedCoffee);
        }

        @Override
        public double cost() {
            return super.cost() + 1.0; // Additional cost for milk
        }
    }

    static class SugarDecorator extends CoffeeDecorator {
        public SugarDecorator(Coffee decoratedCoffee) {
            super(decoratedCoffee);
        }

        @Override
        public double cost() {
            return super.cost() + 0.5; // Additional cost for sugar
        }
    }

    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        logger.info(String.format("Cost of simple coffee: ${}", coffee.cost()));
        Coffee milkCoffee = new MilkDecorator(coffee);
        logger.info(String.format("Cost of coffee with milk: ${0}", milkCoffee.cost()));
        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        logger.info(String.format("Cost of coffee with milk and sugar: ${0}", sugarMilkCoffee.cost()));
    }
}
