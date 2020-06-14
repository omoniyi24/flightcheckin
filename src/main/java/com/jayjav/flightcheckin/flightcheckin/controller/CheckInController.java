package com.jayjav.flightcheckin.flightcheckin.controller;

import com.jayjav.flightcheckin.flightcheckin.integration.ReservationRESTClient;
import com.jayjav.flightcheckin.flightcheckin.integration.dto.Reservation;
import com.jayjav.flightcheckin.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckInController {

    @Autowired
    ReservationRESTClient reservationRESTClient;

    @RequestMapping("/showStartCheckIn")
    public String showStartCheckin(){
        return "startCheckIn";
    }

    @RequestMapping("/startCheckIn")
    public String startCheckin(@RequestParam("reservationId") Long reservationId, ModelMap modelMap){
        Reservation reservation = reservationRESTClient.findReservation(reservationId);
        modelMap.addAttribute("reservation", reservation);
        return "displayReservationDetails";
    }

    @RequestMapping("/completeCheckIn")
    public String completeCheckIn(@RequestParam("reservationId") Long reservationId,
                                  @RequestParam("numberOfBags") int numberOfBags) {
        ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
        reservationUpdateRequest.setId(reservationId);
        reservationUpdateRequest.setCheckedIn(true);
        reservationUpdateRequest.setNumberOfBags(numberOfBags);
        reservationRESTClient.updateReservation(reservationUpdateRequest);
        return "checkInConfirmation";

    }
}
