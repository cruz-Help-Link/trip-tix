package org.dafe.tripTix.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookTicket {

    private int id;
    private String yourChoice;
    private String trip;
    private String fromLocation;
    private String toLocation;
    private String departureDate;
    private String returnDate;



}
