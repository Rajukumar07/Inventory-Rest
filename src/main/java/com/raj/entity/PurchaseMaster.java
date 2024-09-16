package com.raj.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//PurchaseMaster.java
@Entity
@Table(name = "purchase_master")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique =true)
	private String invoiceNo;
	private LocalDate invoiceDate;	
	private Double totalAmount;
	
	@CreationTimestamp
	private LocalDateTime dateTime;

	@OneToMany(mappedBy = "purchaseMaster", cascade = CascadeType.ALL)
	@JsonManagedReference	
	private List<PurchaseDetails> purchaseDetails;
	@OneToOne
	@JoinColumn(name = "supplierId", referencedColumnName = "id")
	private Supplier supplier;

}
