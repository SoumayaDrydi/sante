package com.iset.sante.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iset.sante.entities.Regime;

public interface RegimeRepository extends JpaRepository<Regime, Integer> {

}
