package org.dafe.tripTix.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketsDto {
    private int id;
    private String locationFrom;
    private String locationTo;
    private String tripType;
    private LocalDate departsDay;
    private LocalTime departsTime;
    private LocalDate returnDay;
    private LocalTime returnTime;
    private int adults;
    private int children;
    private float adultPrice;
    private float childPrice;
    private int passengers;
    private List<String> vehicleTypes;

    // Getters and Setters
}
