package com.raj.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;		
	private Integer quantity;
	private Double price;
	private Double totalPrice;
	@ManyToOne
    @JoinColumn(name = "sale_master_id", referencedColumnName = "id")
	@JsonBackReference
	private SaleMaster saleMaster;
	@ManyToOne
    @JoinColumn(name = "item_id",referencedColumnName = "id")
    private Item item;

}
