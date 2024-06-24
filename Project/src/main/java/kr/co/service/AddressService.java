package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.beans.AddressBean;
import kr.co.dao.AddressDao;

@Service
public class AddressService {
	
	@Autowired
	private AddressDao addressDao;
	
	//愿�由ъ옄 �쁺�뿭
	public List<AddressBean> getAddrById(String code){
		return addressDao.getAddrById(code);
	}
	
	public AddressBean getAddrByAddrId(String address_id) {
		return addressDao.getAddrByAddrId(address_id);
	}

}