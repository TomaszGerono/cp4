package pl.gerono.ecommerce.sales.reservation;

import java.util.HashMap;
import java.util.Optional;

public class ReservationRepository {
    HashMap<String, pl.gerono.ecommerce.sales.reservation.Reservation> reservations;

    public ReservationRepository() {
        this.reservations = new HashMap<>();
    }

    public Optional<pl.gerono.ecommerce.sales.reservation.Reservation> load(String reservationId) {
        return Optional.of(reservations.get(reservationId));
    }

    public void add(pl.gerono.ecommerce.sales.reservation.Reservation reservation) {
        reservations.put(reservation.getId(), reservation);
    }
}
