package com.tele.infra.comm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommController {
	
	@Autowired
	CommService commService;
	
	@RequestMapping(value="/v1/infra/comm/commUsrList")
	public String commUsrView(Model model) {
		List<CommDto> comm = commService.selectList();
		model.addAttribute("list" , comm);
		return "usr/v1/infra/comm/commUsrList";
	}
	
}
