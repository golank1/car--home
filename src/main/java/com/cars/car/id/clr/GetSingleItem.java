package com.cars.car.id.clr;


import com.cars.car.id.beans.Car;
import com.cars.car.id.util.TablePrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Order(1)
@RequiredArgsConstructor

public class GetSingleItem implements CommandLineRunner {

    private final RestTemplate restTemplate;
    private final String url ="https://data.gov.il/api/3/action/datastore_search?resource_id=053cea08-09bc-40ec-8f7a-156f0677aff3&q=4186473";
    private final ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {
        String data = restTemplate.getForObject(url,String.class);
        System.out.println(data);
        String record = new JSONObject(data)
                .getJSONObject("result")
                .getJSONArray("records")
                .get(0)
                .toString();
        System.out.println(record);
        Car single = objectMapper.readValue(record,Car.class);
        TablePrinter.print(single);
    }
}
