public class Student {
    private String id;
    private String name;
    private int grade;
    private int subjectNum;
    private GradeCard gradeCard;

    public Student(String id, String name, int grade, int subjectNum) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.subjectNum = subjectNum;
    }

    public void setGradeCard(GradeCard gradeCard) {
        this.gradeCard = gradeCard;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    public GradeCard getGradeCard() {
        return gradeCard;
    }
}
