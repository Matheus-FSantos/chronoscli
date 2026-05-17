package io.github.matheus_fsantos;

import io.github.matheus_fsantos.cli.ChronosCommand;
import picocli.CommandLine;

public class ChronosCLIApplication {
    public static void main(String[] args) {
        new CommandLine(new ChronosCommand()).execute("--user=matheus");
    }
}
