package com.vaadin.tutorial.crm.backend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.vaadin.tutorial.crm.backend.entity.Company;
import com.vaadin.tutorial.crm.backend.repository.CompanyRepository;

@Service
public class CompanyService {

  private CompanyRepository companyRepository;

  public CompanyService(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  public List<Company> findAll() {
    return companyRepository.findAll();
  }

  public Map<String, Integer> getStats() {
    HashMap<String, Integer> stats = new HashMap<>();
    findAll().forEach(company -> stats.put(company.getName(), company.getEmployees().size()));
    return stats;
  }

}