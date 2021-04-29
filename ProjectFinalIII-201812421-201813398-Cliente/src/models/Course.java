package models;

public class Course extends Activity{
	
	private String nameCourseTeacher;
	
	public Course(String nameCourse, String nameTeacher, String descriptionCourse, String scheduleCourse) {
		super(nameCourse, descriptionCourse, scheduleCourse);
		this.nameCourseTeacher = nameTeacher;
	}
	
	public Course(String nameCourse) {
		super(nameCourse);
	}

	public String getNameCourseTeacher() {
		return nameCourseTeacher;
	}

	public void setNameCourseTeacher(String nameCourseTeacher) {
		this.nameCourseTeacher = nameCourseTeacher;
	}
}