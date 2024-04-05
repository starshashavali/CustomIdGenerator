package com.tcs.domain;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usertbl")
@Data
public class UserEntity {
	
	@Id
	@GeneratedValue(generator = "user_id_sequence")
	@SequenceGenerator(name = "user_id_sequence")
	@GenericGenerator(name = "user_id_sequence",strategy = "com.tcs.gerate.UserIdGenerator")
	private String userId;

	private String name;





}
