package tri.dev.restful_cam.controllers;

import tri.dev.restful_cam.model.*;
import tri.dev.restful_cam.repository.*;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class infoGatheredController {

    private final infoGatheredRepository repository;

    public infoGatheredController(infoGatheredRepository repository) {
        this.repository = repository;
    }
    
    // GET http://localhost:8080/info/{special_code}
    @GetMapping
    @RequestMapping("/info/{special_code}")
    public List<infoGathered> lookup(@PathVariable String special_code) throws StreamReadException, DatabindException, IOException, InterruptedException {
        repository.reset();
        // ObjectMapper instantiation
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // This object holds all info gathered
        infoGathered info = new infoGathered();

        // This is Camera Code that we input
        String CameraCodeInput = special_code;

        // Decode config file
        //String fileName = "./config/config.json";
        //File fis = new File(fileName);

        //config configFile = objectMapper.readValue(fis, config.class);

        // API call 5_GetListCamera
        String link = "";
        //String configData[] = findConfig(objectMapper, "GetListCamera", configFile);

        // temporary
        String configData[] = {"113.161.56.137", "9091", "base-service", "72obqj0mlwdx5eeud654wfx67ggp3g2h", "y6vkztdfoo85itl48c7dx5ecibep5wvp"};
        
        link = "http://" + configData[0] + ":" + configData[1] + "/" + configData[2] + "/"; 

        HttpRequest request5 = HttpRequest.newBuilder()
            .uri(URI.create(link +"cctv_camera"))
            .header("X-Request-ID", configData[3])
            .header("X-API-Key", configData[4])
            .method("GET", HttpRequest.BodyPublishers.noBody())
            .build();
        HttpResponse<String> response5 = HttpClient.newHttpClient().send(request5, HttpResponse.BodyHandlers.ofString());

        // Deserialization into the `cameraInfo` class, 
        cameraInfo camera = objectMapper.readValue(response5.body(), cameraInfo.class);

        // Get name of the camera for multiple camera of the same code
        for (int i = 0; i < camera.getDs().size(); i++) {
            //camera.getDs().get(i).getCode().equals(CameraCodeInput)
            if (camera.getCode(i).equals(CameraCodeInput)) {
                info = new infoGathered();

                // Assign info to the info obejct
                info.setCam_Code(camera.getCode(i)); //camera.getDs().get(i).getCode()
                info.setName(camera.getName(i)); //camera.getDs().get(i).getName()
                info.setBranch_Code(camera.getBranch_Id(i));  //camera.getDs().get(i).getBranch_Id()          

                // API call 3_GetBranchByCode
                //configData = findConfig(objectMapper, "GetBranchByCode", configFile);
                link = "http://" + configData[0] + ":" + configData[1] + "/" + configData[2] + "/"; 

                HttpRequest request3 = HttpRequest.newBuilder()
                    .uri(URI.create(link + "cctv_branch?dk=%7B%22Code%22%3A%22" + info.getBranch_Code().replaceAll(" ", "") + "%22%7D"))
                    .header("X-Request-ID", configData[3])
                    .header("X-API-Key", configData[4])
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
                HttpResponse<String> response3 = HttpClient.newHttpClient().send(request3, HttpResponse.BodyHandlers.ofString());

                // Deserialization into the `branchInfo` class
                branchInfo branch = objectMapper.readValue(response3.body(), branchInfo.class);
                
                // Some branch not exist in any company, skip it
                if (branch.getDs().isEmpty()){
                    continue;
                }

                // Assign info to the info obejct
                info.setBranch_Name(branch.getName(0));
                info.setCompany_Code(branch.getCompany_Code(0));

                // API call 1_GetCompanyByCode
                //configData = findConfig(objectMapper, "GetCompanyByCode", configFile);;
                link = "http://" + configData[0] + ":" + configData[1] + "/" + configData[2] + "/"; 

                HttpRequest request1 = HttpRequest.newBuilder()
                    .uri(URI.create(link + "cctv_company?dk=%7B%22Code%22%3A%22" + info.getCompany_Code().replaceAll(" ", "") + "%22%7D"))
                    .header("X-Request-ID", configData[3])
                    .header("X-API-Key", configData[4])
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
                HttpResponse<String> response1 = HttpClient.newHttpClient().send(request1, HttpResponse.BodyHandlers.ofString());

                // Deserialization into the `companyInfo` class
                companyInfo company = objectMapper.readValue(response1.body(), companyInfo.class);

                // If we can't find the company using company code, skip it
                if (company.getDs().isEmpty()) {
                    continue;
                }
                
                // Assign info to the info obejct
                info.setCompany_Name(company.getName(0));

                repository.add(info);
            } 
        }
        return repository.returnAll();
    }

    // Function to get all information needed from the config file
    private static String[] findConfig(ObjectMapper objectMapper, String name, config configFile) throws StreamReadException, DatabindException, IOException {
        String [] result = new String[5];
        
        for (int i = 0; i < configFile.getList_servers().size(); i++) {
            if (configFile.getList_servers().get(i).getName().equals(name)) {
                result[0] = configFile.getList_servers().get(i).getServer();
                result[1] = configFile.getList_servers().get(i).getPort();
                result[2] = configFile.getList_servers().get(i).getVersion();
                result[3] = configFile.getList_servers().get(i).getRequest_ID();
                result[4] = configFile.getList_servers().get(i).getAPI_Key();
            }
        }
        return result;
    }
}

