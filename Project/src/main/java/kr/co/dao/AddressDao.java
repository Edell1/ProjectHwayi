package kr.co.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beans.AddressBean;
import kr.co.mapper.AddressMapper;

@Repository
public class AddressDao {

	@Autowired
	private AddressMapper addressMapper;

	// my page�뿉�꽌 媛믩낫湲�
	public List<AddressBean> getAllAddress(String code) {
		return addressMapper.getAllAddress(code);
	}

	public void allAddrInfo(AddressBean memberAddrBean) {
		addressMapper.addAddrInfo(memberAddrBean);
	}

	public void deleteAddress(AddressBean memberAddrBean) {
		addressMapper.deleteAddress(memberAddrBean);
	}

	public List<AddressBean> getAddrById(String code) {
		return addressMapper.getAddrById(code);
	}

	public AddressBean getAddrByAddrId(String address_id) {
		return addressMapper.getAddrByAddrId(address_id);
	}

}
