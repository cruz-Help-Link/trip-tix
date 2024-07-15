package org.dafe.tripTix.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.dafe.tripTix.entity.Trip;
import org.dafe.tripTix.entity.User;

import java.util.Date;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BookingRequest {
    private User user;
    private Trip tripDetails;

}
