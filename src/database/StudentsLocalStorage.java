package database;

import XMLParsing.StudentsXMLReader;
import XMLParsing.StudentsXMLWriter;
import models.Student;
import selections.StudentsSelection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StudentsLocalStorage {
    private List<Student> records = new ArrayList<>();
    private File sourceFile;

    public StudentsLocalStorage() {}

    public StudentsLocalStorage setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
        return this;
    }

    public void readAll() {
        records = new StudentsXMLReader(sourceFile).readAll();
        if (records == null) {
            records = new ArrayList<>();
        }
    }

    public void saveAll() {
        new StudentsXMLWriter(sourceFile).writeAll(records);
    }

    public List<Student> getRecords() {
        return new ArrayList<>(records);
    }

    public void setRecords(List<Student> students) {
        this.records = students;
    }

    public void addRecord(Student student) {
        records.add(student);
    }

    public List<Student> applyFilters(Student student){
        StudentsSelection selection = new StudentsSelection();

        return selection.suitableStudents(student, this.records);
    }
}
