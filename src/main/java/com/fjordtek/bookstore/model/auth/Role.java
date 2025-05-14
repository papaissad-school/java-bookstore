//Pekka Helenius <fincer89@hotmail.com>, Fjordtek 2020

package com.fjordtek.bookstore.model.auth;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

/**
 * This class implements Role entity which forms
 * core structure for the corresponding ROLE table in a database.
 * <p>
 * Additionally, Role entity objects are Java objects having
 * methods, attributes and other class-related additions within them.
 *
 * @author Pekka Helenius
 */

@Entity
@Table(name = "ROLE")
public class Role {

	////////////////////
	// Primary key value in database

	@Idd
	@GeneratedValue(
			strategy     = GenerationType.IDENTITY,
			generator    = "roleIdGenerator"
			)
	@SequenceGenerator(
			name         = "roleIdGenerator",
			sequenceName = "roleIdSequence"
			)
	private Long id;

	@Column(
			unique   = true,
			nullable = false,
			columnDefinition = "VARCHAR(20)"
			)
	@NotBlank
	@NotBlank
	private String name;

	@Column(
	  columnDefinition = "VARCHAR(255)"
	)
	private String description;

	@OneToMany(
			mappedBy      = "role",
			cascade       = CascadeType.ALL,
			fetch         = FetchType.LAZY,
			orphanRemoval = true
			)
	// Role objects do not have any UserRoles when initializing them
	@Transient
	private List<UserRole> userRoles;

	////////////////////
	// Attribute setters

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
/*
	public void setUserroles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
*/
	////////////////////
	// Attribute getters

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
/*
	public List<UserRole> getUserroles() {
		return userRoles;
	}
*/
	////////////////////
	// Class constructors

	public Role() {
	}

	public Role(String name) {
		// super();
		this.name = name;
	}

	public Role(String name, String description) {
		this.name = name;
		this.description = description;
	}

	////////////////////
	// Class overrides

	@Override
	public String toString() {
		return "[" + "id: " + this.id   + ", " +
				   "name: " + this.name + ", " +
				   "description: " + this.description + "]";
	}

}