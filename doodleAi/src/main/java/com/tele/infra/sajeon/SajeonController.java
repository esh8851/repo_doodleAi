package com.tele.infra.sajeon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SajeonController {
	
	@RequestMapping(value="/v1/infra/sajeon/sajeonUsrView")
	public String sajeonUsrView() {
		return "/usr/v1/infra/sajeon/sajeonUsrView";
	}

}
