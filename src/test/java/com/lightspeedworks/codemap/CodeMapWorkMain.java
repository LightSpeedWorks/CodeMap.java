package com.lightspeedworks.codemap;

/**
 * character code map. {文字コードマッピング}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class CodeMapWorkMain {
	/**
	 * max loop count.
	 */
	static final int MAX_LOOP_COUNT = 0x110000;

	/**
	 * max test count.
	 */
	static final int MAX_TEST_COUNT = 20;

	/**
	 * not found.
	 */
	static final int NOT_FOUND = CodeMap.NOT_FOUND;

	/**
	 * main.
	 *
	 * @param args
	 *            String...
	 */
	public static void main(String... args) {
		CodeMap map = new CodeMap();

		System.out.println("[0] = " + map.get(0));
		map.set(0, 0);
		System.out.println("[0] = " + map.get(0));
		System.out.println("[0x12345678] = " + map.get(0x12345678));
		map.set(0x12345678, 0);
		System.out.println("[0x12345678] = " + map.get(0x12345678));
		map.clear();

		long maxTime = Long.MIN_VALUE;
		long minTime = Long.MAX_VALUE;
		long sumTime = 0;

		for (int k = 0; k < MAX_TEST_COUNT; ++k) {
			map.clear();
			long startTime = System.currentTimeMillis();

			for (int i = 0; i < MAX_LOOP_COUNT; ++i)
				if (NOT_FOUND != map.get(i))
					throw new Error("WRONG DATA [" + i + "]=" + map.get(i));
			for (int i = 0; i < MAX_LOOP_COUNT; ++i)
				map.set(i, i);
			for (int i = 0; i < MAX_LOOP_COUNT; ++i)
				if (i != map.get(i))
					throw new Error("WRONG DATA");
			for (int i = MAX_LOOP_COUNT - 1; i >= 0; --i)
				if (i != map.get(i))
					throw new Error("WRONG DATA");

			map.clear();

			for (int i = MAX_LOOP_COUNT - 1; i >= 0; --i)
				map.set(i, i);
			for (int i = MAX_LOOP_COUNT - 1; i >= 0; --i)
				if (i != map.get(i))
					throw new Error("WRONG DATA");
			for (int i = 0; i < MAX_LOOP_COUNT; ++i)
				if (i != map.get(i))
					throw new Error("WRONG DATA");

			long deltaTime = System.currentTimeMillis() - startTime;
			if (deltaTime > maxTime) maxTime = deltaTime;
			if (deltaTime < minTime) minTime = deltaTime;
			sumTime += deltaTime;
			System.out.println(String.format(" %02d: %6.3f", k, deltaTime / 1000.0));
			System.gc();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(String.format("avg: %7.4f", sumTime / 1000.0 / MAX_TEST_COUNT));
		System.out.println(String.format("max: %6.3f", maxTime / 1000.0));
		System.out.println(String.format("min: %6.3f", minTime / 1000.0));
	}
}
