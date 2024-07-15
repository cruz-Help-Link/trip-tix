package org.dafe.tripTix.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class InitializePaymentDto {

    @NotNull(message = "Amount cannot be null")
    @JsonProperty("amount")
    private BigDecimal amount;

    @NotNull(message = "Email cannot be null")
    @JsonProperty("email")
    private String email;

    @JsonProperty("callback_url")
    private String callback_url;

}
