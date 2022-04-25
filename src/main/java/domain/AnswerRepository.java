package domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
	List<Answer> findByQuestion(Long questionid);

	Answer findById(long i);
	
}
