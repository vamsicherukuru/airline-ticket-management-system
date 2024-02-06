package com.airlineticket.App.models.booking;


import com.airlineticket.App.models.User;
import com.airlineticket.App.models.flights.TripDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "card_number")
    private String card_number;

    @Column(name = "name_on_card")
    private String name_on_card;

    @Column(name = "expiry_date")
    private String expiry_date;

    @Column(name = "cvv")
    private String cvv;

    @Column(name = "street_address")
    private String street_address;

    @Column(name = "address_2")
    private String address_2;

    @Column(name = "billing_city")
    private String billing_city;

    @Column(name = "billing_country")
    private String billing_country;


    @Column(name = "billing_zipcode")
    private String billing_zipcode;


    @Column(name = "payment_status")
    private PaymentStatus payment_status=PaymentStatus.UN_PAID;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user_id;

    @OneToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private TripDetails trip_id;

    @OneToOne
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservations reservation_id;



    @Column(name = "total_amount")
    private Double total_amount;


    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", card_number='" + card_number + '\'' +
                ", name_on_card='" + name_on_card + '\'' +
                ", expiry_date='" + expiry_date + '\'' +
                ", cvv='" + cvv + '\'' +
                ", street_address='" + street_address + '\'' +
                ", address_2='" + address_2 + '\'' +
                ", billing_city='" + billing_city + '\'' +
                ", billing_country='" + billing_country + '\'' +
                ", billing_zipcode='" + billing_zipcode + '\'' +
                ", payment_status=" + payment_status +
                ", user_id=" + user_id +
                ", trip_id=" + trip_id +
                ", reservation_id=" + reservation_id +
                ", total_amount=" + total_amount +
                '}';
    }
}
