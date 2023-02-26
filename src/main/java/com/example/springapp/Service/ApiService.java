package com.example.springapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.springapp.Model.ApiModel;
import com.example.springapp.Repository.ApiRepo;





@Service
public class ApiService {
		@Autowired
		ApiRepo r;
		
		public String add(ApiModel m) {
			r.save(m);
			return "Added";
		}
		
		public List<ApiModel> getDetails() {
			return r.findAll();
		}
		
		public List<ApiModel> getSorted(String field) {
			return r.findAll(Sort.by(Sort.Direction.ASC,field));
		}
		
		public List<ApiModel> getWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
			Page<ApiModel> page =r.findAll(PageRequest.of(offset, pageSize));
			return page.getContent();
		}

}
