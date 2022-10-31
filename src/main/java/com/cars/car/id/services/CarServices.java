package com.cars.car.id.services;

import com.cars.car.id.beans.Car;
import com.cars.car.id.exception.NotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CarServices {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final String url = "https://data.gov.il/api/3/action/datastore_search?resource_id=053cea08-09bc-40ec-8f7a-156f0677aff3&q=";
    private final List<Car>results;

    public List<Car> getByPlateId(long number) throws JsonProcessingException, NotFoundException {
        results.clear();
        if (number>99999999){
            throw new NotFoundException("wrong car number");
        }
        String data = restTemplate.getForObject(url+number,String.class);
        JSONArray records = new JSONObject(data).getJSONObject("result").getJSONArray("records");
        for (Object item: records){
            results.add(objectMapper.readValue(item.toString(),Car.class));
        }
        if (results.isEmpty()){
            throw new NotFoundException("The car was not found");
        }
        return results;
    }
}
