package com.example.foro.hub.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public SubjectModel registerSubject(SubjectModel request) {
        return subjectRepository.save(request);
    }

    public List<SubjectModel> listSubjects() {
        return subjectRepository.findAll();
    }

    public Optional<SubjectModel> getSubject(Long id) {
        return subjectRepository.findById(id);
    }

    public SubjectModel updateSubject(Long id, SubjectModel request) {
        return subjectRepository.findById(id)
                .map(subjectModel -> updateExistingSubject(subjectModel, request))
                .orElseThrow(() -> new RuntimeException("Subject not found"));
    }

    public Boolean deleteSubject(Long id) {
        if (subjectRepository.existsById(id)) {
            subjectRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private SubjectModel updateExistingSubject(SubjectModel subjectModel, SubjectModel request) {
        subjectModel.setUser_id(request.getUser_id());
        subjectModel.setCourse(request.getCourse());
        subjectModel.setTitle(request.getTitle());
        subjectModel.setMessage(request.getMessage());
        return subjectRepository.save(subjectModel);
    }
}
