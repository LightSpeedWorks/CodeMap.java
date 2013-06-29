/**
 * character code map {文字コードマッピング}
 */
package com.lightspeedworks.codemap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * character code map. {文字コードマッピング}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class CodeMapAllTests {
	/**
	 * max loop count.
	 */
	static final int MAX_LOOP_COUNT = 0x110000; // 0x10ffff + 1;
	/**
	 * max test count.
	 */
	static final int MAX_TEST_COUNT = 30;

	/**
	 * main.
	 *
	 * @param args
	 *            String...
	 */
	public static void main(final String... args) {
		final ICodeMap[] maps = { new CodeMap31(), new CodeMap3y(), new CodeMap3x(), new CodeMap3(), new CodeMap42(),
				new CodeMap4(), new CodeMap2(), new CodeMap8(), new CodeMapT4<Integer>(), new CodeMapArrayList(),
				new CodeMapArrayList(0x100), new CodeMapL<ArrayList<Integer>>(new ArrayList<Integer>()),
				new CodeMapL<ArrayList<Integer>>(new ArrayList<Integer>(0x100)), new CodeMapHashMap(),
				new CodeMapM<HashMap<Integer, Integer>>(new HashMap<Integer, Integer>()),
				new CodeMapM<TreeMap<Integer, Integer>>(new TreeMap<Integer, Integer>()) };
		final String[] titles = { "CodeMap31", "CodeMap3y", "CodeMap3x", "CodeMap3", "CodeMap42", "CodeMap4",
				"CodeMap2", "CodeMap8", "CodeMapT<Integer>", "CodeMapArrayList", "CodeMapArrayList(0x110000)",
				"CodeMapL<ArrayList<Integer>>", "CodeMapL<ArrayList<Integer>>(0x110000)", "CodeMapHashMap",
				"CodeMapM<HashMap<Integer, Integer>>", "CodeMapM<TreeMap<Integer, Integer>>" };
		final int[] loopCounts = { MAX_LOOP_COUNT, MAX_LOOP_COUNT, MAX_LOOP_COUNT, MAX_LOOP_COUNT, MAX_LOOP_COUNT, MAX_LOOP_COUNT,
				MAX_LOOP_COUNT, MAX_LOOP_COUNT, MAX_LOOP_COUNT, MAX_LOOP_COUNT, MAX_LOOP_COUNT, MAX_LOOP_COUNT,
				MAX_LOOP_COUNT, MAX_LOOP_COUNT, MAX_LOOP_COUNT, MAX_LOOP_COUNT };
		final boolean[] enables = { true, true, true, false, true, false, false, false, false, false, false, false, false,
				false, false, false };

		if (maps.length != titles.length || maps.length != loopCounts.length || maps.length != enables.length)
			throw new Error("配列の要素数が一致しません!!!");

		int no = 0;

		for (int j = 0; j < 2; ++j)
			for (int i = 0; i < maps.length; ++i)
				if (enables[i]) {
					System.out.print(String.format("%02d @[%d,%d]: ", ++no, j, i));
					test(maps[i], titles[i], loopCounts[i]);
					System.out.print(String.format("%02d @[%d,%d]: ", ++no, j, i));
					test(maps[i], titles[i], loopCounts[i]);
					System.out.print(String.format("%02d @[%d,%d]: ", ++no, j, i));
					test(maps[i], titles[i], loopCounts[i]);
					System.out.print(String.format("%02d @[%d,%d]: ", ++no, j, i));
					test(maps[i], titles[i], loopCounts[i]);
				}

		System.out.println("### end ###");
	}

	/**
	 * test.
	 *
	 * @param map
	 *            ICodeMap
	 * @param title
	 *            String
	 * @param loopCount
	 *            int
	 */
	public static void test(final ICodeMap map, final String title, final int loopCount) {
		// System.out.println("======================================================================");
		System.out.print(String.format("### %-10s### (0x%06x) ", title, loopCount));
		int n;
		n = map.get(0);
		if (n != ICodeMap.NOT_FOUND)
			throw new Error("WRONG DATA [0]=" + n);
		map.set(0, 0);
		n = map.get(0);
		map.set(0, n);

		n = map.get(0x12345678);
		if (n != ICodeMap.NOT_FOUND)
			throw new Error("WRONG DATA [0x12345678]=" + n);
		map.set(0x12345678, 0);
		n = map.get(0x12345678);
		map.clear();

		long sum = 0;
		long minTime = Long.MAX_VALUE;
		long maxTime = Long.MIN_VALUE;

		for (int k = 1; k <= MAX_TEST_COUNT; ++k) {
			long startTime = System.currentTimeMillis();

			for (int i = loopCount - 1; i >= 0; --i)
				map.set(i, i);
			for (int i = loopCount - 1; i >= 0; --i)
				if (i != map.get(i))
					throw new Error("WRONG DATA " + i);
			for (int i = 0; i < loopCount; ++i)
				if (i != map.get(i))
					throw new Error("WRONG DATA " + i);

			for (int i = 0; i < loopCount; ++i)
				map.set(i, i);
			for (int i = 0; i < loopCount; ++i)
				if (i != map.get(i))
					throw new Error("WRONG DATA " + i);
			for (int i = loopCount - 1; i >= 0; --i)
				if (i != map.get(i))
					throw new Error("WRONG DATA " + i);

			map.clear();

			for (int i = loopCount - 1; i >= 0; --i)
				map.set(i, i);
			for (int i = loopCount - 1; i >= 0; --i)
				if (i != map.get(i))
					throw new Error("WRONG DATA " + i);

			long deltaTime = System.currentTimeMillis() - startTime;
			if (minTime > deltaTime)
				minTime = deltaTime;
			if (maxTime < deltaTime)
				maxTime = deltaTime;
			sum += deltaTime;
		}
		// System.out.println("----------------------------------------------------------------------");
		System.out.print(String.format("\t avg %7.4f,", sum / 1000.0 / MAX_TEST_COUNT));
		System.out.print(String.format("  min %6.3f,", minTime / 1000.0));
		System.out.println(String.format("  max %6.3f", maxTime / 1000.0));
		// System.out.println("======================================================================");

		map.clear();
		System.gc();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
