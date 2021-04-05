package edu.citytech.cst.s23253396.abccounter;

import com.google.gson.Gson;
import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.cst.s23253396.abccounter.models.CustomerPurchase;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class GetDataTest {

    @Test
    public void getData() {
        String url = "http://localhost:9215/api/reports/2013/11/Monday/500,1000/A";
        var json = JSONGet.submitGet(url, Map.class);
        var data = (List) json.get("row.data");

        Gson gson = new Gson();

        // Variables used in lambdas must be final.
        var totalPrice = new Object() {
            double totalPrice = 0d;
        };

        data.forEach((object) -> {
            CustomerPurchase customer = gson.fromJson(object.toString(), CustomerPurchase.class);
            System.out.println(customer.toString());
            // An workaround for final variable with lambdas.
            totalPrice.totalPrice += customer.getTotalPrice();
        });

        System.out.println(totalPrice.totalPrice);
    }













}
