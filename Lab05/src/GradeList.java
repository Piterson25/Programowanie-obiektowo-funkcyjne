import java.util.ArrayList;

public class GradeList {
    private final ArrayList<Double> grades = new ArrayList<>();

    public GradeList() {}

    public void addGrade(double grade) {
        this.grades.add(grade);
    }

    public double average() {
        double sum = 0.0;
        if (!this.grades.isEmpty()) {
            for (Double grade: this.grades) {
                sum += grade;
            }
            return sum / this.grades.size();
        }
        return sum;
    }

    public double max() {
        double maxValue = 0.0;
        if (!this.grades.isEmpty()) {
            for (Double grade : this.grades) {
                if (grade > maxValue) {
                    maxValue = grade;
                }
            }
        }
        return maxValue;
    }

    public double min() {
        if (!this.grades.isEmpty()) {
            double minValue = this.grades.get(0);
            for (Double grade : this.grades) {
                if (grade < minValue) {
                    minValue = grade;
                }
            }
            return minValue;
        }
        return 0.0;
    }
}
