package org.example;

import java.io.File;
import java.io.IOException;

public class PSCountTotal {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] vowels = {"A", "E", "I", "O", "U"};
        String[] outFile = new String[vowels.length];
        Process[] processes = new Process[vowels.length];
        for (int i = 0; i < vowels.length; i++) {
            ProcessBuilder pb = new ProcessBuilder();
            pb.command().add("java");
            pb.command().add("-cp");
            String classpath = System.getProperty("java.class.path");
            pb.command().add(classpath);
            pb.command().add(args[1]);
            pb.command().add(args[0]);
            pb.command().add(vowels[i]);
            outFile[i] = vowels[i] + ".txt";
            pb.command().add(outFile[i]);
            processes[i] = pb.start();
        }
        for (int j = 0; j < vowels.length; j++) {
            if (processes[j].isAlive()) {
                System.out.println(processes[j].waitFor());
            }
        }
    }
}
