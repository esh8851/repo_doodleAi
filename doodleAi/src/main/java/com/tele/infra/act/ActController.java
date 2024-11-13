package com.tele.infra.act;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActController {
	
	@Autowired
	ActService actService;
	
	@RequestMapping(value="/v1/infra/act/actUsrList")
	public String actUsrView() {
		return "/usr/v1/infra/act/actUsrList";
	}
	
	@RequestMapping(value="/v1/infra/act/actUsrForm")
	public String actUsrForm() {
		return "/usr/v1/infra/act/actUsrForm";
	}
	
}
