package com.baby_care_website;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DAO extends JpaRepository<Contact, Integer> {

	void save(Doctors cn);

}
