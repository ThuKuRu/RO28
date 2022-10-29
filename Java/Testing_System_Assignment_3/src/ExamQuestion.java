package src;

public class ExamQuestion {
    Exam            examID;

    Question        questionID;

    @Override
    public String toString() {
        return "ExamQuestion{" +
                "examID=" + examID +
                ", questionID=" + questionID +
                '}';
    }
}
