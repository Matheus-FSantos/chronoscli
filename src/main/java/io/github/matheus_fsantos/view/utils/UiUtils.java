package io.github.matheus_fsantos.view.utils;


public class UiUtils {
    private UiUtils() { }

    public static String empty(int repeat) { return " ".repeat(repeat); }

    public static String hLine(int repeat) { return "\u2500".repeat(repeat); }

    public static String vLine(int repeat) { return "\u2502".repeat(repeat); }

    public static String hLeftDividerLine(int repeat) { return "\u251C".repeat(repeat); }

    public static String hRightDividerLine(int repeat) { return "\u2524".repeat(repeat); }

    public static String bLeftTop(int repeat) { return "\u250C".repeat(repeat); }

    public static String bRightTop(int repeat) { return "\u2510".repeat(repeat); }
}
