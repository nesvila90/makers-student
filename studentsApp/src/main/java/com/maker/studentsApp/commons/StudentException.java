package com.maker.studentsApp.commons;

/**
 * The type Student exception.
 */
public class StudentException extends Exception {

    /**
     * Instantiates a new Student exception.
     *
     * @param s the s
     */
    public StudentException(String s) {
        super(s);
    }

    /**
     * Instantiates a new Student exception.
     *
     * @param s         the s
     * @param throwable the throwable
     */
    public StudentException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
