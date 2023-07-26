package com.amaris.employees.repository.impl;

import com.amaris.employees.models.Employee;
import com.amaris.employees.models.ListResponse;
import com.amaris.employees.models.Response;
import com.amaris.employees.repository.ApiRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public abstract class BaseApiRepository<T> implements ApiRepository<T> {

    private final RestTemplate restTemplate;
    private final String baseUrl;

    protected BaseApiRepository(RestTemplate restTemplate, String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    protected Employee getForObject(String endpoint) {
        ResponseEntity<Response<Employee>> response = restTemplate.exchange(
                baseUrl + endpoint,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Response<Employee>>() {
                }
        );
        return response.getBody().getData();
    }

    protected List<Employee> getForList(String endpoint) {
        ResponseEntity<ListResponse<Employee>> response = restTemplate.exchange(
                baseUrl + endpoint,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ListResponse<Employee>>() {
                }
        );
        return response.getBody().getData();
    }
}