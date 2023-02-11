package service;


import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Repository.CustomerRepository;
import model.Customer;
import utils.ApacheCommonsCsvUtil;



@Service
public class CsvFileServices {
	
	@Autowired
	CustomerRepository customerRepository;

	
	public void store(InputStream file) {
		try {
			
			List<Customer> lstCustomers = ApacheCommonsCsvUtil.parseCsvFile(file);
			
			
			customerRepository.saveAll(lstCustomers);
		} catch(Exception e) {
			throw new RuntimeException("FAIL! -> message = " + e.getMessage());
		}
	}
	
	
    public void loadFile(Writer writer) throws IOException {
    	try {
        	List<Customer> customers = (List<Customer>) customerRepository.findAll();
        	
        	
             ApacheCommonsCsvUtil.customersToCsv(writer, customers);
        	
        		
    	} catch(Exception e) {
    		throw new RuntimeException("Fail! -> Message = " + e.getMessage());
    	}
    }
}

