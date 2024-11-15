package com.tele.infra.dreams;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DreamsController {
	
	@RequestMapping(value="/v1/infra/dreams/dreamsUsrView")
	public String dreamsUsrView() {
		return "/usr/v1/infra/dreams/dreamsUsrView";
	}

}
