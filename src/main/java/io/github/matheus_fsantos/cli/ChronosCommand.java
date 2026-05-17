package io.github.matheus_fsantos.cli;

import picocli.CommandLine.*;

@Command(name = "chronos", version = "1.0.0-SNAPSHOT")
public class ChronosCommand implements Runnable {
    @Option(names = {"-u", "--user"})
    String user;

    @Override
    public void run() {
        if(user == null)
            System.out.println("Hello, World!");
        else
            System.out.println(String.format("Hello, %s!", this.user));
    }
}
