package com.jayjav.flightcheckin.flightcheckin.integration;

import com.jayjav.flightcheckin.flightcheckin.integration.dto.Reservation;
import com.jayjav.flightcheckin.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationRESTClientImpl implements ReservationRESTClient {

    @Value("${com.jayjav.flightcheckin.flightreservation.url}")
    private String RESERVATION_REST_URL;

    @Override
    public Reservation findReservation(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.getForObject(RESERVATION_REST_URL + id, Reservation.class);
        return reservation;
    }

    @Override
    public Reservation updateReservation(ReservationUpdateRequest updateRequest) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.postForObject(RESERVATION_REST_URL, updateRequest, Reservation.class);
        return reservation;
    }
}
