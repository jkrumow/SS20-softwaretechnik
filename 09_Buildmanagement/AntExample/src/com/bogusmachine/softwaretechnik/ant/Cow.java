package com.bogusmachine.softwaretechnik.ant;

/**
 * This class describes a cow. I knows how to greet and make a sound.
 */
public class Cow {

	/**
	 * Prints a typical cow greeting onto the console.
	 */
	public void greet() {
		System.out.println(getGreeting());
	}

	/**
	 * Returns its typical cow greeting as a string.
	 * 
	 * @return The typical cow greeting.
	 */
	public String getGreeting() {
		return "MOO!";
	}

	/**
	 * The main entry point of this class. Creates a cow and lets it greet.
	 * 
	 * @param args Passed arguments. Currently none.
	 */
	public static void main(String[] args) {
		Cow cow = new Cow();
		cow.greet();
	}
}
