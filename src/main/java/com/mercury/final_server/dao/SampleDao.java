package com.mercury.final_server.dao;

import com.mercury.final_server.bean.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

// CRUD Sample
// 1st generic type: Entity Class
// 2nd generic type: Primary key(id) type of Entity
public interface SampleDao extends JpaRepository<Sample, String> {

}

// we are creating an interface which extends data jpa's interface
// then, spring data jpa will automatically create a concrete class
// to implement our interface(SampleDao).
// in the concrete class, Spring data jpa will provide actual implementation
// for CRUD operations in database by using Hibernate
// after class created, spring will automatically create an object
// in the IoC container
// Now, in the spring IoC container, we have a SampleDao object!!!

// @Component
// class SampleDaoImpl implements SampleDao {
//      // a lot of methods
// }