package com.cp.demo;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RequestController {
	@Autowired
	private MemberService memService;
	@Autowired
	private RequestService reqService;
	
	@PostMapping("/request")
	public String addRequest(@Validated RequestClone reqClone, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println("Saving a request was fail");
			return "redirect:/request";
		}
		Request request = new Request();
		request.setMember(memService.findMemberById(Session.memId));
		System.out.println(memService.findMemberById(Session.memId).getFname());
		request.setStatus(reqService.findStatusById(1));
		System.out.println(reqService.findStatusById(1).getDescription());
		request.setMoney(reqClone.getMoney());
		System.out.println(reqClone.getMoney());
		request.setRequestType(reqService.findReqTypeById(reqClone.getReqTypeId()));
		System.out.println(reqService.findReqTypeById(reqClone.getReqTypeId()).getDescription());
		request.setDateSend(new Date());
		reqService.saveRequest(request);
		return "redirect:/";
	}
}
