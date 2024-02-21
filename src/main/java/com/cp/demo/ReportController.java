package com.cp.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReportController {
	@Autowired
	private MemberService memService;
	@Autowired
	private OfficerService offService;
	@Autowired
	private RequestService reqService;
	@Autowired
	private RecordTransactionService recService;
	
	@GetMapping("/approve/{id}")
	public String approveRequest(@PathVariable("id") int id, Model model) {
		Request request = reqService.findRequestById(id);
		request.setStatus(reqService.findStatusById(2));
		request.setOfficer(offService.findOfficerById(Session.offId));
		request.setDateRes(new Date());
		int reqtId = request.getRequestType().getReqtId();
		if(reqtId!=3) {
			RecordTransaction rec = new RecordTransaction();
			rec.setMember(request.getMember());
			rec.setOfficer(request.getOfficer());
			rec.setMoney(request.getMoney());
			rec.setSactionType(recService.findSactionTypeById(reqtId));
			rec.setRequest(request);
			rec.setDate(new Date());
			recService.saveRecord(rec);
		}
		reqService.saveRequest(request);
		return "redirect:/status";
	}
	
	@GetMapping("/notapporve/{id}")
	public String notApproveRequest(@PathVariable("id") int id, Model model) {
		Request request = reqService.findRequestById(id);
		request.setStatus(reqService.findStatusById(3));
		request.setOfficer(offService.findOfficerById(Session.offId));
		reqService.saveRequest(request);
		return "redirect:/status";
	}
}
