import java.util.Scanner;
public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Here I assume Number of subjects are 5
        int subjects = 5;  
        int[] marks = new int[subjects];
        // Input marks for each subject out of 100
        for (int i = 0; i < subjects; i++) {
            int mark;
            //until a valid mark (0-100) is entered the user shows prompting
            do {
                System.out.print("Enter marks (out of 100) for subject " + (i + 1) + ": ");
                mark = scanner.nextInt();
                
                if (mark < 0 || mark > 100) {
                    System.out.println("Invalid input! Marks should be between 0 and 100.");
                }
            } 
            // Continue asking until a valid mark is entered
            while (mark < 0 || mark > 100);  
            // Store the valid mark
            marks[i] = mark;  
        }
        // Calculate total marks
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        // Calculate average percentage
        double average = (double) totalMarks / subjects;
        // Assign grade based on average
        char grade;
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        // Display results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + average + "%");
        System.out.println("Grade: " + grade);
    }
}
