package com.tele.infra.act;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActController {
	
	@Autowired
	ActService actService;
	
	@RequestMapping(value="/v1/infra/act/actUsrView")
	public String actUsrView() {
		return "/usr/v1/infra/act/actUsrView";
	}
}
