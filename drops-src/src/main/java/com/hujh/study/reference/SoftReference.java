package com.hujh.study.reference;

public class SoftReference {

	/**
	 * 如果一个对象只具有软引用，那就类似于可有可物的生活用品。如果内存空间足够，
	 * 垃圾回收器就不会回收它，如果内存空间不足了，就会回收这些对象的内存。
	 * 只要垃圾回收器没有回收它，该对象就可以被程序使用。
	 * 软引用可用来实现内存敏感的高速缓存。
	 * 软引用可以和一个引用队列（ReferenceQueue）联合使用，
	 * 如果软引用所引用的对象被垃圾回收，
	 * JAVA虚拟机就会把这个软引用加入到与之关联的引用队列中。
	 * 
	 * 软引用对象也比较好理解，它是一个比较特殊的存在，拥有强引用的属性，又更加安全。
	 * 如果有一个对象具有软引用。在内存空间足够的情况下，除非内存空间接近临界值、
	 * jvm即将抛出oom的时候，垃圾回收器才会将该引用对象进行回收，
	 * 避免了系统内存溢出的情况。（前提也是对象指向不为空）
	 * 因此，SoftReference 引用对象非常适合实现内存敏感的缓存，
	 * 例如加载图片的时候，bitmap缓存机制

	 * @param args
	 */
	public static void main(String[] args) {
		/**
		System.out.println("开始");
		A a = new A();
		SoftReference<A> sr = new SoftReference<A>(a);
		a = null;
		if (sr != null) {
			a = sr.get();
		} else {
			a = new A();
			sr = new SoftReference<A>(a);
		}
		System.out.println("结束");
		**/
	}

	class A {
		int[] a;

		public A() {
			a = new int[100000000];
		}
	}

}
