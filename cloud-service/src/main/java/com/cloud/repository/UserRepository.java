package com.cloud.repository;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.cloud.model.User;

public interface UserRepository extends MongoRepository<User, ObjectId> {
	
	List<User> findByLevel(Integer age);
	
	List<User> findByCodeLike(String code);
}
