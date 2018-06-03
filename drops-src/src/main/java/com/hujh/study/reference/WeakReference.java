package com.hujh.study.reference;

public class WeakReference {

	/**
	 * 如果一个对象只具有弱引用，那就类似于可有可物的生活用品。弱引用与软引用的区别在于：只具有弱引用的对象拥有更短暂的生命周期。在垃圾回收器线程扫描它
	 * 所管辖的内存区域的过程中，一旦发现了只具有弱引用的对象，不管当前内存空间足够与否，都会回收它的内存。不过，由于垃圾回收器是一个优先级很低的线程，
	 * 因此不一定会很快发现那些只具有弱引用的对象。
	 * 弱引用可以和一个引用队列（ReferenceQueue）联合使用，如果弱引用所引用的对象被垃圾回收，Java虚拟机就会把这个弱引用加入到与之关联的引用队列中。
	 */

	// Object c = new Car(); //只要c还指向car object, car object就不会被回收
	// WeakReference<Car> weakCar = new WeakReference(Car)(car);

	public static void main(String[] args) {

		/**
		Car car = new Car(22000, "silver");
		WeakReference<Car> weakCar = new WeakReference<Car>(car);

		int i = 0;

		while (true) {
			if (weakCar.get() != null) {
				i++;
				System.out.println("Object is alive for " + i + " loops - " + weakCar);
			} else {
				System.out.println("Object has been collected.");
				break;
			}
		}
		**/
	}

}
