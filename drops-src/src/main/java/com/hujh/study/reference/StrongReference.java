package com.hujh.study.reference;

import java.util.ArrayList;
import java.util.List;

/**
 * 强引用 
以前我们使用的大部分引用实际上都是强引用，这是使用最普遍的引用。
如果一个对象具有强引用，那就类似于必不可少的生活用品，垃圾回收器绝不会回收它。
当内存空 间不足，Java虚拟机宁愿抛出OutOfMemoryError错误，使程序异常终止，
也不会靠随意回收具有强引用的对象来解决内存不足问题
 */
public class StrongReference {

	// 平时用的都是强引用
	public static void main(String[] args) {
		String str = "abc";
		List<String> list = new ArrayList<String>();
		list.add(str);
	}
}
