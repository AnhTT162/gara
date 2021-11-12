package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.RevenueMonthStatistics;
import com.example.demo.repository.BillProvisionalRepository;

@Controller
@RequestMapping()
public class ManagerController {
	@Autowired
	private BillProvisionalRepository bill;
	
	@GetMapping("/thongkedoanhthu")
	public String thongkedoanhthu(ModelMap model,HttpSession session) {
		if(session.getAttribute("USER") == null) {
		model.addAttribute("checkLogin","Hết phiên làm việc!!!");
		return "login";
	}
		Calendar time = Calendar.getInstance();
		int month = time.get(Calendar.MONTH)+1;
		int year = time.get(Calendar.YEAR);
		String thangnam = year + "-" + month;
		List<RevenueMonthStatistics> listRevenueMonth = getListRevenueMonth(month);
		model.addAttribute("listRevenueMonth", listRevenueMonth);
		
		return "gdThongkedoanhthu";
	}
	private List<RevenueMonthStatistics> getListRevenueMonth(int month) {
		List<RevenueMonthStatistics> listRevenueMonth = new ArrayList<>();
		Calendar time = Calendar.getInstance();
		int year = time.get(Calendar.YEAR);
		for(int i=0; i<=11; i++) {
			String thangnam = "";
			Float tongtien = (float) 0;
			if(month - i >= 1) {
				 thangnam = (month - i) + "-" + year;
				 tongtien = bill.findTotalMoneyByMonth(month-i, year);
				 
			}else {
				 thangnam = (month - i + 12) + "-" + (year - 1); 
				 tongtien = bill.findTotalMoneyByMonth(month-i+12, year-1);

			}
			if(tongtien == null) {
				tongtien = (float) 0;
			}
			listRevenueMonth.add(new RevenueMonthStatistics(thangnam, tongtien));
		}
			
		return listRevenueMonth;


		
	}
}
