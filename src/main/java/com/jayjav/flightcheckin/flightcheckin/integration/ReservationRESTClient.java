package com.jayjav.flightcheckin.flightcheckin.integration;

import com.jayjav.flightcheckin.flightcheckin.integration.dto.Reservation;
import com.jayjav.flightcheckin.flightcheckin.integration.dto.ReservationUpdateRequest;


public interface ReservationRESTClient {

    Reservation findReservation(Long id);

    Reservation updateReservation(ReservationUpdateRequest updateRequest);
}
