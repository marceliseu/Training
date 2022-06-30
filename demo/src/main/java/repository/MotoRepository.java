package repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.example.model.Moto;

public interface MotoRepository extends MongoRepository<Moto, String> {

}
