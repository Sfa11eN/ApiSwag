package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FacultyService {
    private Map<Long, Faculty> facultyMap = new HashMap<>();
    private long idCounter = 1;

    public Faculty addFaculty(String name, String color) {
        Faculty faculty = new Faculty(idCounter++, name, color);
        facultyMap.put(faculty.getId(), faculty);
        return faculty;
    }

    public List<Faculty> getAllFaculties() {
        return facultyMap.values().stream().collect(Collectors.toList());
    }

    public Faculty getFaculty(Long id) {
        return facultyMap.get(id);
    }

    public Faculty updateFaculty(Long id, String name, String color) {
        Faculty faculty = facultyMap.get(id);
        if (faculty != null) {
            faculty.setName(name);
            faculty.setColor(color);
            return faculty;
        }
        return null;
    }

    public void deleteFaculty(Long id) {
        facultyMap.remove(id);
    }

    public List<Faculty> filterFacultiesByColor(String color) {
        return facultyMap.values().stream()
                .filter(faculty -> faculty.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }
}