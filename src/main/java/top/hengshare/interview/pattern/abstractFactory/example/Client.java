package top.hengshare.interview.pattern.abstractFactory.example;

public class Client {
	public static void main(String[] args) {
		ComputerEngineer engineer = new ComputerEngineer();
		Schema1 schema1 = new Schema1();
		engineer.makeComputer(schema1);

		Schema2 schema2 = new Schema2();
		engineer.makeComputer(schema2);
	}
}
