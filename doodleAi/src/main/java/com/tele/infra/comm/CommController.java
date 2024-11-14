package com.tele.infra.comm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommController {
	
	@Autowired
	CommService commService;
	
	@RequestMapping(value="/v1/infra/comm/commUsrView")
	public String commUsrView() {
		return "/usr/v1/infra/comm/commUsrView";
	}
	
}
