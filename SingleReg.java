package com.gq.regex;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SingleReg {

	public static void main(String[] args) {

		String line = "[A-Z0-9]{16}";
		String[] tokens = line.split(line);
		char[] pattern = new char[100];
		int i = 0;
		int len = tokens.length;
		String sep1 = "[{";
		StringTokenizer st = new StringTokenizer(line, sep1);

		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);

			if (token.contains("]")) {
				char[] endStr = null;

				if (!token.endsWith("]")) {
					String[] subTokens = token.split("]");
					token = subTokens[0];

					if (!subTokens[1].equalsIgnoreCase("*")) {
						endStr = subTokens[1].toCharArray();
					}
				}

				if (token.startsWith("^")) {
					String subStr = token.substring(1, token.length() - 1);
					char[] subChar = subStr.toCharArray();
					Set set = new HashSet<Character>();

					for (int p = 0; p < subChar.length; p++) {
						set.add(subChar[p]);
					}

					int asci = 1;

					while (true) {
						char newChar = (char) (subChar[0] + (asci++));

						if (!set.contains(newChar)) {
							pattern[i++] = newChar;
							break;
						}
					}
					if (endStr != null) {
						for (int r = 0; r < endStr.length; r++) {
							pattern[i++] = endStr[r];
						}
					}

				} else {
					pattern[i++] = token.charAt(0);
				}
			} else if (token.contains("}")) {
				char[] endStr = null;

				if (!token.endsWith("}")) {
					String[] subTokens = token.split("}");
					token = subTokens[0];

					if (!subTokens[1].equalsIgnoreCase("*")) {
						endStr = subTokens[1].toCharArray();
					}
				}

				int length = Integer.parseInt((new StringTokenizer(token, (",}"))).nextToken());
				char element = pattern[i - 1];

				for (int j = 0; j < length - 1; j++) {
					pattern[i++] = element;
				}

				if (endStr != null) {
					for (int r = 0; r < endStr.length; r++) {
						pattern[i++] = endStr[r];
					}
				}
			} else {
				char[] temp = token.toCharArray();

				for (int q = 0; q < temp.length; q++) {
					pattern[i++] = temp[q];
				}
			}
		}

		String result = "";

		for (int j = 0; j < i; j++) {
			result += pattern[j];
		}

		System.out.print(result);
	}
}
