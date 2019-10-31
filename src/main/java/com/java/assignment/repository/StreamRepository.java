package com.java.assignment.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.assignment.modal.Stream;

@Repository
@Transactional
public interface StreamRepository extends JpaRepository<Stream, Integer> {

}
