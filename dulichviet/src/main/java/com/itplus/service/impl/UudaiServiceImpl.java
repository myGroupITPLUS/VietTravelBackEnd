package com.itplus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itplus.dao.UudaiDao;
import com.itplus.entity.Uudai;
import com.itplus.model.UudaiDTO;
import com.itplus.service.UudaiService;


@Service
public class UudaiServiceImpl implements UudaiService{
	@Autowired
	UudaiDao uUdaiDao;
	@Override
	public List<UudaiDTO> getAllUudai() {
		List<UudaiDTO> listUudaiDTO = new ArrayList<UudaiDTO>();
		List<Uudai> listUudai = uUdaiDao.getAllUudai();
		for (Uudai uudai : listUudai) {
			UudaiDTO uudaiDTO = new UudaiDTO();
			uudaiDTO.setMauudai(uudai.getMauudai());
			uudaiDTO.setSale(uudai.getSale());
			uudaiDTO.setMota(uudai.getMota());
			uudaiDTO.setAnh(uudai.getAnh());
			listUudaiDTO.add(uudaiDTO);
		}
		return listUudaiDTO;
	}
	
	

}
