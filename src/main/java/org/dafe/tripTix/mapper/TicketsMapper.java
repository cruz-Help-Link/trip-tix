//package org.dafe.tripTix.mapper;
//
//import org.dafe.tripTix.dto.TicketsDto;
//import org.dafe.tripTix.dto.TicketsDto;
//import org.dafe.tripTix.entity.Tickets;
//import org.dafe.tripTix.entity.VehicleTicket;
//import org.springframework.stereotype.Component;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class TicketsMapper {
//
//    public TicketsDto toDTO(Tickets ticket, List<String> vehicleTypes) {
//        TicketsDto  dto = new TicketsDto();
//        dto.setId(ticket.getTicketId());
//        dto.setLocationFrom(ticket.getLocationFrom());
//        dto.setLocationTo(ticket.getLocationTo());
//        dto.setTripType(ticket.getTripType());
//        dto.setDepartsDay(ticket.getDepartsDay());
//        dto.setDepartsTime(ticket.getDepartsTime());
//        dto.setReturnDay(ticket.getReturnDay());
//        dto.setReturnTime(ticket.getReturnTime());
//        dto.setAdults(ticket.getAdults());
//        dto.setChildren(ticket.getChildren());
//        dto.setAdultPrice(ticket.getAdultPrice());
//        dto.setChildPrice(ticket.getChildPrice());
//        dto.setPassengers(ticket.getPassengers());
//        dto.setVehicleTypes(vehicleTypes);
//        return dto;
//    }
//
//    public Tickets toEntity(TicketsDto  dto) {
//        Tickets ticket = new Tickets();
//        ticket.setTicketId(dto.getId());
//        ticket.setLocationFrom(dto.getLocationFrom());
//        ticket.setLocationTo(dto.getLocationTo());
//        ticket.setTripType(dto.getTripType());
//        ticket.setDepartsDay(dto.getDepartsDay());
//        ticket.setDepartsTime(dto.getDepartsTime());
//        ticket.setReturnDay(dto.getReturnDay());
//        ticket.setReturnTime(dto.getReturnTime());
//        ticket.setAdults(dto.getAdults());
//        ticket.setChildren(dto.getChildren());
//        ticket.setAdultPrice(dto.getAdultPrice());
//        ticket.setChildPrice(dto.getChildPrice());
//        ticket.setPassengers(dto.getPassengers());
//        return ticket;
//    }
//
//    public List<TicketsDto > toDTOs(List<Tickets> tickets, List<VehicleTicket> vehicleTickets) {
//        return tickets.stream().map(ticket -> {
//            List<String> vehicleTypes = vehicleTickets.stream()
//                    .filter(vehicleTicket -> vehicleTicket.getTicket().getTicketId() == ticket.getTicketId())
//                    .map(vehicleTicket -> vehicleTicket.getVehicle().getVehicleType())
//                    .collect(Collectors.toList());
//            return toDTO(ticket, vehicleTypes);
//        }).collect(Collectors.toList());
//    }
//}
