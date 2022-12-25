package com.pre007.server;

import com.pre007.server.dtoUtils.SingleResponseDto;
import com.pre007.server.question.entity.Question;
import com.pre007.server.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {
    private final QuestionRepository questionRepository;

    @GetMapping("/")
    public ResponseEntity home(@RequestParam String sort) {
        List<Question> all = questionRepository.findAll();
        all.sort(sortQuestions(sort));
        if (all.size() <= 10) {
            return new ResponseEntity(new SingleResponseDto<>(all), HttpStatus.OK);
        }

        List<Question> questions = all.subList(0, 10);

        return new ResponseEntity(new SingleResponseDto<>(questions), HttpStatus.OK);
    }

    public static Comparator<Question> sortQuestions(String sort) {
        if (!sort.isEmpty()) {
            switch (sort) {
                case "votes":
                    return (o1, o2) -> o2.getTotalVotes() - o1.getTotalVotes();
                case "answers":
                    return ((o1, o2) -> o2.getAnswers().size() - o1.getAnswers().size());
                case "newest":
                    return ((o1, o2) -> Long.compare(o2.getQuestionId(), o1.getQuestionId()));
            }
        }
        return ((o1, o2) -> Long.compare(o2.getQuestionId(), o1.getQuestionId()));
    }
}
