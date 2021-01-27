package br.com.petz.customer.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String documentType;

	@Column(unique = true)
	private String documentNumber;
	
	@Column
	private LocalDate dateOfBirth;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Address address;

	@ElementCollection(fetch = FetchType.LAZY)
	private List<ContactNumber> phones;

	@Column
	private String email;

	public void setId(Long id) {
		this.customerId = id;
	}

	public void update(Customer reference) {

		if (null != reference.firstName && !reference.firstName.equals(this.firstName)) {
			this.firstName = reference.firstName;
		}

		if (null != reference.lastName && !reference.lastName.equals(this.lastName)) {
			this.lastName = reference.lastName;
		}

		if (null != reference.documentType && !reference.documentType.equals(this.documentType)) {
			this.documentType = reference.documentType;
		}

		if (null != reference.documentNumber && !reference.documentNumber.equals(this.documentNumber)) {
			this.documentNumber = reference.documentNumber;
		}

		if (null != reference.address && !reference.address.equals(this.address)) {
			this.address = reference.address;
		}

		if (null != reference.phones && !reference.phones.isEmpty()) {
			this.phones = reference.phones;
		}

		if (null != reference.email && !reference.email.isEmpty() && !reference.email.equals(this.email)) {
			this.email = reference.email;
		}
	}

}
