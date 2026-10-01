# cart test

A Selenium + Java test for https://www.saucedemo.com/

It logs in, opens two products one after the other, adds each to the cart, then opens the cart and checks that these buttons are there:

- Remove (for each product)
- Continue Shopping
- Checkout

## How to run

You need Java 17+, Maven and Chrome.

```
mvn clean test
```

Or open the project in IntelliJ and run `CartTest`.
