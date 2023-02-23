package vesseltracker;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vesseltracker.model.Vessel;
import vesseltracker.service.VesselService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    CommandLineRunner runner(VesselService vesselService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            TypeReference<List<Vessel>> typeReference = new TypeReference<List<Vessel>>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream("/TestData.json");
            try {
                List<Vessel> vessels = mapper.readValue(inputStream, typeReference);
                vesselService.createListVessel(vessels);
                System.out.println("Users Saved!");
            } catch (IOException e) {
                System.out.println("Unable to save vessels: " + e.getMessage());
            }
        };
    }

}
