package id.goindonesia.area.indonesia;

import id.goindonesia.area.indonesia.repositories.ProvinceCrudRepository;
import id.goindonesia.area.indonesia.setup.DataImport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AreaIndonesiaApplication {

    @Autowired
    private DataImport dataImport;

    public static void main(String[] args) {
        SpringApplication.run(AreaIndonesiaApplication.class, args);
    }

    @Bean
    CommandLineRunner init(final ProvinceCrudRepository provinceCrudRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                dataImport.start();
            }
        };

    }
}
