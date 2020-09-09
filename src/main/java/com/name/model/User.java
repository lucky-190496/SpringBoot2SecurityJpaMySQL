package com.name.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usertab")
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String email;
	private String pwd;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="rolestab",
	joinColumns = @JoinColumn(name="id"))
	@Column(name="role")
	private Set<String> roles;


}