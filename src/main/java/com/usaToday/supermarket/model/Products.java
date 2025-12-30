package com.usaToday.supermarket.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Product_id;
    private String Name;
    private int Quantity;
    private String  Section;
    private BigDecimal Unit_Price;

    public void setQuantity(int quantity) {
        if (quantity<0)
            throw new IllegalArgumentException("Quantity cannot be less than 0");
        this.Quantity = quantity;
    }

    public void setSection(String section) {
        String VALID_REGEX = "^[A-Z][A-Z0-9_]*$";
                if (section == null)
                    throw new IllegalArgumentException("section cannot be null");

                String uppercaseValue = section.toUpperCase();

                if (!uppercaseValue.matches(VALID_REGEX))
                    throw new IllegalArgumentException("Invalid format. Must start with an uppercase letter and contain only uppercase letters, numbers, or underscores.");

                this.Section = uppercaseValue;
    }

    public String getUnit_Price() {
        DecimalFormat CURRENCY_FORMAT = new DecimalFormat("'$'0.00");
        if (this.Unit_Price == null) {
            return "$0.00"; // Default or handle as needed
        }
        // Format the stored BigDecimal as a currency string
        return CURRENCY_FORMAT.format(this.Unit_Price);
    }

    public void setUnit_Price(BigDecimal unit_Price) {
        if (unit_Price == null)
            throw new IllegalArgumentException("Price cannot be null");

        if (unit_Price.scale() > 2)
            throw new IllegalArgumentException("Price cannot have more than two decimal places: " + unit_Price);

        this.Unit_Price = unit_Price.setScale(2, RoundingMode.UNNECESSARY);
    }
}

