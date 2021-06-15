package com.example.demo.controllers;

import com.example.demo.models.CustomerTrx;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService service;

    @GetMapping(value="/")
    public ResponseEntity<List<CustomerTrx>> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<CustomerTrx> list = service.getAllCustRecord(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<CustomerTrx>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value="/custId")
    public ResponseEntity<List<CustomerTrx>> byCustId(
            @RequestParam String custId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<CustomerTrx> list = service.getAllCustByCustId(custId, pageNo, pageSize, sortBy);

        return new ResponseEntity<List<CustomerTrx>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value="/accNo")
    public ResponseEntity<List<CustomerTrx>> byAccNo(
            @RequestParam String accNo,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<CustomerTrx> list = service.getAllCustByAccNo(accNo, pageNo, pageSize, sortBy);

        return new ResponseEntity<List<CustomerTrx>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
