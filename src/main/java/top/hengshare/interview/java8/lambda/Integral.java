package top.hengshare.interview.java8.lambda;

import java.util.function.DoubleFunction;

public class Integral {
	public static void main(String[] args) {
		//1. 对线性方程y=x+10求积分，函数调用的时候是这样 g(f, a, b)，其中，a和b是积分的上下区间
		//f的描述符应该是double->double，符合的有DoubleFunction<Double>接口
		double result = Integral.integral((double x) -> x + 10, 3, 7);
		System.out.println(result);
	}

	//2. 完成函数的定义
	public static double integral(DoubleFunction<Double> f, double a, double b) {
		//上底加下底乘高除以2是梯形的面积
		return (f.apply(a) + f.apply(b)) * (b - a) / 2.0;
	}
}
