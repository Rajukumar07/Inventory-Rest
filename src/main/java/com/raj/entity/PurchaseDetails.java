package com.raj.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "purchase_details")
public class PurchaseDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private Double price;
	private Integer quantity;
	private Double amount;
	@ManyToOne
	@JoinColumn(name = "purchaseId",referencedColumnName = "id")
	@JsonBackReference
	private PurchaseMaster purchaseMaster;
	@ManyToOne
	@JoinColumn(name = "itemId" ,referencedColumnName = "id")
	
	private Item item;
	
}
