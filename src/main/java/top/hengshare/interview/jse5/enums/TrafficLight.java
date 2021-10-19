package top.hengshare.interview.jse5.enums;

/**
 * @program: Java-Interview
 * @description: TrafficLight
 * @author: StivenYang
 * @create: 2019-11-21 16:27
 **/
public class TrafficLight {
	Signal color = Signal.RED;

	public void change() {
		switch (color) {
			case RED:
				color = Signal.GREEN;
				break;
			case GREEN:
				color = Signal.YELLOW;
				break;
			case YELLOW:
				color = Signal.RED;
				break;
		}
	}

	@Override
	public String toString() {
		return "当前颜色是：" + this.color;
	}

	public static void main(String[] args) {
		TrafficLight trafficLight = new TrafficLight();
		for (int i = 0; i < 7; i++) {
			System.out.println(trafficLight);
			trafficLight.change();
		}
	}
}

enum Signal {
	GREEN, YELLOW, RED;
}
