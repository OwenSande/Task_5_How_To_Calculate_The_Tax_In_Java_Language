package com.company;
import java.math.BigDecimal;
public class Main {

    public static void main(String[] args) {
        double netValue = 9.99;
        double Vat = netValue * 0.23;
        double grossValue = netValue + Vat;
        System.out.println("The gross value is "+grossValue);
        System.out.println("Price of 10 000 pcs including Vat is "+10000*grossValue);
        System.out.println("Price of 10 000 pcs excluding Vat is "+netValue*10000);

        //USING THE BIG DECIMAL CLASS
        System.out.println("");
        System.out.println("Same thing after using big decimal:");

        BigDecimal dbPriceWithoutVat = new BigDecimal("9.99");

        System.out.println("Price without VAT:"+ dbPriceWithoutVat);

        BigDecimal dbPriceWithVat = dbPriceWithoutVat.multiply(
                        new BigDecimal("1.23"));

        dbPriceWithVat= dbPriceWithVat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
        System.out.println("Price with VAT rounded: " + dbPriceWithVat);

        BigDecimal dbValueWithVat = dbPriceWithVat.multiply(

                new BigDecimal(10000));
        System.out.println("Value with VAT: " + dbValueWithVat);

        BigDecimal dbPriceWithoutVat2 = dbValueWithVat.divide(new BigDecimal("1.23"),
                BigDecimal.ROUND_HALF_EVEN);

        System.out.println("Value without VAT: " + dbPriceWithoutVat2);

    }
}
