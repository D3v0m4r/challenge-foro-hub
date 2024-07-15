package com.example.foro.hub.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectModel> registerSubject(@RequestBody SubjectModel request) {
        SubjectModel subjectModel = subjectService.registerSubject(request);
        return ResponseEntity.ok(subjectModel);
    }

    @GetMapping
    public ResponseEntity<List<SubjectModel>> listSubjects() {
        List<SubjectModel> subjects = subjectService.listSubjects();
        return ResponseEntity.ok(subjects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectModel> getSubject(@PathVariable Long id) {
        return subjectService.getSubject(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectModel> updateSubject(@PathVariable Long id, @RequestBody SubjectModel request) {
        return Optional.ofNullable(subjectService.updateSubject(id, request))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteSubject(@PathVariable Long id) {
        boolean deleted = subjectService.deleteSubject(id);
        if (deleted) {
            return ResponseEntity.ok(id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
