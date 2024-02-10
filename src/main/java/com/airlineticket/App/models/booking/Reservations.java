package com.airlineticket.App.models.booking;


import com.airlineticket.App.models.User;
import com.airlineticket.App.models.flights.TripDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "flight_reservations")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Reservations {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;


        @ManyToOne
        @JoinColumn(name = "userId", nullable = false)
        private User userId;


        @ManyToOne
        @JoinColumn(name = "trip_id", nullable = false)
        private TripDetails trip_id;



        @Column(name = "passenger_count")
        private Integer passengercount;


        @Column(name = "seat_class")
        private SeatClass seat_class=SeatClass.ECONOMY;

        @Column(name = "passport_country")
        private String passport_country;

        @Column(name = "passport_number")
        private String passport_number;

        @Column(name = "primary_passenger_age")
        private Integer primary_passenger_age;

        @Column(name = "primary_passenger_name")
        private String primary_passenger_name;

        @Column(name = "primary_passenger_number")
        private String primary_passenger_number;


        @Column(name = "primary_passenger_email")
        private String primary_passenger_email;


        @Column(name = "payment_status")
        private PaymentStatus payment_status=PaymentStatus.UN_PAID;


        @Column(name = "reservation_status")
        private ReservationStatus reservation_status=ReservationStatus.HOLD;

        @Column(name = "BoardingPassStatus")
        private Boolean BoardingPassStatus;

        @Override
        public String toString() {
                return "Reservations{" +
                        "id=" + id +
                        ", userId=" + userId +
                        ", trip_id=" + trip_id +
                        ", passengercount=" + passengercount +
                        ", seat_class=" + seat_class +
                        ", passport_country='" + passport_country + '\'' +
                        ", passport_number='" + passport_number + '\'' +
                        ", primary_passenger_age=" + primary_passenger_age +
                        ", primary_passenger_name='" + primary_passenger_name + '\'' +
                        ", primary_passenger_number='" + primary_passenger_number + '\'' +
                        ", primary_passenger_email='" + primary_passenger_email + '\'' +
                        ", payment_status=" + payment_status +
                        ", reservation_status=" + reservation_status +
                        ", BoardingPassStatus=" + BoardingPassStatus +
                        '}';
        }
}
