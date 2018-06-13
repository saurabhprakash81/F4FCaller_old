package wswrapper;

import okhttp3.*;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;



@Controller
public class WSWrapperController {
    //    @RequestMapping(value = "/ws_wrapper_post", method = {RequestMethod.POST}, consumes = {"application/json"}, produces ={"text/*", "application/*"})
    @RequestMapping(value = "/ws_wrapper_post", method = {RequestMethod.POST}, consumes = {"*/*"}, produces = {"*/*"})
    @ResponseBody
    public String wsWrapperPOST(@RequestBody String jsonStr) {
        String url = "https://ewsoat.us.f4f.com/api-json/PriceSheetRequestPush";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject( url, jsonStr, String.class);
        //JSONObject jsonObj = new JSONObject(result);
        //String balance = jsonObj.get("data").toString();
        System.out.println("Respone from F4F " + result);
        return result;
    }




}

