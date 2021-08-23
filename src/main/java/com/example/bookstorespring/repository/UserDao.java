package com.example.bookstorespring.repository;

import com.example.bookstorespring.entity.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Transient;

@Repository
public interface UserDao extends JpaRepository<DAOUser, Integer> {
	
	DAOUser findByUsername(String username);
	@Transactional
	@Modifying
	@Query(value = "update DAOUser user set user.address= :userAddress,user.city=:city,user.landmark=:landmark,user.locality=:locality,user.pincode=:pincode where user.username=:username" )
	void updateUserAddress(@Param("userAddress")String address, @Param("username") String username,
							@Param("city")String city,@Param("landmark")String ladmark,
						   @Param("pincode")String pincode,@Param("locality")String locality);
	
}