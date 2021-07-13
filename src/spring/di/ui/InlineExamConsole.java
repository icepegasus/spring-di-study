package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component("console")
public class InlineExamConsole implements ExamConsole {
	
	@Autowired //required false 이면 생성된 Bean이 없어도 처리됨(할당안되는 식으로)
	//@Qualifier("exam2")
	private Exam exam;	//여기에 @Autowired 오려면 기본생성자 꼭 있어야함
	
	public InlineExamConsole() {
		System.out.println("constructor");
	} 
	
	public InlineExamConsole(Exam exam) {
		System.out.println("overloeaded constructor");
		this.exam = exam;
	}
	
	public void setExam(Exam exam) {
		System.out.println("setter");
		this.exam = exam;
	}
	
	@Override
	public void print() {
		if(this.exam == null)
			System.out.printf("total is %d, avg is %f\n", 0, 0.0);
		else
			System.out.printf("total is %d, avg is %f\n", exam.total(),exam.avg());
	}

}
