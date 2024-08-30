package org.example;

public class ProblemV {

    public int add(int a, int b){
        return a + b;
    }

    public void testException() throws Exception {

        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("test");
        } finally {

            System.out.println("finally");
        }
    }

    public static void main(String[] args) throws Exception {

        new ProblemV().testException();
    }

}
