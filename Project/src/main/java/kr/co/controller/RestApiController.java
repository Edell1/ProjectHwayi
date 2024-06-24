package kr.co.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.beans.AddressBean;
import kr.co.beans.UserBean;
import kr.co.service.AddressService;

@RestController
public class RestApiController {

	@Autowired
	private AddressService addressService;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	@GetMapping("/address/getAddress/{address_id}")
	public AddressBean getAddress(@PathVariable String address_id) {
		AddressBean addrList = addressService.getAddrByAddrId(address_id);
		return addrList;
	}

}