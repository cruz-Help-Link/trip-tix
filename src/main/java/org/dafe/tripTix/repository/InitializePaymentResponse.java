package org.dafe.tripTix.repository;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InitializePaymentResponse {
    private boolean status;
    private String message;
    private Data data;

    // Getters and setters

    public static class Data {
        // Getters and setters
        @Getter
        @JsonProperty("authorization_url")
        private String authorizationUrl;

        @JsonProperty("access_code")
        private String access_code;

        @Getter
        private String reference;

        public void setAuthorizationUrl(String authorizationUrl) {
            this.authorizationUrl = authorizationUrl;
        }

        public String getAccessCode() {
            return access_code;
        }

        public void setAccessCode(String access_code) {
            this.access_code = access_code;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}