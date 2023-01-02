package com.ducktem.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.ducktem.web.service.BuyService;

@Controller
public class BuyController {

	@Autowired
	private BuyService buyService;
	
//	판매자가 보내는 후기 요청, 구매 완료 버튼
	@PostMapping("regBuy")
	public void regBuy(Long productId, String clientId) {
		
		buyService.save(clientId,productId);
	}
	
}
