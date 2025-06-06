package com.eventmanagement.entity;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String bookingId;

	private String bookingTime;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_id")
	private Event event;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private User customer;

	private String status; // confirmed, cancelled

	private BigDecimal amount;

	private int noOfTickets;

}
