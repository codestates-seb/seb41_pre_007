//package com.pre007.server.tag.service;
//
//import com.pre007.server.exception.BusinessLogicException;
//import com.pre007.server.exception.ExceptionCode;
//import com.pre007.server.question.service.QuestionService;
//import com.pre007.server.question.entity.QuestionTag;
//import com.pre007.server.question.repository.QuestionTagRepository;
//import com.pre007.server.tag.entity.Tag;
//import com.pre007.server.tag.repository.TagRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@AllArgsConstructor
//@Transactional
//@Service
//public class TagServiceImpl implements TagService {
//    private final TagRepository tagRepository;
//    private final QuestionService questionService;
//    private final QuestionTagRepository questionTagRepository;
//
//    @Override
//    public List<Tag> createTag(List<String> tags, Long questionId) {
//        List<Tag> returnTag = new ArrayList<>();
//        for (String t : tags) {
//            Optional<Tag> optionalTag = tagRepository.findByTagName(t);
//            if (optionalTag.isEmpty()) {
//                Tag tag = new Tag();
//                tag.setTagName(t);
//                tagRepository.save(tag);
//            }
//
//            returnTag.add(findTag(t));
//            QuestionTag questionTag = new QuestionTag();
//            questionTag.setQuestion(questionService.findQuestion(questionId));
//            questionTag.setTag(findTag(t));
//            questionService.findQuestion(questionId).setQuestionTags(questionTag);
//            findTag(t).setQuestionTags(questionTag);
//
//            questionTagRepository.save(questionTag);
//        }
//
//        return returnTag;
//    }
//
//    @Override
//    public Tag findTag(long tagId) {
//        return findVerifiedTag(tagId);
//    }
//
//    @Override
//    public Tag findTag(String tagName) {
//        return findVerifiedTag(tagName);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Tag findVerifiedTag(long tagId) {
//        Optional<Tag> optionalTag = tagRepository.findById(tagId);
//        return optionalTag.orElseThrow(() ->
//                new BusinessLogicException(ExceptionCode.TAG_NOT_FOUND));
//    }
//
//    @Override
//    public Tag findVerifiedTag(String tagName) {
//        Optional<Tag> optionalTag = tagRepository.findByTagName(tagName);
//        return optionalTag.orElseThrow(() ->
//                new BusinessLogicException(ExceptionCode.TAG_NOT_FOUND));
//    }
//}
