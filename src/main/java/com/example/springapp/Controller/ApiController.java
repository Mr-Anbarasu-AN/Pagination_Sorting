package com.example.springapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.Model.ApiModel;
import com.example.springapp.Service.ApiService;

@RestController
public class ApiController {
	

		@Autowired
		ApiService s;

		@GetMapping("/showDetails")
		public List<ApiModel> showDetails() {
			return s.getDetails();

		}

		@PostMapping("/addDetails")
		public String addDetails(@RequestBody ApiModel m) {
			s.add(m);
			return "Added product " + m.getId();
		}

		//sorting
		@GetMapping("/sort/{field}")
		public List<ApiModel> getWithSort(@PathVariable String field) {
			return s.getSorted(field);
		}

		// pagination
		@GetMapping("/page/{offset}/{pageSize}")
		public List<ApiModel> productsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
			return s.getWithPagination(offset, pageSize);
		}
}