package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Product {
	@Id
	@GeneratedValue
	private Integer prodId;
	@NonNull
	private String prodCode;
	@NonNull
	private String prodVendor;
	@NonNull
	private String prodModel;
	@NonNull
	private Double prodCost;
}
