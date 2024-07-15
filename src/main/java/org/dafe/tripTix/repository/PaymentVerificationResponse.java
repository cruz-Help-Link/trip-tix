package org.dafe.tripTix.repository;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentVerificationResponse {

    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

}