/**
 * character code map {文字コードマッピング}
 */
package com.lightspeedworks.codemap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * character code map {文字コードマッピング}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class CodeMapAllTests {
	static final int MAX_LOOP_COUNT = 0x10ffff; //0x10ffff;
	static final int MAX_TEST_COUNT = 20;

	/**
	 * main
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		ICodeMap[] maps = {
				new CodeMap(),
				new CodeMap31(),
				new CodeMap3(),
				new CodeMap42(),
				new CodeMap4(),
				new CodeMap2(),
				new CodeMap8(),
				new CodeMapT4<Integer>(),
				new CodeMapArrayList(),
				new CodeMapArrayList(0x10000),
				new CodeMapL<ArrayList<Integer>>(new ArrayList<Integer>()),
				new CodeMapL<ArrayList<Integer>>(
						new ArrayList<Integer>(0x10000)),
				new CodeMapHashMap(),
				new CodeMapM<HashMap<Integer, Integer>>(
						new HashMap<Integer, Integer>()),
				new CodeMapM<TreeMap<Integer, Integer>>(
						new TreeMap<Integer, Integer>()) };
		String[] titles = {
				"CodeMap",
				"CodeMap31",
				"CodeMap3",
				"CodeMap42",
				"CodeMap4",
				"CodeMap2",
				"CodeMap8",
				"CodeMapT<Integer>",
				"CodeMapArrayList",
				"CodeMapArrayList(0x10000)",
				"CodeMapL<ArrayList<Integer>>",
				"CodeMapL<ArrayList<Integer>>(0x10000)",
				"CodeMapHashMap",
				"CodeMapM<HashMap<Integer, Integer>>",
				"CodeMapM<TreeMap<Integer, Integer>>" };
		int loopCounts[] = { MAX_LOOP_COUNT, MAX_LOOP_COUNT, MAX_LOOP_COUNT,
				MAX_LOOP_COUNT, MAX_LOOP_COUNT, MAX_LOOP_COUNT, MAX_LOOP_COUNT,
				MAX_LOOP_COUNT, MAX_LOOP_COUNT, MAX_LOOP_COUNT, MAX_LOOP_COUNT,
				MAX_LOOP_COUNT, MAX_LOOP_COUNT, MAX_LOOP_COUNT, MAX_LOOP_COUNT };
		boolean enables[] = { true, true, true, true, true, false, false, false,
				false, false, false, false, false, false, false };

		System.out.println(maps.length);
		System.out.println(titles.length);
		System.out.println(loopCounts.length);
		System.out.println(enables.length);

		// for (int i = 0; i < enables.length; ++i)
		// enables[i] = true;

		int no = 0;

		for (int i = 0; i < maps.length; ++i)
			if (enables[i]) {
				System.out.print((++no) + " @" + i + ": ");
				test(maps[i], titles[i], loopCounts[i]);
				System.out.print((++no) + " @" + i + ": ");
				test(maps[i], titles[i], loopCounts[i]);
				System.out.print((++no) + " @" + i + ": ");
				test(maps[i], titles[i], loopCounts[i]);
			}

		for (int i = 0; i < maps.length; ++i)
			if (enables[i]) {
				System.out.print((++no) + " @" + i + ": ");
				test(maps[i], titles[i], loopCounts[i]);
				System.out.print((++no) + " @" + i + ": ");
				test(maps[i], titles[i], loopCounts[i]);
				System.out.print((++no) + " @" + i + ": ");
				test(maps[i], titles[i], loopCounts[i]);
			}

		System.out.println("### end ###");
	}

	public static void test(ICodeMap map, String title, int loopCount) {
		// System.out.println("======================================================================");
		System.out
				.print(String.format("### %s ### (0x%x) ", title, loopCount));
		int n;
		n = map.get(0);
		// System.out.println("[0] = " + n);
		map.set(0, 0);
		n = map.get(0);
		// System.out.println("[0] = " + n);
		map.set(0, n);
		map.clear();

		long sum = 0;
		long minTime = Long.MAX_VALUE;
		long maxTime = 0;

		for (int k = 1; k <= MAX_TEST_COUNT; ++k) {
			long startTime = System.currentTimeMillis();

			for (int i = 0; i <= loopCount; ++i)
				map.set(i, i);
			for (int i = 0; i <= loopCount; ++i)
				if (i != map.get(i))
					throw new Error("WRONG DATA " + i);

			for (int i = loopCount; i >= 0; --i)
				map.set(i, i);
			for (int i = loopCount; i >= 0; --i)
				if (i != map.get(i))
					throw new Error("WRONG DATA " + i);

			map.clear();

			for (int i = loopCount; i >= 0; --i)
				map.set(i, i);
			for (int i = loopCount; i >= 0; --i)
				if (i != map.get(i))
					throw new Error("WRONG DATA " + i);

			long deltaTime = System.currentTimeMillis() - startTime;
			if (minTime > deltaTime)
				minTime = deltaTime;
			if (maxTime < deltaTime)
				maxTime = deltaTime;
			sum += deltaTime;
			// System.out.println(String.format("%2d: %6.3f", k,
			// deltaTime / 1000.0));
		}
		//System.out.println("----------------------------------------------------------------------");
		System.out.print(String.format("avg %7.4f", sum / 1000.0
				/ MAX_TEST_COUNT));
		System.out.print(String.format("  min %6.3f", minTime / 1000.0));
		System.out.println(String.format("  max %6.3f", maxTime / 1000.0));
		//System.out.println("======================================================================");

		map.clear();
		System.gc();
	}
}
