package com.iset.sante.service;

import java.util.List;

import com.iset.sante.entities.Profil;
import com.iset.sante.entities.Regime;

public interface RegimeService {
	Regime saveRegime(Regime r); 
	 Regime updateRegime(Regime  r); 
	void deleteRegime(Regime  r); 
	void deleteRegimeById(Integer id); 
	 Regime getRegime(Integer id); 
	 List<Regime> getAllRegimes();
	 Profil addUserRegime(int userProfileId, int regimeId);
}
